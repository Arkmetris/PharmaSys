package br.univ.pharmasys.model;
//b
import br.univ.pharmasys.service.MedicamentoInjetavelValidador;

public class MedicamentoInjetavel extends Medicamento { //correção

    private String viaAdministracao;
    private double temperaturaMinima;
    private double temperaturaMaxima;

    public MedicamentoInjetavel() {
        super();
    }

    public String getViaAdministracao() {
        return viaAdministracao;
    }

    public void setViaAdministracao(String viaAdministracao) {
        MedicamentoInjetavelValidador.validarViaAdministracao(viaAdministracao);
        this.viaAdministracao = viaAdministracao.trim();
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
      if(this.temperaturaMaxima != 0) {
          MedicamentoInjetavelValidador.validarTemperatura(temperaturaMinima, this.temperaturaMaxima);
      }
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
       if(this.temperaturaMinima != 0) {
           MedicamentoInjetavelValidador.validarTemperatura(this.temperaturaMinima, temperaturaMaxima);
       }
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public abstract void delete(String sku);
}