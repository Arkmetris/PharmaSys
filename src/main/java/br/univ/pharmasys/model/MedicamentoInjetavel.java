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

    public String getviaAdministracao() {
        return viaAdministracao;
    }

    public void setviaAdministracao(String viaAdministracao) {
        MedicamentoInjetavelValidador.validarViaAdministracao(viaAdministracao);
        this.viaAdministracao = viaAdministracao.trim();
    }

    public double gettemperaturaMinima() {
        return temperaturaMinima;
    }

    public void settemperaturaMinima(double temperaturaMinima) {
        MedicamentoInjetavelValidador.validarTemperatura(temperaturaMinima, this.temperaturaMaxima);
        this.temperaturaMinima = temperaturaMinima;
    }

    public double gettemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void settemperaturaMaxima(double temperaturaMaxima) {
        MedicamentoInjetavelValidador.validarTemperatura(this.temperaturaMinima, temperaturaMaxima);
        this.temperaturaMaxima = temperaturaMaxima;
    }
}