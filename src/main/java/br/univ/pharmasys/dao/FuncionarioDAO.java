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

    // Método para pegar ID do telefone ou criar se não existir
    private long pegarTelefoneId(String numeroTelefone, Connection conn) throws SQLException {
        Telefone existente = telefoneDAO.buscarPorNumero(numeroTelefone);
        if (existente != null) {
            return existente.getIdTelefone();
        }
        Telefone novo = new Telefone();
        novo.setNumeroTelefone(numeroTelefone);
        return telefoneDAO.create(novo, conn); 
    }

    // Criação do funcionário no banco de dados
    public void create(Funcionario fun) {

        String senhaHash = SenhaUtil.hashPassword(fun.getSenha().trim());

        String sql = """
            INSERT INTO FUNCIONARIO 
            (CPF, DATA_NASCIMENTO, SEXO, NOME, EMAIL, TIPO, TELEFONE_ID, SENHA)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
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
            stmt.setString(5, fun.getEmail());
            stmt.setInt(6, fun.getTipo());
            stmt.setLong(7, idTel);
            stmt.setString(8, senhaHash);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar Funcionario: " + e.getMessage(), e);
        }
    }
 
    // Lista todos os funcionários
    public List<Funcionario> listarTodos() {
        String sql = """
            SELECT F.*, T.NUMERO AS NUMERO_TELEFONE
            FROM FUNCIONARIO F
            INNER JOIN TELEFONE T ON F.TELEFONE_ID = T.TELEFONE_ID
            ORDER BY F.NOME
        """;

        List<Funcionario> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(montarFuncionario(rs)); // Reutiliza a lógica de montagem
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os funcionários: " + e.getMessage(), e);
        }
        return lista;
    }
    // Busca funcionário por nome
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
                    lista.add(montarFuncionario(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Funcionário por nome: " + e.getMessage(), e);
        }

        return lista;
    }
    // Busca funcionário por CPF
    public Funcionario buscarPorCpf(String cpf) {
        String sql = """
            SELECT F.*, T.NUMERO AS NUMERO_TELEFONE
            FROM FUNCIONARIO F
            INNER JOIN TELEFONE T ON F.TELEFONE_ID = T.TELEFONE_ID
            WHERE F.CPF = ?
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String cpfLimpo = cpf.replaceAll("\\D", "");
            stmt.setString(1, cpfLimpo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return montarFuncionario(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Funcionário por CPF: " + e.getMessage(), e);
        }
        
        return null;
    }
    // Atualização dos dados do funcionário
    public void update(Funcionario fun) {

        boolean trocarSenha = fun.getSenha() != null && !fun.getSenha().trim().isEmpty();

        StringBuilder sql = new StringBuilder("""
            UPDATE FUNCIONARIO 
            SET CPF=?, DATA_NASCIMENTO=?, SEXO=?, NOME=?, EMAIL=?, TIPO=?, TELEFONE_ID=?
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
            stmt.setString(5, fun.getEmail()); 
            stmt.setInt(6, fun.getTipo());
            stmt.setLong(7, idTel);

            int index = 8;

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

    // Deleção do funcionário
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

    // Autenticação do funcionário
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
                if (!rs.next()) return null;

                String hashArmazenado = rs.getString("SENHA");
                if (hashArmazenado == null) return null;

                if (!SenhaUtil.verifyPassword(senhaDigitada, hashArmazenado)) {
                    return null;
                }

                return montarFuncionario(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao autenticar: " + e.getMessage(), e);
        }
    }
    
    private Funcionario montarFuncionario(ResultSet rs) throws SQLException {
        Funcionario fun = new Funcionario();
        fun.setIdFuncionario(rs.getLong("ID_FUNCIONARIO"));
        fun.setNome(rs.getString("NOME"));
        fun.setCpf(rs.getString("CPF"));
        fun.setSexo(rs.getString("SEXO"));
        fun.setEmail(rs.getString("EMAIL"));
        fun.setTipo(rs.getInt("TIPO"));
        fun.setTelefone(rs.getString("NUMERO_TELEFONE"));

        Date sqlDate = rs.getDate("DATA_NASCIMENTO");
        if (sqlDate != null) {
            fun.setDataNascimento(sqlDate.toLocalDate());
        }
        return fun;
    }
}