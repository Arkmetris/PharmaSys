package br.univ.pharmasys.model;
//b
import br.univ.pharmasys.service.MedicamentoInjetavelValidador;

public class MedicamentoInjetavel extends Medicamento {

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
        MedicamentoInjetavelValidador.validarTemperatura(temperaturaMinima, this.temperaturaMaxima);
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        MedicamentoInjetavelValidador.validarTemperatura(this.temperaturaMinima, temperaturaMaxima);
        this.temperaturaMaxima = temperaturaMaxima;
    }
}