package br.univ.pharmasys.dao;

import br.univ.pharmasys.model.Medicamento;
import br.univ.pharmasys.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDAO {


    public void create(Medicamento med) {

        String sql = "INSERT INTO MEDICAMENTO (NOME_COMERCIAL, SKU, DOSAGEM, FORMA_FARMACEUTICA, FABRICANTE, "
                + "CODIGO_BARRAS, LABORATORIO, ESTOQUE_MAX, ESTOQUE_MIN, ESTOQUE_ATUAL, DATA_EXPIRACAO, PRECO) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, med.getNomeComercial());
            stmt.setString(2, med.getSku());
            stmt.setString(3, med.getDosagem());
            stmt.setString(4, med.getFormaFarmaceutica());
            stmt.setString(5, med.getFabricante());
            stmt.setString(6, med.getCodigoBarras());
            stmt.setString(7, med.getLaboratorio());
            stmt.setInt(8, med.getEstoqueMax());
            stmt.setInt(9, med.getEstoqueMin());
            stmt.setInt(10, med.getEstoqueAtual());
            stmt.setDate(11, Date.valueOf(med.getDataExpiracao()));
            stmt.setBigDecimal(12, med.getPreco());


            stmt.executeUpdate();
            System.out.println("Medicamento salvo com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar medicamento: " + e.getMessage(), e);
        }
    }

    public Medicamento buscarPorSku(String sku) {

        String sql = "SELECT * FROM MEDICAMENTO WHERE SKU = ?";
        Medicamento med = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sku);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    med = new Medicamento();

                    med.setNomeComercial(rs.getString("NOME_COMERCIAL"));
                    med.setSku(rs.getString("SKU"));
                    med.setDosagem(rs.getString("DOSAGEM"));
                    med.setFormaFarmaceutica(rs.getString("FORMA_FARMACEUTICA"));
                    med.setFabricante(rs.getString("FABRICANTE"));
                    med.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
                    med.setLaboratorio(rs.getString("LABORATORIO"));
                    med.setEstoqueMax(rs.getInt("ESTOQUE_MAX"));
                    med.setEstoqueMin(rs.getInt("ESTOQUE_MIN"));
                    med.setEstoqueAtual(rs.getInt("ESTOQUE_ATUAL"));
                    med.setPreco(rs.getBigDecimal("PRECO"));


                    if (rs.getDate("DATA_EXPIRACAO") != null) {
                        med.setDataExpiracao(rs.getDate("DATA_EXPIRACAO").toLocalDate());
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar medicamento por SKU: " + e.getMessage(), e);
        }
        return med;
    }

    public List<Medicamento> buscarPorNome(String nome) {

        String sql = "SELECT * FROM MEDICAMENTO WHERE NOME_COMERCIAL = ?";
        List<Medicamento> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    Medicamento med = new Medicamento();

                    med.setNomeComercial(rs.getString("NOME_COMERCIAL"));
                    med.setSku(rs.getString("SKU"));
                    med.setDosagem(rs.getString("DOSAGEM"));
                    med.setFormaFarmaceutica(rs.getString("FORMA_FARMACEUTICA"));
                    med.setFabricante(rs.getString("FABRICANTE")); // corrigido
                    med.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
                    med.setLaboratorio(rs.getString("LABORATORIO"));
                    med.setEstoqueMax(rs.getInt("ESTOQUE_MAX"));
                    med.setEstoqueMin(rs.getInt("ESTOQUE_MIN"));
                    med.setEstoqueAtual(rs.getInt("ESTOQUE_ATUAL"));
                    med.setPreco(rs.getBigDecimal("PRECO"));
                    //med.setLoteId(rs.getObject("LOTE_ID", Integer.class));

                    if (rs.getDate("DATA_EXPIRACAO") != null) {
                        med.setDataExpiracao(rs.getDate("DATA_EXPIRACAO").toLocalDate());
                    }

                    lista.add(med);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar medicamento por Nome: " + e.getMessage(), e);
        }
        return lista;
    }


    public void update(Medicamento med) {

        String sql = "UPDATE MEDICAMENTO SET NOME_COMERCIAL=?, DOSAGEM=?, FORMA_FARMACEUTICA=?, FABRICANTE=?, "
                + "CODIGO_BARRAS=?, LABORATORIO=?, ESTOQUE_MAX=?, ESTOQUE_MIN=?, ESTOQUE_ATUAL=?, DATA_EXPIRACAO=?, "
                + "PRECO=?, WHERE SKU=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, med.getNomeComercial());
            stmt.setString(2, med.getDosagem());
            stmt.setString(3, med.getFormaFarmaceutica());
            stmt.setString(4, med.getFabricante());
            stmt.setString(5, med.getCodigoBarras());
            stmt.setString(6, med.getLaboratorio());
            stmt.setInt(7, med.getEstoqueMax());
            stmt.setInt(8, med.getEstoqueMin());
            stmt.setInt(9, med.getEstoqueAtual());
            stmt.setDate(10, Date.valueOf(med.getDataExpiracao()));
            stmt.setBigDecimal(11, med.getPreco());

            stmt.setString(13, med.getSku());

            stmt.executeUpdate();
            System.out.println("Medicamento atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar medicamento: " + e.getMessage(), e);
        }
    }


    public void delete(String sku) {
        String sql = "DELETE FROM MEDICAMENTO WHERE SKU = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sku);
            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Medicamento excluído com sucesso!");
            } else {
                System.out.println("Nenhum medicamento encontrado com o SKU informado.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir medicamento: " + e.getMessage(), e);
        }
    }
}
