package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.ValorVazioException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CodigoDeBarras {
   
    private String gerarCodigoBarrasEAN13(String valor) throws RuntimeException{
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
        Path caminhoCompleto = FileSystems.getDefault().getPath(usuarioHome,nomeArquivo);

        EAN13Writer barcodeWriter = new EAN13Writer();
        BitMatrix bitMatrix = barcodeWriter.encode(valor, BarcodeFormat.EAN_13, 300, 100);
        try {
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", caminhoCompleto);
        } catch (IOException ex) {
            Logger.getLogger(CodigoDeBarras.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Código de barras EAN_13 gerado.: " + caminhoCompleto.toAbsolutePath());
        return caminhoCompleto.toAbsolutePath().toString();
    }

    public void criar(String skuMedicamento) throws Exception {
        String codigoDeBarrasGerado = gerarCodigoBarrasEAN13(skuMedicamento);
        //TODO salvar codigo de barras no banco de dados: método esperado (skumedicamento,codigodebarrasgerado, tipodecodigoEan13)
    }
}