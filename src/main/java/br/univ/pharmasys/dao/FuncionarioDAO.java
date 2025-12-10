package br.univ.pharmasys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univ.pharmasys.model.Funcionario;
import br.univ.pharmasys.model.Telefone;
import br.univ.pharmasys.util.SenhaUtil;
import br.univ.pharmasys.util.ConnectionFactory;

public class FuncionarioDAO {

    private final TelefoneDAO telefoneDAO = new TelefoneDAO();

    //Método para pegar o ID do telefone ou criar um novo se não existir
    private long pegarTelefoneId(String numeroTelefone, Connection conn) throws SQLException {

        Telefone existente = telefoneDAO.buscarPorNumero(numeroTelefone);

        if (existente != null) {
            return existente.getIdTelefone();
        }

        Telefone novo = new Telefone();
        novo.setNumeroTelefone(numeroTelefone);
        return telefoneDAO.create(novo, conn);
    }

	//Criação do funcionário no banco de dados
    public void create(Funcionario fun) {

        String senhaHash = SenhaUtil.hashPassword(fun.getSenha().trim());

        String sql = """
            INSERT INTO FUNCIONARIO 
            (CPF, DATA_NASCIMENTO, SEXO, NOME, TIPO, TELEFONE_ID, SENHA)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

        	long idTel = pegarTelefoneId(fun.getTelefone(), conn);

        	stmt.setString(1, fun.getCpf());

            if (fun.getDataNascimento() != null) {
                stmt.setDate(2, Date.valueOf(fun.getDataNascimento()));
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            stmt.setString(3, fun.getSexo());
            stmt.setString(4, fun.getNome());
            stmt.setInt(5, fun.getTipo());
            stmt.setLong(6, idTel);
            stmt.setString(7, senhaHash);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar Funcionario: " + e.getMessage(), e);
        }
    }

	//Busca funcionário por nome
    public List<Funcionario> buscarPorNome(String nome) {

        String sql = """
            SELECT F.*, T.NUMERO AS NUMERO_TELEFONE
            FROM FUNCIONARIO F
            INNER JOIN TELEFONE T ON F.TELEFONE_ID = T.TELEFONE_ID
            WHERE F.NOME LIKE ?
        """;

        List<Funcionario> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Funcionario fun = new Funcionario();
                    fun.setIdFuncionario(rs.getLong("ID_FUNCIONARIO"));
                    fun.setNome(rs.getString("NOME"));
                    fun.setCpf(rs.getString("CPF"));
                    fun.setSexo(rs.getString("SEXO"));
                    fun.setTipo(rs.getInt("TIPO"));
                    fun.setTelefone(rs.getString("NUMERO_TELEFONE"));

                    Date sqlDate = rs.getDate("DATA_NASCIMENTO");
                    if (sqlDate != null) {
                        fun.setDataNascimento(sqlDate.toLocalDate());
                    }

                    lista.add(fun);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Funcionário por nome: " + e.getMessage(), e);
        }

        return lista;
    }

    //Atualização dos dados do funcionário
    public void update(Funcionario fun) {


        boolean trocarSenha = fun.getSenha() != null && !fun.getSenha().trim().isEmpty();

        StringBuilder sql = new StringBuilder("""
            UPDATE FUNCIONARIO 
            SET CPF=?, DATA_NASCIMENTO=?, SEXO=?, NOME=?, TIPO=?, TELEFONE_ID=?
        """);

        if (trocarSenha) {
            sql.append(", SENHA=?");
        }

        sql.append(" WHERE ID_FUNCIONARIO=?");

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

        	long idTel = pegarTelefoneId(fun.getTelefone(), conn);

        	stmt.setString(1, fun.getCpf());

            if (fun.getDataNascimento() != null) {
                stmt.setDate(2, Date.valueOf(fun.getDataNascimento()));
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            stmt.setString(3, fun.getSexo());
            stmt.setString(4, fun.getNome());
            stmt.setInt(5, fun.getTipo());
            stmt.setLong(6, idTel);

            int index = 7;

            if (trocarSenha) {
                String senhaHash = SenhaUtil.hashPassword(fun.getSenha().trim());
                stmt.setString(index++, senhaHash);
            }

            stmt.setLong(index, fun.getIdFuncionario());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Funcionário: " + e.getMessage(), e);
        }
    }

    //Deleção do funcionário do banco de dados
    public void delete(long idFuncionario) {

        String sql = "DELETE FROM FUNCIONARIO WHERE ID_FUNCIONARIO = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, idFuncionario);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Funcionário: " + e.getMessage(), e);
        }
    }

    //Autenticação do funcionário
    public Funcionario autenticar(String login, String senhaDigitada) {

        String sql = """
            SELECT F.*, T.NUMERO AS NUMERO_TELEFONE
            FROM FUNCIONARIO F
            INNER JOIN TELEFONE T ON F.TELEFONE_ID = T.TELEFONE_ID
            WHERE F.CPF = ?
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String cpfNormalizado = login.replaceAll("\\D", "");
            stmt.setString(1, cpfNormalizado);

            try (ResultSet rs = stmt.executeQuery()) {

                if (!rs.next()) {
                    return null; // CPF não existe
                }

                String hashArmazenado = rs.getString("SENHA");
                if (hashArmazenado == null) {
                    return null;
                }

                // VERIFICAÇÃO DA SENHA
                boolean senhaCorreta = SenhaUtil.verifyPassword(senhaDigitada, hashArmazenado);
                if (!senhaCorreta) {
                    return null;
                }

                Funcionario fun = new Funcionario();
                fun.setIdFuncionario(rs.getLong("ID_FUNCIONARIO"));
                fun.setNome(rs.getString("NOME"));
                fun.setCpf(rs.getString("CPF"));
                fun.setSexo(rs.getString("SEXO"));
                fun.setTipo(rs.getInt("TIPO"));
                fun.setTelefone(rs.getString("NUMERO_TELEFONE"));

                Date sqlDate = rs.getDate("DATA_NASCIMENTO");
                if (sqlDate != null) {
                    fun.setDataNascimento(sqlDate.toLocalDate());
                }

                return fun;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao autenticar: " + e.getMessage(), e);
        }
    }
}