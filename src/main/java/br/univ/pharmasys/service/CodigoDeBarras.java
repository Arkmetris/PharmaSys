package br.univ.pharmasys.service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;

///Geração do código de barras
public class CodigoDeBarras {
   
    String path = "C:\\Users\\Pichau\\Documents";

    private String gerarCodigoBarrasEAN13(String valor) throws Exception {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("Valor do código de barras não pode estar vazio.");
        }

        String nomeArquivo = valor.replaceAll("[^a-zA-Z0-9]", "_") + ".png";
        Path caminhoCompleto = FileSystems.getDefault().getPath(path, nomeArquivo);

        EAN13Writer barcodeWriter = new EAN13Writer();
        BitMatrix bitMatrix = barcodeWriter.encode(valor, BarcodeFormat.EAN_13, 300, 100);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", caminhoCompleto);

        System.out.println("Código de barras EAN_13 gerado.: " + caminhoCompleto.toAbsolutePath());
        return caminhoCompleto.toAbsolutePath().toString();
    }

    public void criar(String skuMedicamento) throws Exception {
        String CodigoDeBarrasGerado = gerarCodigoBarrasEAN13(skuMedicamento);
        //TODO salvar codigo de barras no banco de dados: método esperado (skumedicamento,codigodebarrasgerado, tipodecodigoEan13)
    }
}

