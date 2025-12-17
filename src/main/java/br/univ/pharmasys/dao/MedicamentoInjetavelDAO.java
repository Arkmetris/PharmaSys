package br.univ.pharmasys.dao;

import br.univ.pharmasys.model.MedicamentoInjetavel;
import br.univ.pharmasys.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicamentoInjetavelDAO extends MedicamentoDAO {

    //metodo de buscar o medicamento injetavel pelo sku
    public MedicamentoInjetavel buscarPorSku(String sku) {
        String sql = "SELECT m.*, mi.VIA_ADMINISTRACAO, mi.TEMPERATURA_MINIMA, mi.TEMPERATURA_MAXIMA " +
                "FROM MEDICAMENTO m " +
                "INNER JOIN MEDICAMENTO_INJETAVEL mi ON m.SKU = mi.SKU " +
                "WHERE m.SKU = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sku);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //instancia o objeto
                MedicamentoInjetavel inj = new MedicamentoInjetavel();

                inj.setSku(rs.getString("SKU"));
                inj.setNomeComercial(rs.getString("NOME_COMERCIAL"));
                inj.setDosagem(rs.getString("DOSAGEM"));
                inj.setFormaFarmaceutica(rs.getString("FORMA_FARMACEUTICA"));
                inj.setFabricante(rs.getString("FABRICANTE"));
                inj.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
                inj.setLaboratorio(rs.getString("LABORATORIO"));
                inj.setEstoqueMax(rs.getInt("ESTOQUE_MAX"));
                inj.setEstoqueMin(rs.getInt("ESTOQUE_MIN"));
                inj.setEstoqueAtual(rs.getInt("ESTOQUE_ATUAL"));
                inj.setPreco(rs.getBigDecimal("PRECO"));


                if (rs.getDate("DATA_EXPIRACAO") != null) {
                    inj.setDataExpiracao(rs.getDate("DATA_EXPIRACAO").toLocalDate());
                }

                inj.setViaAdministracao(rs.getString("VIA_ADMINISTRACAO"));
                inj.setTemperaturaMinima(rs.getDouble("TEMPERATURA_MINIMA"));
                inj.setTemperaturaMaxima(rs.getDouble("TEMPERATURA_MAXIMA"));

                return inj;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar medicamento injetável: " + e.getMessage(), e);
        }
        return null;
    }

    //metodo de criar um novo medicamento injetavel (create)
    public void create(MedicamentoInjetavel inj) {
        super.create(inj); //salva primeiro na tabela pai

        String sql = "INSERT INTO MEDICAMENTOINJETAVEL (SKU, VIA_ADMINISTRACAO, TEMPERATURA_MINIMA, TEMPERATURA_MAXIMA) VALUES (?,?,?,?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, inj.getSku());
            stmt.setString(2, inj.getViaAdministracao());
            stmt.setDouble(3, inj.getTemperaturaMinima());
            stmt.setDouble(4, inj.getTemperaturaMaxima());

            stmt.executeUpdate();
            System.out.println("MedicamentoInjetavel salvo com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar detalhes do injetável: " + e.getMessage(), e);
        }
    }

    //metodo de atualizar as infos do medicamento injetavel (update)
    public void update(MedicamentoInjetavel inj) {
        super.update(inj);

        String sql = "UPDATE MEDICAMENTOINJETAVEL SET VIA_ADMINISTRACAO = ?, TEMPERATURA_MINIMA = ?, TEMPERATURA_MAXIMA = ? WHERE SKU = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, inj.getViaAdministracao());
            stmt.setDouble(2, inj.getTemperaturaMinima());
            stmt.setDouble(3, inj.getTemperaturaMaxima());
            stmt.setString(4, inj.getSku());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar MedicamentoInjetavel: " + e.getMessage(), e);
        }
    }

    //metodo de deletar tanto da classe pai e da classe filha (delete)
    @Override
    public void delete(String sku) {
        String sqlFilha = "DELETE FROM MEDICAMENTOINJETAVEL WHERE SKU=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlFilha)) {

            stmt.setString(1, sku);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar MedicamentoInjetavel: " + e.getMessage(), e);
        }
        //depois de apagar o filho, chama o pai para apagar o registro geral
        super.delete(sku);
    }
}