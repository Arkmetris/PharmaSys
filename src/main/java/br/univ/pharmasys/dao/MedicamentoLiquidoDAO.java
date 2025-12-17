package br.univ.pharmasys.dao;
import br.univ.pharmasys.model.MedicamentoInjetavel;
import br.univ.pharmasys.model.MedicamentoLiquido;
import br.univ.pharmasys.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoLiquidoDAO extends MedicamentoDAO {

    //metodo de buscar o medicamento liquido
    public MedicamentoLiquido buscarPorSku(String sku) {
        String sql = "SELECT m.*, ml.VOLUME_ML, ml.TIPO_RECIPIENTE " +
                "FROM MEDICAMENTO m " +
                "INNER JOIN MEDICAMENTO_LIQUIDO ml ON m.SKU = ml.SKU " +
                "WHERE m.SKU = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sku);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                MedicamentoLiquido liq = new MedicamentoLiquido();
                liq.setSku(rs.getString("SKU"));
                liq.setNomeComercial(rs.getString("NOME_COMERCIAL"));
                liq.setDosagem(rs.getString("DOSAGEM"));
                liq.setFormaFarmaceutica(rs.getString("FORMA_FARMACEUTICA"));
                liq.setFabricante(rs.getString("FABRICANTE"));
                liq.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
                liq.setLaboratorio(rs.getString("LABORATORIO"));
                liq.setEstoqueMax(rs.getInt("ESTOQUE_MAX"));
                liq.setEstoqueMin(rs.getInt("ESTOQUE_MIN"));
                liq.setEstoqueAtual(rs.getInt("ESTOQUE_ATUAL"));
                liq.setPreco(rs.getBigDecimal("PRECO"));

                if (rs.getDate("DATA_EXPIRACAO") != null) {
                    liq.setDataExpiracao(rs.getDate("DATA_EXPIRACAO").toLocalDate());
                }
                liq.setVolumeMl(rs.getDouble("VOLUME_ML"));
                liq.setTipoRecipiente(rs.getString("TIPO_RECIPIENTE"));

                return liq;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar medicamento líquido: " + e.getMessage(), e);
        }
        return null;
    }

    //metodo de criar um medicamento liquido(create)
    public void create(MedicamentoLiquido liq) {
        super.create(liq);

        String sql = "INSERT INTO MEDICAMENTO_LIQUIDO (SKU, VOLUME_ML, TIPO_RECIPIENTE) VALUES (?,?,?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, liq.getSku());
            stmt.setDouble(2, liq.getVolumeMl());
            stmt.setString(3, liq.getTipoRecipiente());

            stmt.executeUpdate();
            System.out.println("MedicamentoLiquido salvo com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar detalhes do líquido: " + e.getMessage(), e);
        }
    }

    public List<MedicamentoLiquido> listarLiquidos() {
        String sql = "SELECT m.*, ml.VOLUME_ML, ml.TIPO_RECIPIENTE " +
                "FROM MEDICAMENTO m " +
                "INNER JOIN MEDICAMENTO_LIQUIDO ml ON m.SKU = ml.SKU";

        List<MedicamentoLiquido> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(montarLiquido(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os injetáveis: " + e.getMessage(), e);
        }
        return lista;
    }


    //metodo de atualizar as info do medicamento liquido (update)
    public void update(MedicamentoLiquido liq) {
        super.update(liq);

        String sql = "UPDATE MEDICAMENTO_LIQUIDO SET VOLUME_ML = ?, TIPO_RECIPIENTE = ? WHERE SKU = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, liq.getVolumeMl());
            stmt.setString(2, liq.getTipoRecipiente());
            stmt.setString(3, liq.getSku());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar MedicamentoLiquido: " + e.getMessage(), e);
        }
    }

    //metodo de deletar tanto da classe pai e da classe filha (delete)
    @Override
    public void delete(String sku) {
        String sqlFilha = "DELETE FROM MEDICAMENTO_LIQUIDO WHERE SKU=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlFilha)) {

            stmt.setString(1, sku);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar MedicamentoLiquido: " + e.getMessage(), e);
        }

        super.delete(sku);
    }

    private MedicamentoLiquido montarLiquido(ResultSet rs) throws SQLException {
        MedicamentoLiquido liquido= new MedicamentoLiquido();

        //Vai fazer o corpo do Medicamento no BD

        liquido.setNomeComercial(rs.getString("NOME_COMERCIAL"));
        liquido.setSku(rs.getString("SKU"));
        liquido.setDosagem(rs.getString("DOSAGEM"));
        liquido.setFormaFarmaceutica(rs.getString("FORMA_FARMACEUTICA"));
        liquido.setFabricante(rs.getString("FABRICANTE")); // corrigido
        liquido.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
        liquido.setLaboratorio(rs.getString("LABORATORIO"));
        liquido.setEstoqueMax(rs.getInt("ESTOQUE_MAX"));
        liquido.setEstoqueMin(rs.getInt("ESTOQUE_MIN"));
        liquido.setEstoqueAtual(rs.getInt("ESTOQUE_ATUAL"));
        liquido.setPreco(rs.getBigDecimal("PRECO"));

        Date sqlDate = rs.getDate("DATA_EXPIRACAO");
        if (sqlDate != null) {
            liquido.setDataExpiracao(sqlDate.toLocalDate());
        }

        liquido.setVolumeMl(rs.getDouble("VOLUME_ML"));
        liquido.setTipoRecipiente(rs.getString("TIPO_RECIPIENTE"));

        return liquido;
    }
}