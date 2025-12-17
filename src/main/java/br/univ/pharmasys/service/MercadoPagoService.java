package br.univ.pharmasys.service;

import br.univ.pharmasys.model.Pagamento;
import br.univ.pharmasys.util.ConfiguracaoPagamento;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.core.MPRequestOptions;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

import java.util.UUID;
import java.util.Map;
public class MercadoPagoService {

    public MercadoPagoService() {
        ConfiguracaoPagamento.inicializar(); //? inicializa o meu token
    }

    public String gerarPixApi(Pagamento pagamento, String emailCliente, String cpfCliente) {

        PaymentClient client = new PaymentClient();

        //? dados do pagador
        PaymentPayerRequest payer = PaymentPayerRequest.builder()
                .email(emailCliente)
                .identification(IdentificationRequest.builder()
                        .type("CPF")
                        .number(cpfCliente)
                        .build())
                .build();

        //? Monta a requisição do pedido
        PaymentCreateRequest createRequest = PaymentCreateRequest.builder()
                .transactionAmount(pagamento.getValor())
                .description("PharmaSys Pedido: " + pagamento.getIdPedido().getIdPedido())
                .paymentMethodId("pix")
                .payer(payer)
                .build();

        try {
            //? a Idempotência evita pagamentos duplicados se clicar 2x
            MPRequestOptions requestOptions = MPRequestOptions.builder()
                    .customHeaders(Map.of("x-idempotency-key", UUID.randomUUID().toString()))
                    .build();

            //? Envia para o Mercado Pago
            Payment paymentResponse = client.create(createRequest, requestOptions);

            //? Retorna um QR Code "Copia e Cola"
            return paymentResponse.getPointOfInteraction().getTransactionData().getQrCode();

        } catch (MPApiException ex) {
            System.err.println("Erro na API Mercado Pago: " + ex.getApiResponse().getContent());
            throw new RuntimeException("Erro ao gerar Pix no Mercado Pago.");
        } catch (MPException ex) {
            throw new RuntimeException("Erro de conexão com Mercado Pago: " + ex.getMessage());
        }
    }
}
