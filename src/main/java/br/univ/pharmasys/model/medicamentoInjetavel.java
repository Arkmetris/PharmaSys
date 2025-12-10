package br.univ.pharmasys.model;
//b
import br.univ.pharmasys.service.medicamentoInjetavelValidador;

public class medicamentoInjetavel extends Medicamento {

    private String viaAdministracao;
    private double temperaturaMinima;
    private double temperaturaMaxima;

    public medicamentoInjetavel() {
        super();
    }

    public String getviaAdministracao() {
        return viaAdministracao;
    }

    public void setviaAdministracao(String viaAdministracao) {
        medicamentoInjetavelValidador.validarViaAdministracao(viaAdministracao);
        this.viaAdministracao = viaAdministracao.trim();
    }

    public double gettemperaturaMinima() {
        return temperaturaMinima;
    }

    public void settemperaturaMinima(double temperaturaMinima) {
        medicamentoInjetavelValidador.validarTemperatura(temperaturaMinima, this.temperaturaMaxima);
        this.temperaturaMinima = temperaturaMinima;
    }

    public double gettemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void settemperaturaMaxima(double temperaturaMaxima) {
        medicamentoInjetavelValidador.validarTemperatura(this.temperaturaMinima, temperaturaMaxima);
        this.temperaturaMaxima = temperaturaMaxima;
    }
}