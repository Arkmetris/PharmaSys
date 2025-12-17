package br.univ.pharmasys.service;

import java.util.Properties;

public class MensagemEmail {

    public void enviarConfirmacao(String emailUsuario, String nomeUsuario) {
        // Configurações do remetente
        final String remetente = "ajudapharmasys@gmail.com"; 
        final String senha = "admin12345!"; 

        // Propriedades do Servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
    }
}
