package br.univ.pharmasys.dao;

import br.univ.pharmasys.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {

    public List<Object[]> listarEstoque() {

        String sql = """
            SELECT SKU, NOME_COMERCIAL, ESTOQUE_ATUAL, ESTOQUE_MIN, ESTOQUE_MAX
            FROM VW_ESTOQUE_MEDICAMENTO
            ORDER BY NOME_COMERCIAL
        """;

        List<Object[]> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Object[]{
                        rs.getString("SKU"),
                        rs.getString("NOME_COMERCIAL"),
                        rs.getInt("ESTOQUE_ATUAL"),
                        rs.getInt("ESTOQUE_MIN"),
                        rs.getInt("ESTOQUE_MAX")
                });
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao carregar estoque", e);
        }

        return lista;
    }
}
