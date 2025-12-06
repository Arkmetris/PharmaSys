package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.CpfInvalidoException;
import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;
import br.univ.pharmasys.exceptions.NomeInvalidoException;

public class ClienteValidador {

    public static void cpfValidar(String cpf){

        if(cpf==null || cpf.trim().isEmpty()){
            throw new CpfInvalidoException("Error: Campo não foi preenchido!");
        }

        cpf = cpf.replaceAll("\\D", "");

        if(cpf.length()!=11){
            throw new CpfInvalidoException("Error: todo CPF deve conter 11 digitos!");
        }

    }

    public static void nomeValidar(String nome){

        if(nome==null || nome.trim().isEmpty()){
            throw new NomeInvalidoException("\nError: O Campo deve ser preenchido, não pode ficar vazio! ");
        }

    }

    public static void sexoValidar(String sexo){

        if(sexo==null || sexo.trim().isEmpty()){
            throw new ErroDePreenchimentoInvalidoException("Error: Campo não foi preenchido!");
        }

        sexo = sexo.trim();

        if(!sexo.matches("\\S+")){

            throw new ErroDePreenchimentoInvalidoException("Atenção: Não pode ter espaçamentos nesse campo");
        }

    }
}
