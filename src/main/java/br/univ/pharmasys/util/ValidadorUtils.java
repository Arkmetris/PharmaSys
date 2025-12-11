package br.univ.pharmasys.util;
//a
import java.util.regex.Pattern;


	public class ValidadorUtils {

	    public static boolean emailValido(String email) {
	        if (email == null || email.isEmpty()) return false;
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	        Pattern pat = Pattern.compile(emailRegex);
	        return pat.matcher(email).matches();
	    }
	    
	    public static boolean cpfValido(String cpf) {

	        if (cpf == null || cpf.trim().isEmpty()) return false;

	        cpf = cpf.replaceAll("\\D", "");

	        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
	            return false;
	        }

	        char dig10, dig11;
	        int sm, i, r, num, peso;

	        sm = 0;
	        peso = 10;
	        for (i = 0; i < 9; i++) {
	            num = (int) (cpf.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	        }

	        r = 11 - (sm % 11);
	        if ((r == 10) || (r == 11)) dig10 = '0';
	        else dig10 = (char) (r + 48);
	        
	        sm = 0;
	        peso = 11;
	        for (i = 0; i < 10; i++) {
	            num = (int) (cpf.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	        }

	        r = 11 - (sm % 11);
	        if ((r == 10) || (r == 11)) dig11 = '0';
	        else dig11 = (char) (r + 48);
	        return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
	    }
	    
	    public static boolean cnpjValido(String cnpj) {

	        if (cnpj == null || cnpj.trim().isEmpty()) return false;


	        cnpj = cnpj.replaceAll("\\D", "");


	        if (cnpj.length() != 14 || cnpj.matches("(\\d)\\1{13}")) return false;


	        char dig13, dig14;
	        int sm, i, r, num, peso;


	        sm = 0;
	        peso = 2;
	        for (i = 11; i >= 0; i--) {
	            num = (int) (cnpj.charAt(i) - 48);
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
	            num = (int) (cnpj.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso + 1;
	            if (peso == 10) peso = 2;
	        }

	        r = sm % 11;
	        if ((r == 0) || (r == 1)) dig14 = '0';
	        else dig14 = (char) ((11 - r) + 48);

	        return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));
	    }
	    
	}
