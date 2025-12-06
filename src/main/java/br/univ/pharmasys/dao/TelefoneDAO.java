package br.univ.pharmasys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univ.pharmasys.model.Telefone;
import br.univ.pharmasys.util.ConnectionFactory;

public class TelefoneDAO {

    public long create(Telefone telefone) {
        String sql = "INSERT INTO TELEFONE (NUMERO) VALUES (?)";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, telefone.getNumeroTelefone());
            
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    long idGerado = rs.getLong(1);
                    telefone.setIdTelefone(idGerado);
                    return idGerado;
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar Telefone: " + e.getMessage(), e);
        }
        throw new RuntimeException("Nenhuma chave gerada ao salvar telefone.");
    }

    public Telefone buscarPorNumero(String numero) {
        String sql = "SELECT * FROM TELEFONE WHERE NUMERO = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, numero);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
  
                    Telefone tel = new Telefone();
                    tel.setIdTelefone(rs.getLong("TELEFONE_ID"));
                    tel.setNumeroTelefone(rs.getString("NUMERO"));
                    return tel;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Telefone por número: " + e.getMessage(), e);
        }
        return null;
    }
    
    public Telefone buscarPorId(long id) {
        String sql = "SELECT * FROM TELEFONE WHERE TELEFONE_ID = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    Telefone tel = new Telefone();
                    tel.setIdTelefone(rs.getLong("TELEFONE_ID"));
                    tel.setNumeroTelefone(rs.getString("NUMERO"));
                    return tel;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Telefone por ID: " + e.getMessage(), e);
        }
        return null;
    }

    public List<Telefone> listarTodos() {
        String sql = "SELECT * FROM TELEFONE";
        List<Telefone> lista = new ArrayList<>();
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Telefone tel = new Telefone();
                tel.setIdTelefone(rs.getLong("TELEFONE_ID"));
                tel.setNumeroTelefone(rs.getString("NUMERO"));
                lista.add(tel);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Telefones: " + e.getMessage(), e);
        }
        return lista;
    }


    public void update(Telefone telefone) {
        String sql = "UPDATE TELEFONE SET NUMERO = ? WHERE TELEFONE_ID = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, telefone.getNumeroTelefone());
            stmt.setLong(2, telefone.getIdTelefone());
            
            stmt.executeUpdate();
            System.out.println("Telefone atualizado com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Telefone: " + e.getMessage(), e);
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM TELEFONE WHERE TELEFONE_ID = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            
            stmt.executeUpdate();
            System.out.println("Telefone excluído com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Telefone: " + e.getMessage(), e);
        }
    }
}