package br.univ.pharmasys.dao;

import br.univ.pharmasys.model.Lote;
import br.univ.pharmasys.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

public class LoteDAO {

    public void create(Lote lote) {

        String sql = "INSERT INTO LOTE (SKU_MEDICAMENTO, VALIDADE, QUANTIDADE_RECEBIDA, "
                + "QUANTIDADE_ATUAL, PRECO) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, lote.getSkuMedicamento());

            if (lote.getValidade() != null) {
                stmt.setDate(2, Date.valueOf(lote.getValidade()));
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            stmt.setInt(3, lote.getQuantidadeRecebida());
            stmt.setInt(4, lote.getQuantidadeAtual());
            stmt.setBigDecimal(5, lote.getPreco());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    lote.setNumeroLote(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar Lote: " + e.getMessage(), e);
        }
    }

   
    public Lote buscarPorSkuEValidade(String sku, java.time.LocalDate validade) {

        String sql = "SELECT * FROM LOTE WHERE SKU_MEDICAMENTO = ? AND VALIDADE = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sku);
            stmt.setDate(2, Date.valueOf(validade));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Lote lote = new Lote();

                    lote.setNumeroLote(rs.getInt("NUMERO_LOTE"));
                    lote.setSkuMedicamento(rs.getString("SKU_MEDICAMENTO"));

                    Date sqlDate = rs.getDate("VALIDADE");
                    lote.setValidade(sqlDate != null ? sqlDate.toLocalDate() : null);

                    lote.setQuantidadeRecebida(rs.getInt("QUANTIDADE_RECEBIDA"));
                    lote.setQuantidadeAtual(rs.getInt("QUANTIDADE_ATUAL"));
                    lote.setPreco(rs.getBigDecimal("PRECO"));

                    return lote;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar lote por SKU e validade: " + e.getMessage(), e);
        }

        return null;
    }

    public List<Lote> buscarPorSku(String sku) {

        String sql = "SELECT * FROM LOTE WHERE SKU_MEDICAMENTO LIKE ?";

        List<Lote> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + sku + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Lote lote = new Lote();

                    lote.setNumeroLote(rs.getInt("NUMERO_LOTE"));
                    lote.setSkuMedicamento(rs.getString("SKU_MEDICAMENTO"));

                    Date sqlDate = rs.getDate("VALIDADE");
                    lote.setValidade(sqlDate != null ? sqlDate.toLocalDate() : null);

                    lote.setQuantidadeRecebida(rs.getInt("QUANTIDADE_RECEBIDA"));
                    lote.setQuantidadeAtual(rs.getInt("QUANTIDADE_ATUAL"));
                    lote.setPreco(rs.getBigDecimal("PRECO"));

                    lista.add(lote);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Lotes por SKU: " + e.getMessage(), e);
        }

        return lista;
    }

    public void update(Lote lote) {

        String sql = "UPDATE LOTE SET SKU_MEDICAMENTO = ?, VALIDADE = ?, "
                + "QUANTIDADE_RECEBIDA = ?, QUANTIDADE_ATUAL = ?, PRECO = ? "
                + "WHERE NUMERO_LOTE = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, lote.getSkuMedicamento());

            if (lote.getValidade() != null) {
                stmt.setDate(2, Date.valueOf(lote.getValidade()));
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            stmt.setInt(3, lote.getQuantidadeRecebida());
            stmt.setInt(4, lote.getQuantidadeAtual());
            stmt.setBigDecimal(5, lote.getPreco());
            stmt.setInt(6, lote.getNumeroLote());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Lote: " + e.getMessage(), e);
        }
    }

    public void delete(int numeroLote) {

        String sql = "DELETE FROM LOTE WHERE NUMERO_LOTE = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numeroLote);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Lote: " + e.getMessage(), e);
        }
    }
}
