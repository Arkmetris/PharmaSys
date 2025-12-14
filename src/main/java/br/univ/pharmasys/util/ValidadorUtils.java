package br.univ.pharmasys.util;
//a
import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;
import java.util.regex.Pattern;

public class ValidadorUtils {

    public static void emailValido(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O campo de e-mail não pode estar vazio.");
        }
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        
        if (!pat.matcher(email).matches()) {
            throw new ErroDePreenchimentoInvalidoException("O formato do e-mail é inválido.");
        }
    }
    
    public static void cpfValido(String cpf) {

        if (cpf == null || cpf.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O CPF é obrigatório.");
        }

        String cpfLimpo = cpf.replaceAll("\\D", "");

        if (cpfLimpo.length() != 11) {
            throw new ErroDePreenchimentoInvalidoException("O CPF deve conter exatamente 11 dígitos.");
        }

        if (cpfLimpo.matches("(\\d)\\1{10}")) {
            throw new ErroDePreenchimentoInvalidoException("CPF inválido (todos os números são iguais).");
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        sm = 0;
        peso = 10;
        for (i = 0; i < 9; i++) {
            num = (int) (cpfLimpo.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) dig10 = '0';
        else dig10 = (char) (r + 48);
        
        sm = 0;
        peso = 11;
        for (i = 0; i < 10; i++) {
            num = (int) (cpfLimpo.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) dig11 = '0';
        else dig11 = (char) (r + 48);

        if ((dig10 != cpfLimpo.charAt(9)) || (dig11 != cpfLimpo.charAt(10))) {
            throw new ErroDePreenchimentoInvalidoException("O CPF informado é inválido (dígitos verificadores não conferem).");
        }
    }
    
    public static void cnpjValido(String cnpj) {

        if (cnpj == null || cnpj.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O CNPJ é obrigatório.");
        }

        String cnpjLimpo = cnpj.replaceAll("\\D", "");

        if (cnpjLimpo.length() != 14) {
            throw new ErroDePreenchimentoInvalidoException("O CNPJ deve conter exatamente 14 dígitos.");
        }

        if (cnpjLimpo.matches("(\\d)\\1{13}")) {
             throw new ErroDePreenchimentoInvalidoException("CNPJ inválido (todos os números são iguais).");
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        sm = 0;
        peso = 2;
        for (i = 11; i >= 0; i--) {
            num = (int) (cnpjLimpo.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10) peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1)) dig13 = '0';
        else dig13 = (char) ((11 - r) + 48);

        sm = 0;
        peso = 2;
        for (i = 12; i >= 0; i--) {
            num = (int) (cnpjLimpo.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10) peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1)) dig14 = '0';
        else dig14 = (char) ((11 - r) + 48);

        if ((dig13 != cnpjLimpo.charAt(12)) || (dig14 != cnpjLimpo.charAt(13))) {
            throw new ErroDePreenchimentoInvalidoException("O CNPJ informado é inválido.");
        }
    }
}