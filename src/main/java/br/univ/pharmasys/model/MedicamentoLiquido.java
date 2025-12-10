package br.univ.pharmasys.model;

import br.univ.pharmasys.service.MedicamentoLiquidoValidador;

public class MedicamentoLiquido extends Medicamento {

    private double volumeMl;      
    private String tipoRecipiente;

    public MedicamentoLiquido() {
        super();
    }

    public double getvolumeMl() {
        return volumeMl;
    }

    public void setvolumeMl(double volumeMl) {
        MedicamentoLiquidoValidador.validarVolume(volumeMl);
        this.volumeMl = volumeMl;
    }

    public String gettipoRecipiente() {
        return tipoRecipiente;
    }

    public void settipoRecipiente(String tipoRecipiente) {
        MedicamentoLiquidoValidador.validarTipoRecipiente(tipoRecipiente);
        this.tipoRecipiente = tipoRecipiente.trim();
    }

    @Override
    public String toString() {
        return "MedicamentoLiquido [SKU=" + getSku() + ", Volume=" + volumeMl + "ml, Recipiente=" + tipoRecipiente + "]";
    }
}