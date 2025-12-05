package br.univ.pharmasys.dao;

import br.univ.pharmasys.model.Medicamento;
import br.univ.pharmasys.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDAO {

    /**
     * INSERT conforme a tabela MEDICAMENTO que você enviou:
     * (SKU, CODIGO_BARRAS, NOME_COMERCIAL, FORMA_FARMACEUTICA,
     *  DOSAGEM, FABRICANTE, DATA_EXPIRACAO, LABORATORIO,
     *  ESTOQUE_MIN, ESTOQUE_MAX, LOTE_ID)
     */
    public void create(Medicamento med) {
        String sql = "INSERT INTO MEDICAMENTO (SKU, CODIGO_BARRAS, NOME_COMERCIAL, FORMA_FARMACEUTICA, "
                + "DOSAGEM, FABRICANTE, DATA_EXPIRACAO, LABORATORIO, ESTOQUE_MIN, ESTOQUE_MAX, LOTE_ID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, med.getSku());
            stmt.setString(2, med.getCodigoBarras());
            stmt.setString(3, med.getNomeComercial());
            stmt.setString(4, med.getFormaFarmaceutica());
            stmt.setString(5, med.getDosagem());
            stmt.setString(6, med.getFabricante());
            stmt.setDate(7, Date.valueOf(med.getDataExpiracao()));
            stmt.setString(8, med.getLaboratorio());
            stmt.setInt(9, med.getEstoqueMin());
            stmt.setInt(10, med.getEstoqueMax());

            if (med.getLoteId() != null) {
                stmt.setInt(11, med.getLoteId());
            } else {
                stmt.setNull(11, java.sql.Types.INTEGER);
            }

            stmt.executeUpdate();
            System.out.println("Medicamento salvo com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar medicamento: " + e.getMessage(), e);
        }
    }

    /**
     * Buscar medicamento pelo SKU (PK)
     */
    public Medicamento buscarPorSku(String sku) {
        String sql = "SELECT * FROM MEDICAMENTO WHERE SKU = ?";
        Medicamento med = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sku);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    med = mapResultSetToMedicamento(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar medicamento por SKU: " + e.getMessage(), e);
        }
        return med;
    }

    /**
     * Buscar por nome comercial (pode haver vários)
     * Use LIKE se preferir busca parcial
     */
    public List<Medicamento> buscarPorNome(String nome) {
        String sql = "SELECT * FROM MEDICAMENTO WHERE NOME_COMERCIAL = ?";
        List<Medicamento> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Medicamento med = mapResultSetToMedicamento(rs);
                    lista.add(med);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar medicamento por Nome: " + e.getMessage(), e);
        }
        return lista;
    }

    /**
     * Atualiza todos os campos (exceto SKU) e usa SKU na cláusula WHERE.
     * Note os índices corretos para os parâmetros.
     */
    public void update(Medicamento med) {
        String sql = "UPDATE MEDICAMENTO SET CODIGO_BARRAS=?, NOME_COMERCIAL=?, FORMA_FARMACEUTICA=?, "
                + "DOSAGEM=?, FABRICANTE=?, DATA_EXPIRACAO=?, LABORATORIO=?, ESTOQUE_MIN=?, ESTOQUE_MAX=?, LOTE_ID=? "
                + "WHERE SKU=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, med.getCodigoBarras());
            stmt.setString(2, med.getNomeComercial());
            stmt.setString(3, med.getFormaFarmaceutica());
            stmt.setString(4, med.getDosagem());
            stmt.setString(5, med.getFabricante());
            stmt.setDate(6, Date.valueOf(med.getDataExpiracao()));
            stmt.setString(7, med.getLaboratorio());
            stmt.setInt(8, med.getEstoqueMin());
            stmt.setInt(9, med.getEstoqueMax());

            if (med.getLoteId() != null) {
                stmt.setInt(10, med.getLoteId());
            } else {
                stmt.setNull(10, java.sql.Types.INTEGER);
            }

            // SKU no WHERE (parâmetro 11)
            stmt.setString(11, med.getSku());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Medicamento atualizado com sucesso!");
            } else {
                System.out.println("Nenhum medicamento encontrado com o SKU fornecido para atualizar.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar medicamento: " + e.getMessage(), e);
        }
    }

    /**
     * Deleta por SKU
     */
    public void delete(String sku) {
        String sql = "DELETE FROM MEDICAMENTO WHERE SKU = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sku);

            int linhasDeletadas = stmt.executeUpdate();
            if (linhasDeletadas > 0) {
                System.out.println("Medicamento excluído com sucesso!");
            } else {
                System.out.println("Nenhum medicamento encontrado com o SKU fornecido.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir medicamento: " + e.getMessage(), e);
        }
    }

    // ---------- Helper para mapear ResultSet para Medicamento ----------
    private Medicamento mapResultSetToMedicamento(ResultSet rs) throws SQLException {
        Medicamento med = new Medicamento();

        med.setSku(rs.getString("SKU"));
        med.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
        med.setNomeComercial(rs.getString("NOME_COMERCIAL"));
        med.setFormaFarmaceutica(rs.getString("FORMA_FARMACEUTICA"));
        med.setDosagem(rs.getString("DOSAGEM"));
        med.setFabricante(rs.getString("FABRICANTE"));

        Date dt = rs.getDate("DATA_EXPIRACAO");
        if (dt != null) {
            med.setDataExpiracao(dt.toLocalDate());
        }

        med.setLaboratorio(rs.getString("LABORATORIO"));
        med.setEstoqueMin(rs.getInt("ESTOQUE_MIN"));
        med.setEstoqueMax(rs.getInt("ESTOQUE_MAX"));

        int lote = rs.getInt("LOTE_ID");
        if (!rs.wasNull()) {
            med.setLoteId(lote);
        } else {
            med.setLoteId(null);
        }

        return med;
    }
}
