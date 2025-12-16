package br.univ.pharmasys.model;

import br.univ.pharmasys.service.MedicamentoTopicoValidador;

public class MedicamentoTopico extends Medicamento {

    private double pesoGramas;   
    private String tipoEmbalagem; 

    public MedicamentoTopico() {
        super();
    }

    public double getPesoGramas() {
        return pesoGramas;
    }

    public void setPesoGramas(double pesoGramas) {
        MedicamentoTopicoValidador.validarPeso(pesoGramas);
        this.pesoGramas = pesoGramas;
    }

    public String getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void setTipoEmbalagem(String tipoEmbalagem) {
        tipoEmbalagem = tipoEmbalagem.trim();
        MedicamentoTopicoValidador.validarTipoEmbalagem(tipoEmbalagem);
        this.tipoEmbalagem = tipoEmbalagem.trim();
    }
    
    @Override
    public String toString() {
        return "MedicamentoTopico [SKU=" + getSku() + ", Peso=" + pesoGramas + "g, Embalagem=" + tipoEmbalagem + "]";
    }
}