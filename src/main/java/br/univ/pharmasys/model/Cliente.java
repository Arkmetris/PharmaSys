package br.univ.pharmasys.model;

//CPF_CLIENTE VARCHAR(11) NOT NULL,
//  SEXO VARCHAR(10),
//  NOME VARCHAR(200),
//  PRIMARY KEY (CPF_CLIENTE)

import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;
import br.univ.pharmasys.service.ClienteValidador;
import br.univ.pharmasys.util.ValidadorUtils;

public class Cliente {
    protected String cpf;
    protected String sexo;
    protected String nome;

    public Cliente(){

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        cpf = cpf.trim();

        if(cpf == null || cpf.trim().isEmpty()){
            throw new ErroDePreenchimentoInvalidoException("O CPF deve ser preenchido!");
        }

        boolean valido = ValidadorUtils.cpfValido(cpf);
        if(!valido){
            throw new ErroDePreenchimentoInvalidoException("Atenção: Verifique os dígitos!");
        }
        cpf=cpf.replaceAll("\\D", "");
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        sexo = sexo.trim();
        ClienteValidador.sexoValidar(sexo);
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome.trim();
        ClienteValidador.nomeValidar(nome);
        this.nome = nome;
    }
}



