package br.univ.pharmasys.model;

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
        ValidadorUtils.cpfValido(cpf);
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



