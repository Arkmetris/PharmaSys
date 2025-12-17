package br.univ.pharmasys;
import br.univ.pharmasys.dao.PagamentoDAO;
import br.univ.pharmasys.model.MetodoPagamento;
import br.univ.pharmasys.model.Pagamento;
import br.univ.pharmasys.model.Pedido;
import br.univ.pharmasys.service.MercadoPagoService;
import br.univ.pharmasys.util.GeradorQrCode;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteIntegracaoApiPagamento {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO VENDA PHARMASYS ---");

        try {
            Pedido pedido = new Pedido();
            pedido.setIdPedido(1L); //?seleciona o id para simular um pedido

            //? prepara o objeto de pagamento
            Pagamento pag = new Pagamento();
            pag.setIdPedido(pedido);
            pag.setValor(new BigDecimal("1.50")); //? seta o valor pra testes
            pag.setMetodo(MetodoPagamento.PIX);
            pag.setDataPagamento(LocalDate.now().plusDays(1)); //? vencimento da chave

            //? chama a api do mercado pago
            System.out.println("Gerando QR Code no Mercado Pago...");
            MercadoPagoService mpService = new MercadoPagoService();

            //? Passa um email e CPF fictícios com formato válido para testar
            String qrCodeGerado = mpService.gerarPixApi(pag, "teste@pharmasys.com", "12345678909");
            //? atualiza o objeto com o código recebido
            pag.setQrCode(qrCodeGerado);
            System.out.println("QR Code gerado com sucesso!");

            //?gera a minha imagem de qrcode na pasta raiz do projeto
            System.out.println("Gerando imagem PNG do QR Code...");
            String nomeArquivo = "pix_pedido_" + pag.getIdPedido().getIdPedido() + ".png";
            GeradorQrCode.gerarImagemArquivo(qrCodeGerado, nomeArquivo);

            //? salva no banco de dados
            System.out.println("Salvando no banco de dados...");
            PagamentoDAO dao = new PagamentoDAO();
            dao.create(pag);

            System.out.println("\n------------------------------------------------");
            System.out.println("Copie o código abaixo para testar no app do banco:");
            System.out.println(pag.getQrCode());
            System.out.println("------------------------------------------------");

        } catch (Exception e) {
            System.err.println("FALHA: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
