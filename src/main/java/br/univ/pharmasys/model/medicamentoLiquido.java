package br.univ.pharmasys.model;
//a
import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;

import br.univ.pharmasys.service.medicamentoLiquidoValidador;

public class medicamentoLiquido extends Medicamento {

    private double volumeMl;      
    private String tipoRecipiente;

    public medicamentoLiquido() {
        super();
    }

    public double getvolumeMl() {
        return volumeMl;
    }

    public void setvolumeMl(double volumeMl) {
        medicamentoLiquidoValidador.validarVolume(volumeMl);
        this.volumeMl = volumeMl;
    }

    public String gettipoRecipiente() {
        return tipoRecipiente;
    }

    public void settipoRecipiente(String tipoRecipiente) {
        medicamentoLiquidoValidador.validarTipoRecipiente(tipoRecipiente);
        this.tipoRecipiente = tipoRecipiente.trim();
    }

    @Override
    public String toString() {
        return "MedicamentoLiquido [SKU=" + getSku() + ", Volume=" + volumeMl + "ml, Recipiente=" + tipoRecipiente + "]";
    }
}