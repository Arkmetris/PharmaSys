package br.univ.pharmasys.dao;

import br.univ.pharmasys.model.Pagamento;
import br.univ.pharmasys.util.ConnectionFactory;

import java.sql.*;

public class PagamentoDAO {

    public void create(Pagamento pagamento) {
        String sql = "INSERT INTO PAGAMENTO (PEDIDO_ID, METODO_PAGAMENTO, VALOR, DATA_PAGAMENTO, QRCODE) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, pagamento.getIdPedido().getIdPedido());

            stmt.setString(2, pagamento.getMetodo().toString()); //? aqui guarda os enums do metodo de pagamento escolhido


            stmt.setBigDecimal(3, pagamento.getValor()); //? aqui guarda o valor em decimal recebido


            stmt.setTimestamp(4, Timestamp.valueOf(pagamento.getDataPagamento().atStartOfDay()));


            stmt.setString(5, pagamento.getQrCode()); //? aqui guarda os qr code

            stmt.executeUpdate();
            System.out.println("Pagamento salvo com sucesso no banco!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar pagamento no banco: " + e.getMessage(), e);
        }
    }
}





















