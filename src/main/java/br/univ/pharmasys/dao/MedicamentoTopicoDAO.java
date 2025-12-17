package br.univ.pharmasys.dao;

import br.univ.pharmasys.model.MedicamentoTopico;
import br.univ.pharmasys.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicamentoTopicoDAO extends MedicamentoDAO {

    //metodo de buscar o medicamento topico pelo sku
    public MedicamentoTopico buscarPorSku(String sku) {
        String sql = "SELECT m.*, mt.PESO_GRAMAS, mt.TIPO_EMBALAGEM " +
                "FROM MEDICAMENTO m " +
                "INNER JOIN MEDICAMENTO_TOPICO mt ON m.SKU = mt.SKU " +
                "WHERE m.SKU = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sku);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                MedicamentoTopico top = new MedicamentoTopico();

                top.setSku(rs.getString("SKU"));
                top.setNomeComercial(rs.getString("NOME_COMERCIAL"));
                top.setDosagem(rs.getString("DOSAGEM"));
                top.setFormaFarmaceutica(rs.getString("FORMA_FARMACEUTICA"));
                top.setFabricante(rs.getString("FABRICANTE"));
                top.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
                top.setLaboratorio(rs.getString("LABORATORIO"));
                top.setEstoqueMax(rs.getInt("ESTOQUE_MAX"));
                top.setEstoqueMin(rs.getInt("ESTOQUE_MIN"));
                top.setEstoqueAtual(rs.getInt("ESTOQUE_ATUAL"));
                top.setPreco(rs.getBigDecimal("PRECO"));


                if (rs.getDate("DATA_EXPIRACAO") != null) {
                    top.setDataExpiracao(rs.getDate("DATA_EXPIRACAO").toLocalDate());
                }

                // Preenche dados Específicos (MedicamentoTopico)
                top.setPesoGramas(rs.getDouble("PESO_GRAMAS"));
                top.setTipoEmbalagem(rs.getString("TIPO_EMBALAGEM"));

                return top;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar medicamento tópico: " + e.getMessage(), e);
        }
        return null;
    }

    //metodo create de novo medicamento
    public void create(MedicamentoTopico top) {
        super.create(top);

        String sql = "INSERT INTO MEDICAMENTO_TOPICO (SKU, PESO_GRAMAS, TIPO_EMBALAGEM) VALUES (?,?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, top.getSku());
            stmt.setDouble(2, top.getPesoGramas());
            stmt.setString(3, top.getTipoEmbalagem());

            stmt.executeUpdate();
            System.out.println("MedicamentoTopico salvo com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar detalhes do tópico: " + e.getMessage(), e);
        }
    }

    //metodo update das infos dos medicamentos
    public void update(MedicamentoTopico top) {
        super.update(top); // Atualiza tabela pai

        String sql = "UPDATE MEDICAMENTO_TOPICO SET PESO_GRAMAS = ?, TIPO_EMBALAGEM = ? WHERE SKU = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, top.getPesoGramas());
            stmt.setString(2, top.getTipoEmbalagem());
            stmt.setString(3, top.getSku());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar MedicamentoTopico: " + e.getMessage(), e);
        }
    }

    //metodo de delete, tanto pai quanto filha
    @Override
    public void delete(String sku) {
        String sqlFilha = "DELETE FROM MEDICAMENTO_TOPICO WHERE SKU=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlFilha)) {

            stmt.setString(1, sku);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar MedicamentoTopico: " + e.getMessage(), e);
        }
        //apaga do pai por ultimo
        super.delete(sku);
    }
}