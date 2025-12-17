package br.univ.pharmasys.dao;

import br.univ.pharmasys.util.ConnectionFactory;

import java.math.BigDecimal;
import java.sql.*;

public class PedidoItemMedDAO {

    public void inserirItemPedido(
            int idPedido,
            String skuMedicamento,
            int quantidade,
            BigDecimal valorItem
    ) {

        String sql = """
                    INSERT INTO ITEM_PEDIDO_MED
                    (ID_PEDIDO, SKU_MEDICAMENTO, QUANTIDADE, VALOR_ITEM, SUBTOTAL)
                    VALUES (?, ?, ?, ?, ?)
                """;

        BigDecimal subtotal = valorItem.multiply(BigDecimal.valueOf(quantidade));

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idPedido);
            ps.setString(2, skuMedicamento); // 🔥 SKU, não ID
            ps.setInt(3, quantidade);
            ps.setBigDecimal(4, valorItem);
            ps.setBigDecimal(5, subtotal);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir ITEM_PEDIDO_MED", e);
        }
    }

}
