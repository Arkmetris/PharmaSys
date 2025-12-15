package br.univ.pharmasys.service;
//a
import br.univ.pharmasys.dao.CodigoDeBarrasDAO; // Importação necessária do DAO
import br.univ.pharmasys.exceptions.ValorVazioException;
import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException; // Import para erro de duplicidade
import br.univ.pharmasys.model.Medicamento;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
//import java.io.IOException;           /-- Esses imports nao estão sendo usados,
//import java.nio.file.FileSystems;      -- Caso não for usar-los, pode remova
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CodigoDeBarras {
    
    //conexao com o banco
    private final CodigoDeBarrasDAO codigoDAO;

    public CodigoDeBarras() {
        // Inicializa o DAO
        this.codigoDAO = new CodigoDeBarrasDAO();
    }
   
    private String gerarCodigoBarrasEAN13(String valor) throws RuntimeException {
        String usuarioHome = System.getProperty("user.home");
        System.out.println("user.home: " + usuarioHome);

        Path documentosPath = Paths.get(usuarioHome, "Documents");
        System.out.println("Caminho para Documentos: " + documentosPath.toAbsolutePath());

        if (valor == null || valor.trim().isEmpty()) {
            throw new ValorVazioException("Valor do código de barras não pode estar vazio.");
        } else if (valor.length() != 13) {
            throw new ValorVazioException("Valor do código deve ter 13 digítos.");
        }
        
        String nomeArquivo = valor.replaceAll("[^a-zA-Z0-9]", "_") + ".png";
        

        Path caminhoCompleto = documentosPath.resolve(nomeArquivo); 

        EAN13Writer barcodeWriter = new EAN13Writer();
        try {
            BitMatrix bitMatrix = barcodeWriter.encode(valor, BarcodeFormat.EAN_13, 300, 100);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", caminhoCompleto);
        } catch (Exception ex) { 
            Logger.getLogger(CodigoDeBarras.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao gerar imagem", ex);
        }

        System.out.println("Código de barras EAN_13 gerado.: " + caminhoCompleto.toAbsolutePath());
        return caminhoCompleto.toAbsolutePath().toString();
    }
   
    public String criarCodigo(Medicamento medicamento) {
        // Chama abaixo passando SKU e Código
        return criarCodigo(medicamento.getSku(), medicamento.getCodigoBarras());
    }

    // Esse é o metodo que vai conectar com a classe DAO
    public String criarCodigo(String sku, String codigoNumerico) {
        
        if (codigoDAO.existeCodigoBarras(codigoNumerico)) {
            throw new ErroDePreenchimentoInvalidoException("O código " + codigoNumerico + " já está em uso.");
        }

        String caminhoImagem = gerarCodigoBarrasEAN13(codigoNumerico);

        codigoDAO.atualizarCodigoBarras(sku, codigoNumerico);

        return caminhoImagem;
    }
}