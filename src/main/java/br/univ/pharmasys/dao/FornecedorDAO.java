package br.univ.pharmasys.dao;

import br.univ.pharmasys.model.Fornecedor;

import br.univ.pharmasys.model.Telefone;
import br.univ.pharmasys.util.ConnectionFactory;


import java.sql.*;

import java.util.ArrayList;
import java.util.List;
public class FornecedorDAO {

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

    //Criação do banco de dados de Fornecedor

    public void create(Fornecedor fornecedor) {

        String sql = "INSERT INTO FORNECEDOR (NOME, CNPJ, EMAIL, TELEFONE_ID, ESTADO, CEP, RUA, BAIRRO, CIDADE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {


            long idTelefone = pegarTelefoneId(fornecedor.getTelefoneId(), conn);

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setLong(4, idTelefone);
            stmt.setString(5, fornecedor.getEstado());
            stmt.setString(6, fornecedor.getCep());
            stmt.setString(7, fornecedor.getRua());
            stmt.setString(8, fornecedor.getBairro());
            stmt.setString(9, fornecedor.getCidade());


            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    long id = rs.getLong(1);
                    fornecedor.setIdFornecedor(id);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error ao salvar fornecedor" + e.getMessage(), e);
        }
    }

    public List<Fornecedor> listarTodos() {

        String sql = """
                    SELECT F.*, T.NUMERO AS NUMERO_TELEFONE
                    FROM FORNECEDOR F
                    INNER JOIN TELEFONE T ON F.TELEFONE_ID = T.TELEFONE_ID
                    ORDER BY F.NOME
                """;

        List<Fornecedor> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(montarFornecedor(rs)); // Reutiliza a lógica de montagem que já está em FuncionarioDAO
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os fornecedores: " + e.getMessage(), e);
        }
        return lista;
    }

    public List<Fornecedor> buscarNomes(String nome) {

        String sql = """
                    SELECT F.*, T.NUMERO AS NUMERO_TELEFONE
            FROM FORNECEDOR F
            INNER JOIN TELEFONE T ON F.TELEFONE_ID = T.TELEFONE_ID
            WHERE F.NOME LIKE ?
        """;

        List<Fornecedor> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(montarFornecedor(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Fornecedor por nome: " + e.getMessage(), e);
        }
        return lista;
    }

    // Busca fornecedor por Cnpj
    public Fornecedor buscarPorCnpj(String cnpj) {
        String sql = """
            SELECT F.*, T.NUMERO AS NUMERO_TELEFONE
            FROM FORNECEDOR F
            INNER JOIN TELEFONE T ON F.TELEFONE_ID = T.TELEFONE_ID
            WHERE F.CNPJ = ?
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String cpfLimpo = cnpj.replaceAll("\\D", "");
            stmt.setString(1, cpfLimpo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return montarFornecedor(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Fornecedor por cnpj  : " + e.getMessage(), e);
        }

        return null;
    }

    public void update (Fornecedor fornecedor) {
        String sql = """
                    UPDATE FORNECEDOR F
                    SET CNPJ =?, NOME=?, EMAIL = ?, TELEFONE_ID = ?, BAIRRO = ?, ESTADO = ?, CEP = ?, RUA = ?, CIDADE = ?
                    WHERE ID_FORNECEDOR = ?
        """;


        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            long idTel = pegarTelefoneId(fornecedor.getTelefoneId(), conn);

            stmt.setString(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setLong(4, idTel);
            stmt.setString(5, fornecedor.getBairro());
            stmt.setString(6, fornecedor.getEstado());
            stmt.setString(7, fornecedor.getCep());
            stmt.setString(8, fornecedor.getRua());
            stmt.setString(9, fornecedor.getCidade());
            stmt.setLong(10, fornecedor.getIdFornecedor()); // faltava




            stmt.executeUpdate();
            System.out.println("Fornecedor atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Fornecedor: " + e.getMessage(), e);
        }
    }

    // Deleção do fornecedor
    public void delete(long idFornecedor) {
        String sql = "DELETE FROM FORNECEDOR WHERE ID_FORNECEDOR= ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, idFornecedor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Funcionário: " + e.getMessage(), e);
        }
    }
    //Aqui é a montagem do fornecedor, pegando os valores e passando pro BD
    private Fornecedor montarFornecedor(ResultSet rs) throws SQLException {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setIdFornecedor(rs.getLong("ID_FORNECEDOR"));
        fornecedor.setNome(rs.getString("NOME"));
        fornecedor.setCnpj(rs.getString("CNPJ"));
        fornecedor.setBairro(rs.getString("BAIRRO"));
        fornecedor.setEmail(rs.getString("EMAIL"));
        fornecedor.setEstado(rs.getString("ESTADO"));
        fornecedor.setTelefoneId(rs.getString("NUMERO_TELEFONE"));
        fornecedor.setCep(rs.getString("CEP"));
        fornecedor.setCidade(rs.getString("CIDADE"));
        fornecedor.setRua(rs.getString("RUA"));


        return fornecedor;
    }
}
