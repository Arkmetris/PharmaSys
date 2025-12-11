package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;
import br.univ.pharmasys.exceptions.IdInvalidoException;
import br.univ.pharmasys.exceptions.TelefoneInvalidoException;

public class TelefoneValidador {


    public static void idTelefoneValidar(long id) {


        if (id <= 0) {
            throw new IdInvalidoException("Error: O id do telefone precisa ser positivo e não nulo!");
        }
    }

    public static void numeroTelefoneValidar(String numerotelefone) {

        if (numerotelefone == null || numerotelefone.trim().isEmpty()) {

            throw new TelefoneInvalidoException("Error: Preencha o campo de telefone!");
        }

        String numeroLimpo = numerotelefone.replaceAll("[^0-9]", ""); //vai limpar todos os caracteres não numéricos

        //Vai determinar o número de telefone com apenas 11 dígitos (sendo apenas números, claro).
        if(!numeroLimpo.matches("^\\d{11}$")){

            throw new ErroDePreenchimentoInvalidoException("Atenção: O telefone deve contar 11 digitos (DDD + número)!");
        }

        int ddd = Integer.parseInt(numeroLimpo.substring(0, 2)); //Vai pegar os 2 dígitos e analisar se é válido ou não
        if (ddd < 11 || ddd > 99) {
            throw new ErroDePreenchimentoInvalidoException("Atenção: DDD inválido. Deve estar entre 11 e 99.");
        }
    }
}
