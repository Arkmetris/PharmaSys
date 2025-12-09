package br.univ.pharmasys.service;

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
        //Vai validar o nome tendo apenas letras e caracteres como "ç" ou "ã".
        if(!nome.matches("[\\p{L} ]+")){

            throw new NomeInvalidoException("Atenção: Preencha o campo corretamente, sem números ou símbolos");
        }
    }
}
