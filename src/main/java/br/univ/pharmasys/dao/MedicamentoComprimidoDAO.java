package br.univ.pharmasys.dao;
import br.univ.pharmasys.model.MedicamentoComprimido;
import br.univ.pharmasys.model.MedicamentoInjetavel;
import br.univ.pharmasys.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoComprimidoDAO extends MedicamentoDAO {

    //metodo de buscar pelo sku
    public MedicamentoComprimido buscarPorSku(String sku) {
        String sql = "SELECT m.*, mc.QUANTIDADE_COMPRIMIDOS " +
                "FROM MEDICAMENTO m " +
                "INNER JOIN MEDICAMENTO_COMPRIMIDO mc ON m.SKU = mc.SKU " +
                "WHERE m.SKU = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sku);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                MedicamentoComprimido comp = new MedicamentoComprimido();
                comp.setSku(rs.getString("SKU"));
                comp.setNomeComercial(rs.getString("NOME_COMERCIAL"));
                comp.setDosagem(rs.getString("DOSAGEM"));
                comp.setFormaFarmaceutica(rs.getString("FORMA_FARMACEUTICA"));
                comp.setFabricante(rs.getString("FABRICANTE"));
                comp.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
                comp.setLaboratorio(rs.getString("LABORATORIO"));
                comp.setEstoqueMax(rs.getInt("ESTOQUE_MAX"));
                comp.setEstoqueMin(rs.getInt("ESTOQUE_MIN"));
                comp.setEstoqueAtual(rs.getInt("ESTOQUE_ATUAL"));
                comp.setPreco(rs.getBigDecimal("PRECO"));


                if (rs.getDate("DATA_EXPIRACAO") != null) {
                    comp.setDataExpiracao(rs.getDate("DATA_EXPIRACAO").toLocalDate());
                }
                comp.setQuantidadeComprimidos(rs.getInt("QUANTIDADE_COMPRIMIDOS"));

                return comp;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar medicamento comprimido: " + e.getMessage(), e);
        }
        return null;
    }
        //metodo de criar um novo medicamento comprimido(create)
        public void create(MedicamentoComprimido comp) {
            super.create(comp);
            String sql = "INSERT INTO MEDICAMENTO_COMPRIMIDO (SKU, QUANTIDADE_COMPRIMIDOS) VALUES (?,?)";

            try (Connection conn = ConnectionFactory.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, comp.getSku());
                stmt.setInt(2, comp.getQuantidadeComprimidos());

                stmt.executeUpdate();
                System.out.println("MedicamentoComprimido salvo com sucesso!");

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao salvar detalhes do comprimido: " + e.getMessage(), e);
            }
        }


    public List<MedicamentoComprimido> listarComprimidos() {
        String sql = "SELECT m.*, mc.QUANTIDADE_COMPRIMIDOS " +
                      "FROM MEDICAMENTO m " +
                      "INNER JOIN MEDICAMENTO_COMPRIMIDO mc ON m.SKU = mc.SKU ";

        List<MedicamentoComprimido> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(montarComprimido(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os comprimidos: " + e.getMessage(), e);
        }
        return lista;
    }


    //metodo de atualizar(update)
        public void update(MedicamentoComprimido comp) {
            super.update(comp);

            String sql = "UPDATE MEDICAMENTO_COMPRIMIDO SET QUANTIDADE_COMPRIMIDOS = ? WHERE SKU = ?";

            try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){

                stmt.setInt(1, comp.getQuantidadeComprimidos());
                stmt.setString(2, comp.getSku());

                stmt.executeUpdate();
            } catch(SQLException e){
                throw new RuntimeException("Erro ao atualizar MedicamentoComprimido: " + e.getMessage(), e);
            }
        }

        //metodo de deletar(delete)
        @Override
        public void delete(String sku) {
            String sqlFilha = "DELETE FROM MEDICAMENTO_COMPRIMIDO WHERE SKU=?";

            try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sqlFilha)){

                stmt.setString(1, sku);
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao deletar MedicamentoComprimido: " + e.getMessage(), e);
            }
            super.delete(sku);
        }

    private MedicamentoComprimido montarComprimido(ResultSet rs) throws SQLException {
        MedicamentoComprimido comp = new MedicamentoComprimido();

        //Vai fazer o corpo do Medicamento no BD

        comp.setNomeComercial(rs.getString("NOME_COMERCIAL"));
        comp.setSku(rs.getString("SKU"));
        comp.setDosagem(rs.getString("DOSAGEM"));
        comp.setFormaFarmaceutica(rs.getString("FORMA_FARMACEUTICA"));
        comp.setFabricante(rs.getString("FABRICANTE")); // corrigido
        comp.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
        comp.setLaboratorio(rs.getString("LABORATORIO"));
        comp.setEstoqueMax(rs.getInt("ESTOQUE_MAX"));
        comp.setEstoqueMin(rs.getInt("ESTOQUE_MIN"));
        comp.setEstoqueAtual(rs.getInt("ESTOQUE_ATUAL"));
        comp.setPreco(rs.getBigDecimal("PRECO"));

        Date sqlDate = rs.getDate("DATA_EXPIRACAO");
        if (sqlDate != null) {
            comp.setDataExpiracao(sqlDate.toLocalDate());
        }

        comp.setQuantidadeComprimidos(rs.getInt("QUANTIDADE_COMPRIMIDOS"));

        return comp;
    }
    }

