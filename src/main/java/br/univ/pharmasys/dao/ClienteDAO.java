package br.univ.pharmasys.dao;

import br.univ.pharmasys.model.Cliente;
import br.univ.pharmasys.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {

    public void create(Cliente cliente){
        String sql = "INSERT INTO CLIENTE (CPF_CLIENTE, NOME, SEXO) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getSexo());

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar Cliente: " + e.getMessage(), e);
        }
    }

    public Cliente buscarPorCpf(String cpf){
        String sql = "SELECT * FROM CLIENTE WHERE CPF_CLIENTE = ?";
        Cliente cliente = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setCpf(rs.getString("CPF_CLIENTE"));
                    cliente.setNome(rs.getString("NOME"));
                    cliente.setSexo(rs.getString("SEXO"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Cliente por CPF: " + e.getMessage(), e);
        }
        return cliente;
    }
    public List<Cliente> buscarPorNome(String nome) {
        String sql = "SELECT * FROM CLIENTE WHERE NOME LIKE ?";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, "%" + nome + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setCpf(rs.getString("CPF_CLIENTE"));
                    cliente.setNome(rs.getString("NOME"));
                    cliente.setSexo(rs.getString("SEXO"));

                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar clientes por nome: " + e.getMessage(), e);
        }
        return clientes;
    }

    public void update(Cliente cliente) {
        String sql = "UPDATE CLIENTE SET NOME = ?, SEXO = ? WHERE CPF_CLIENTE = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSexo());
            stmt.setString(3, cliente.getCpf()); // O CPF vai no WHERE

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Cliente: " + e.getMessage(), e);
        }
    }

    public void delete(String cpf) {
        String sql = "DELETE FROM CLIENTE WHERE CPF_CLIENTE = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Cliente: " + e.getMessage(), e);
        }
    }
}

