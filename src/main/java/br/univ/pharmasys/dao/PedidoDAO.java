package br.univ.pharmasys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univ.pharmasys.model.Pedido;
import br.univ.pharmasys.model.Status;
import br.univ.pharmasys.util.ConnectionFactory;

public class PedidoDAO {

	public void create (Pedido pedido) {
		
		String sql = """
				INSERT INTO PEDIDO
				(QUANTIDADE, STATUS, DATA, PRECO_UNITARIO, VALOR_TOTAL)
				VALUES (?,?,?,?,?) """;
		
		 try (Connection conn = ConnectionFactory.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
			 stmt.setInt(1, pedido.getquantidade());
	            stmt.setString(2, pedido.getStatus().name());

	            if (pedido.getData() != null) {
	                stmt.setDate(3, Date.valueOf(pedido.getData()));
	            } else {
	                stmt.setNull(3, java.sql.Types.DATE);
	            }

	            stmt.setDouble(4, pedido.getPrecoUnitario());
	            stmt.setDouble(5, pedido.getValorTotal());

	            stmt.executeUpdate();
	            
		 } catch (SQLException e) {
	            throw new RuntimeException("Erro ao salvar Pedido: " + e.getMessage(), e);}
	} 
	
public List<Pedido> listarTodos() {

        String sql = "SELECT * FROM PEDIDO ORDER BY DATA DESC";
        List<Pedido> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(montarPedido(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Pedidos: " + e.getMessage(), e);
        }

        return lista;}

	
//Para atualizar:
	public void update(Pedido pedido) {

        String sql = """
            UPDATE PEDIDO
            SET QUANTIDADE = ?, STATUS = ?, DATA = ?, PRECO_UNITARIO = ?, VALOR_TOTAL = ?
            WHERE ID_PEDIDO = ?
        """;
	
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

               stmt.setInt(1, pedido.getquantidade());
               stmt.setString(2, pedido.getStatus().name());
               stmt.setDate(3, Date.valueOf(pedido.getData()));
               stmt.setDouble(4, pedido.getPrecoUnitario());
               stmt.setDouble(5, pedido.getValorTotal());
               stmt.setLong(6, pedido.getIdPedido());

               stmt.executeUpdate();

           } catch (SQLException e) {
               throw new RuntimeException("Erro ao atualizar Pedido: " + e.getMessage(), e);
           }
}
	
//Para deletar:
	public void delete(long idPedido) {

        String sql = "DELETE FROM PEDIDO WHERE ID_PEDIDO = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, idPedido);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Pedido: " + e.getMessage(), e);
        }
}

	
//Método que monta o pedido
	 private Pedido montarPedido(ResultSet rs) throws SQLException {

	        Pedido pedido = new Pedido();

	        pedido.setQuantidade(rs.getInt("QUANTIDADE"));
	        pedido.setStatus(Status.valueOf(rs.getString("STATUS")));
	        pedido.setPrecoUnitario(rs.getDouble("PRECO_UNITARIO"));

	        Date dataSql = rs.getDate("DATA");
	        if (dataSql != null) {
	            pedido.setData(dataSql.toLocalDate());
	        }
	        return pedido;
	}
}