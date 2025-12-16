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

        // esse bloco verifica se o nome não é pequeno ou grande demais
        if(nome.length() < 3 || nome.length() > 100){
            throw new NomeInvalidoException("\nO nome deve ter entre 3 e 100 caracteres");
        }

        //permite alguns caracteres especiais, letras com caracteres diferentes e invalida alguns outros caracteres
        if(!nome.matches("[\\p{L} .'-]+")){
            throw new NomeInvalidoException("Atenção: O nome contém caracteres inválidos");
        }
    }

    public static void estadoValidar(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            throw new NomeInvalidoException("\nPreencha o campo Estado");
        }

        //apenas letras maiúsculas e exatas duas letras
        if (!estado.matches("[A-Z]{2}")) {
            throw new NomeInvalidoException("\nO Estado deve ser a sigla (ex: PE, SP) em maiúsculo");
        }
    }

    public static void cepValidar(String cep){
        if(cep == null || cep.trim().isEmpty()){
            throw new NomeInvalidoException("\nPreencha o campo CEP");
        }

        //exatos 8 dígitos
        if(!cep.matches("\\d{8}")){
            throw new NomeInvalidoException("\nO CEP deve conter exatamente 8 números");
        }
    }

    public static void ruaValidar(String rua){
        if(rua == null || rua.trim().isEmpty()){
            throw new NomeInvalidoException("\nPreencha o campo Rua");
        }

        if(rua.length() < 3){
            throw new NomeInvalidoException("\nO nome da rua é muito curto");
        }
    }

    public static void bairroValidar(String bairro){

        if(bairro == null || bairro.trim().isEmpty()){
            throw new NomeInvalidoException("\nPreencha o campo Bairro");
        }

        if(bairro.length() < 2){
            throw new NomeInvalidoException("\nO nome do bairro é muito curto");
        }
    }

    public static void cidadeValidar(String cidade){
        if(cidade == null || cidade.trim().isEmpty()){
            throw new NomeInvalidoException("\nPreencha o campo Cidade");
        }
        if(cidade.length() < 3){
            throw new NomeInvalidoException("\nO nome da cidade é muito curto");
        }
    }
}