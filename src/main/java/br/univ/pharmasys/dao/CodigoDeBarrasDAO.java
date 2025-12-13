package br.univ.pharmasys.dao;
//a
import br.univ.pharmasys.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CodigoDeBarrasDAO {

    public boolean existeCodigoBarras(String codigoBarras) {
        String sql = "SELECT COUNT(*) FROM MEDICAMENTO WHERE CODIGO_BARRAS = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, codigoBarras);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int quantidade = rs.getInt(1);
                    return quantidade > 0;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar código de barras: " + e.getMessage(), e);
        }
        return false;
    }

    public void atualizarCodigoBarras(String sku, String novoCodigoBarras) {
        String sql = "UPDATE MEDICAMENTO SET CODIGO_BARRAS = ? WHERE SKU = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoCodigoBarras);
            stmt.setString(2, sku);

            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Código de barras salvo no banco com sucesso!");
            } else {
                //Lançar erro se o SKU não existir
                System.out.println("Aviso: Nenhum medicamento encontrado com o SKU " + sku);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao vincular código de barras: " + e.getMessage(), e);
        }
    }
}