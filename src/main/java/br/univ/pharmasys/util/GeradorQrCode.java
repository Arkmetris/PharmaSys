package br.univ.pharmasys.util;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class GeradorQrCode {

    public static void gerarImagemArquivo(String textoPix, String caminhoArquivo) {
        int largura = 350;
        int altura = 350;

        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            //? gera a matriz de bits
            BitMatrix bitMatrix = qrCodeWriter.encode(textoPix, BarcodeFormat.QR_CODE, largura, altura);

            //? define que vai salvar na raiz do projeto
            Path path = FileSystems.getDefault().getPath(caminhoArquivo);

            //? coloca o qrcode no disco como formato PNG
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

            System.out.println("\n[IMAGEM GERADA] O arquivo do QR Code foi salvo em: " + path.toAbsolutePath());
            System.out.println("Abra a pasta para ver a imagem: " + caminhoArquivo);

        } catch (Exception e) {
            System.err.println("Erro fatal ao gerar imagem do QR Code: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
