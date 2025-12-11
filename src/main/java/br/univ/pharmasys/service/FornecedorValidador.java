package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.IdInvalidoException;
import br.univ.pharmasys.exceptions.NomeInvalidoException;

public class FornecedorValidador {

    public static void idFornecedorValidar(long id){
        if(id <= 0){
            throw new IdInvalidoException("\nO ID de um fornecedor deve ser sempre positivo e maior que zero");
        }
    }

    public static void nomeValidar(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new NomeInvalidoException("\nPreencha o campo Nome");
        }
        if(!nome.matches("[\\p{L} ]+")){
            throw new NomeInvalidoException("Atenção: Preencha o campo Nome corretamente, sem números ou símbolos");
        }
    }

    public static void cnpjValidar(String cnpj){
        if(cnpj == null || cnpj.trim().isEmpty()){
            throw new NomeInvalidoException("\nPreencha o campo CNPJ");
        }
    }

    public static void estadoValidar(String estado){
        if(estado == null || estado.trim().isEmpty()){
            throw new NomeInvalidoException("\nPreencha o campo Estado");
        }
        if(!estado.matches("[a-zA-Z]{2}")){
            throw new NomeInvalidoException("Atenção: O Estado deve conter apenas a sigla (2 letras)");
        }
    }

    public static void cepValidar(String cep){
        if(cep == null || cep.trim().isEmpty()){
            throw new NomeInvalidoException("\nPreencha o campo CEP");
        }
    }

    public static void ruaValidar(String rua){
        if(rua == null || rua.trim().isEmpty()){
            throw new NomeInvalidoException("\nPreencha o campo Rua");
        }
    }

    public static void bairroValidar(String bairro){
        if(bairro == null || bairro.trim().isEmpty()){
            throw new NomeInvalidoException("\nPreencha o campo Bairro");
        }
    }

    public static void cidadeValidar(String cidade){
        if(cidade == null || cidade.trim().isEmpty()){
            throw new NomeInvalidoException("\nPreencha o campo Cidade");
        }
        if(!cidade.matches("[\\p{L} ]+")){
            throw new NomeInvalidoException("Atenção: Preencha o campo Cidade corretamente, apenas letras");
        }
    }

    public static void emailValidar(String email){
        if(email == null || email.trim().isEmpty()){
            throw new NomeInvalidoException("\nPreencha o campo Email");
        }
    }

    public static void telefoneIdValidar(Long telefoneId){
        if(telefoneId == null || telefoneId <= 0){
            throw new IdInvalidoException("\nO ID do Telefone é inválido");
        }
    }
}