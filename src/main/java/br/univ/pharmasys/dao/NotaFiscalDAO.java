package br.univ.pharmasys.dao;

import br.univ.pharmasys.model.NotaFiscal;
import br.univ.pharmasys.util.ConnectionFactory;
import br.univ.pharmasys.model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalDAO {

    private static final String INSERT_SQL = "INSERT INTO NOTA_FISCAL (NUMERO_NOTA, DATA_EMISSAO, VALOR_TOTAL, ID_FUNCIONARIO, CPF_CLIENTE) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM NOTA_FISCAL";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM NOTA_FISCAL WHERE id = ?";

    public Long salvar(NotaFiscal nota) {
        Long idGerado = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, nota.getNumeroNota());            
            stmt.setTimestamp(2, Timestamp.valueOf(nota.getDataEmissao()));           
            stmt.setBigDecimal(3, nota.getValorTotal());

            if (nota.getFuncionarioResponsavel() != null) {
            	stmt.setLong(4, nota.getFuncionarioResponsavel().getIdFuncionario());
            } else {
                stmt.setNull(4, Types.BIGINT);
            }

            // Tratamento do CPF do cliente
            if (nota.getCpfCliente() != null) {
                stmt.setString(5, nota.getCpfCliente());
            } else {
                stmt.setNull(5, Types.VARCHAR);
            }

            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    idGerado = rs.getLong(1);
                    nota.setId(idGerado);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar Nota Fiscal: " + e.getMessage(), e);
        }

        return idGerado;
    }
    
    public NotaFiscal buscarPorId(Long id) {
        NotaFiscal nota = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nota = mapear(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Nota Fiscal: " + e.getMessage(), e);
        }
        return nota;
    }

    public List<NotaFiscal> listarTodas() {
        List<NotaFiscal> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Notas Fiscais: " + e.getMessage(), e);
        }
        return lista;
    } 
    
    private NotaFiscal mapear(ResultSet rs) throws SQLException {
        NotaFiscal nf = new NotaFiscal();
        
        nf.setId(rs.getLong("ID"));
        nf.setNumeroNota(rs.getString("NUMERO_NOTA"));
        
        if (rs.getTimestamp("DATA_EMISSAO") != null) {
            nf.setDataEmissao(rs.getTimestamp("DATA_EMISSAO").toLocalDateTime());
        }
        
        nf.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
        nf.setCpfCliente(rs.getString("CPF_CLIENTE"));

        long idFunc = rs.getLong("ID_FUNCIONARIO");
        if (idFunc > 0) {
            Funcionario f = new Funcionario();
            f.setIdFuncionario(idFunc);
            nf.setFuncionarioResponsavel(f);
        }

        return nf;
    }

}