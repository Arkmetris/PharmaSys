package br.univ.pharmasys.model;

import br.univ.pharmasys.service.TelefoneValidador;

public class Telefone {

    private long idTelefone;
    private String numeroTelefone;


    public Telefone() {}

    public long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(long idTelefone) {

        TelefoneValidador.idTelefoneValidar(idTelefone);
        this.idTelefone = idTelefone;

    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        numeroTelefone = numeroTelefone.trim();
        TelefoneValidador.numeroTelefoneValidar(numeroTelefone);
        this.numeroTelefone = numeroTelefone;
    }
}
