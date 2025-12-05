package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.CnpjInvalidoException;
import br.univ.pharmasys.exceptions.IdInvalidoException;
import br.univ.pharmasys.exceptions.NomeInvalidoException;

public class FornecedorValidador {

    public static void  idFornecedorValidar(long id){

        if(id <=0){
            throw new IdInvalidoException("\nError: O ID de um fornecedor deve ser sempre positiva e maior que zero");
        }

    }

    public static void  nomeValidar(String nome){

        if(nome == null || nome.trim().isEmpty()){

            throw new NomeInvalidoException("\nError: Preencha o campo");
        }
    }

    public static void  cnpjValidar(String cnpj){


        if (cnpj == null || cnpj.trim().isEmpty()){
            throw new CnpjInvalidoException("Error: Não pode ser nulo ou vazio!");
        }

        cnpj = cnpj.replaceAll("\\D", "");

        if (cnpj.length() != 14){
            throw new CnpjInvalidoException("Error: Todo CNPJ deve conter 14 dígitos!");
        }
    }

}
