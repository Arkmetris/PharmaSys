package br.univ.pharmasys.model;
//b
import br.univ.pharmasys.service.medicamentoTopicoValidador;

public class medicamentoTopico extends Medicamento {

    private double pesoGramas;   
    private String tipoEmbalagem; 

    public medicamentoTopico() {
        super();
    }

    public double getpesoGramas() {
        return pesoGramas;
    }

    public void setPesoGramas(double pesoGramas) {
        medicamentoTopicoValidador.validarPeso(pesoGramas);
        this.pesoGramas = pesoGramas;
    }

    public String gettipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void setTipoEmbalagem(String tipoEmbalagem) {
        medicamentoTopicoValidador.validarTipoEmbalagem(tipoEmbalagem);
        this.tipoEmbalagem = tipoEmbalagem.trim();
    }
    
    @Override
    public String toString() {
        return "MedicamentoTopico [SKU=" + getSku() + ", Peso=" + pesoGramas + "g, Embalagem=" + tipoEmbalagem + "]";
    }
}