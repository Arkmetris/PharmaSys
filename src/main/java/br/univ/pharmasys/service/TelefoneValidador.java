package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;
import br.univ.pharmasys.exceptions.IdInvalidoException;
import br.univ.pharmasys.exceptions.TelefoneInvalidoException;

public class TelefoneValidador {


    public static void idTelefoneValidar(long id) {


        if (id <= 0) {
            throw new IdInvalidoException("\nError: O ID de um fornecedor deve ser sempre positiva e maior que zero");

        }
    }

    public static void numeroTelefoneValidar(String numerotelefone) {

        if (numerotelefone == null || numerotelefone.trim().isEmpty()) {

            throw new TelefoneInvalidoException("Error: Preencha o campo de telefone!");
        }

        numerotelefone = numerotelefone.replaceAll("\\D", "");

        //Vai determinar o número de telefone com apenas 11 dígitos (sendo apenas números, claro).
        if(numerotelefone.matches("^\\{11}$")){

            throw new ErroDePreenchimentoInvalidoException("Atenção: Preencha o campo corretamente!");

        }
    }
}
