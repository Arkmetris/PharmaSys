package br.univ.pharmasys.util;
import com.mercadopago.MercadoPagoConfig;

public class ConfiguracaoPagamento {
    private static final String ACCESS_TOKEN = "TEST-56852418797001-121619-1faacd78575cc4785ce373d4adac11ee-2476056531"; //? token de acesso

    public static void inicializar() {
        MercadoPagoConfig.setAccessToken(ACCESS_TOKEN);
    }
}
