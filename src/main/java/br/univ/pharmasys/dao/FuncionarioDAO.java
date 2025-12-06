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
import br.univ.pharmasys.util.ConnectionFactory;

public class FuncionarioDAO {

    public void create(Funcionario fun) {
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        long idTel;

        Telefone tel = telefoneDAO.buscarPorNumero(fun.getTelefone());

        if (tel != null) {
            idTel = tel.getIdTelefone();
        } else {
            Telefone novoTelefone = new Telefone();
            novoTelefone.setNumeroTelefone(fun.getTelefone());
            idTel = telefoneDAO.create(novoTelefone);
        }

        String sql = "INSERT INTO FUNCIONARIO (CPF, DATA_NASCIMENTO, SEXO, NOME, TIPO, TELEFONE_ID) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar Funcionário: " + e.getMessage(), e);
        }
    }

    public List<Funcionario> buscarPorNome(String nome) {
        String sql = "SELECT F.*, T.NUMERO AS NUMERO_TELEFONE " +
                     "FROM FUNCIONARIO F " +
                     "INNER JOIN TELEFONE T ON F.TELEFONE_ID = T.TELEFONE_ID " +
                     "WHERE F.NOME LIKE ?";
        
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
                    
                    java.sql.Date sqlDate = rs.getDate("DATA_NASCIMENTO");
                    if (sqlDate != null) {
                        fun.setDataNascimento(sqlDate.toLocalDate());
                    }
                    fun.setSexo(rs.getString("SEXO"));
                    fun.setTipo(rs.getInt("TIPO"));
                    fun.setTelefone(rs.getString("NUMERO_TELEFONE"));

                    lista.add(fun);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Funcionário por nome: " + e.getMessage(), e);
        }
        return lista;
    }

    public void update(Funcionario fun) {
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        long idTel;

        Telefone tel = telefoneDAO.buscarPorNumero(fun.getTelefone());

        if (tel != null) {
            idTel = tel.getIdTelefone();
        } else {
            Telefone novoTelefone = new Telefone();
            novoTelefone.setNumeroTelefone(fun.getTelefone());
            idTel = telefoneDAO.create(novoTelefone);
        }

        String sql = "UPDATE FUNCIONARIO SET CPF = ?, DATA_NASCIMENTO = ?, SEXO = ?, "
                   + "NOME = ?, TIPO = ?, TELEFONE_ID = ? WHERE ID_FUNCIONARIO = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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
            
            stmt.setLong(7, fun.getIdFuncionario());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Funcionário: " + e.getMessage(), e);
        }
    }

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
}