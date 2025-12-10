package br.univ.pharmasys.model;

import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;

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
        if (viaAdministracao == null || viaAdministracao.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("A via de administração é obrigatória.");
        }

        viaAdministracao = viaAdministracao.trim();

        if (!viaAdministracao.matches("\\S+")) {
            throw new ErroDePreenchimentoInvalidoException("A via de administração não pode conter espaços.");
        }

        this.viaAdministracao = viaAdministracao;
    }

    public double gettemperaturaMinima() {
        return temperaturaMinima;
    }

    public void settemperaturaMinima(double temperaturaMinima) {

    	if (this.temperaturaMaxima != 0 && temperaturaMinima > this.temperaturaMaxima) {
            throw new ErroDePreenchimentoInvalidoException("A temperatura mínima não pode ser maior que a temperatura máxima.");
        }
        
        this.temperaturaMinima = temperaturaMinima;
    }

    public double gettemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void settemperaturaMaxima(double temperaturaMaxima) {

    	if (temperaturaMaxima < this.temperaturaMinima) {
            throw new ErroDePreenchimentoInvalidoException("A temperatura máxima não pode ser menor que a temperatura mínima.");
        }

        this.temperaturaMaxima = temperaturaMaxima;
    }
}