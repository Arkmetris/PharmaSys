package br.univ.pharmasys.dao;

import br.univ.pharmasys.model.Dependente;
import br.univ.pharmasys.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DependenteDAO {

    private static final String INSERT_SQL = "INSERT INTO dependente (cpf_funcionario, nome, parentesco, data_nascimento) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE dependente SET cpf_funcionario = ?, nome = ?, parentesco = ?, data_nascimento = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM dependente WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM dependente";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM dependente WHERE id = ?";
    private static final String SELECT_BY_FUNC_CPF = "SELECT * FROM dependente WHERE cpf_funcionario = ?";

    // 1 Salvar
    public void salvar(Dependente dependente) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, dependente.getCpfFuncionario());
            stmt.setString(2, dependente.getNome());
            stmt.setString(3, dependente.getParentesco());
            
            // Conversão de LocalDate para java.sql.Date
            stmt.setDate(4, Date.valueOf(dependente.getDataNascimento()));

            stmt.executeUpdate();

            // Recupera o ID gerado pelo banco para atualizar o objeto
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    dependente.setId(generatedKeys.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar dependente: " + e.getMessage(), e);
        }
    }

    public void atualizar(Dependente dependente) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {

            stmt.setString(1, dependente.getCpfFuncionario());
            stmt.setString(2, dependente.getNome());
            stmt.setString(3, dependente.getParentesco());
            stmt.setDate(4, Date.valueOf(dependente.getDataNascimento()));
            stmt.setLong(5, dependente.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dependente: " + e.getMessage(), e);
        }
    }

    public void deletar(Long id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_SQL)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar dependente: " + e.getMessage(), e);
        }
    }

    // 4 Buscar por ID
    public Dependente buscarPorId(Long id) {
        Dependente dependente = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {

            stmt.setLong(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    dependente = mapearResultSet(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar dependente por ID: " + e.getMessage(), e);
        }

        return dependente;
    }

    // 5 Lista tudo
    public List<Dependente> listarTodos() {
        List<Dependente> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearResultSet(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar dependentes: " + e.getMessage(), e);
        }

        return lista;
    }

    // 6 listar por Funcionário
    public List<Dependente> listarPorCpfFuncionario(String cpfFuncionario) {
        List<Dependente> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_FUNC_CPF)) {

            stmt.setString(1, cpfFuncionario);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearResultSet(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar dependentes do funcionário: " + e.getMessage(), e);
        }

        return lista;
    }

    private Dependente mapearResultSet(ResultSet rs) throws SQLException {
        Dependente d = new Dependente();
        
        d.setId(rs.getLong("id"));
        
        d.setCpfFuncionario(rs.getString("cpf_funcionario")); 
        
        d.setNome(rs.getString("nome"));
        d.setParentesco(rs.getString("parentesco"));
        
        // Conversão de java.sql.Date para LocalDate
        if (rs.getDate("data_nascimento") != null) {
            d.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
        }

        return d;
    }
}