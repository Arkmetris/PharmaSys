package br.univ.pharmasys.dao;

import br.univ.pharmasys.model.Lote; // Importa a classe Lote do pacote model.
import br.univ.pharmasys.util.ConnectionFactory; //Faz a Ligaçõa com a classe que cria conexões com o banco de dados. 

import java.sql.Connection; //Importa a classe Connection para gerenciar conexões com o banco de dados.
import java.sql.PreparedStatement; //Importa a classe PreparedStatement para executar instruções SQL pré-compiladas.
import java.sql.ResultSet; //Importa a classe ResultSet para armazenar os resultados de consultas SQL.
import java.sql.SQLException; //Importa a classe SQLException para tratar erros relacionados ao SQL.
import java.sql.Date; //Importa a classe Date para manipular datas SQL.

import java.util.ArrayList;	//Importa a classe ArrayList para criar listas dinâmicas.
import java.util.List;	//Importa a interface List para trabalhar com listas de objetos.

public class LoteDAO {

  //  Cria um novo Lote no banco de dados.
    public void create(Lote lote) {

        String sql = "INSERT INTO LOTE (SKU_MEDICAMENTO, VALIDADE, QUANTIDADE_RECEBIDA, "
                   + "QUANTIDADE_ATUAL, PRECO) VALUES (?, ?, ?, ?, ?)";
// Prepara a instrução SQL para inserir um novo Lote no banco de dados.
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

            stmt.executeUpdate();
//	 Executa a instrução SQL para inserir o novo Lote no banco de dados.
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar Lote: " + e.getMessage(), e);
        }
    }

 //	 Busca Lotes no banco de dados com base no SKU do medicamento fornecido.
    public List<Lote> buscarPorSku(String sku) {

        String sql = "SELECT * FROM LOTE WHERE SKU_MEDICAMENTO LIKE ?";

        List<Lote> lista = new ArrayList<>();
// Cria uma lista para armazenar os Lotes encontrados.
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + sku + "%");
            	// Define o parâmetro da consulta SQL com o SKU fornecido.
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Lote lote = new Lote();

                    lote.setIdLote(rs.getLong("ID_LOTE"));
                    lote.setSkuMedicamento(rs.getString("SKU_MEDICAMENTO"));
                    lote.setNumeroLote(rs.getString("NUMERO_LOTE"));

                    Date sqlDate = rs.getDate("VALIDADE");
                    if (sqlDate != null) {
                        lote.setValidade(sqlDate.toLocalDate());
                    }

                    lote.setQuantidadeRecebida(rs.getInt("QUANTIDADE_RECEBIDA"));
                    lote.setQuantidadeAtual(rs.getInt("QUANTIDADE_ATUAL"));
                    lote.setPreco(rs.getBigDecimal("PRECO"));

                    lista.add(lote);
                }
            }
// Executa a consulta SQL e popula a lista de Lotes com os resultados.
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Lotes por SKU: " + e.getMessage(), e);
        }

        return lista;
    }

 //  Atualiza os dados de um Lote existente no banco de dados.
    public void update(Lote lote) {

        String sql = "UPDATE LOTE SET SKU_MEDICAMENTO = ?, VALIDADE = ?, "
                   + "QUANTIDADE_RECEBIDA = ?, QUANTIDADE_ATUAL = ?, PRECO = ? "
                   + "WHERE NUMERO_LOTE = ?";
// Prepara a instrução SQL para atualizar o Lote com os novos valores fornecidos.
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, lote.getSkuMedicamento());
           // Define a validade, tratando valores nulos.
            if (lote.getValidade() != null) {
                stmt.setDate(2, Date.valueOf(lote.getValidade()));
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            stmt.setInt(3, lote.getQuantidadeRecebida());
            stmt.setInt(4, lote.getQuantidadeAtual());
            stmt.setBigDecimal(5, lote.getPreco());

            stmt.setString(6, lote.getNumeroLote());

            stmt.executeUpdate();
// Executa a instrução SQL para atualizar o Lote.
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Lote: " + e.getMessage(), e);
        }
    }

  //  Deleta um Lote do banco de dados com base no número do lote fornecido.
    public void delete(int numeroLote) {

        String sql = "DELETE FROM LOTE WHERE NUMERO_LOTE = ?";
// Prepara a instrução SQL para deletar o Lote com o número especificado.
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numeroLote);
            stmt.executeUpdate();
// Executa a instrução SQL para deletar o Lote.
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Lote: " + e.getMessage(), e);
        }
    }
}
