package br.univ.pharmasys.model;

import br.univ.pharmasys.service.MedicamentoLiquidoValidador;

public class MedicamentoLiquido extends Medicamento {

    private double volumeMl;      
    private String tipoRecipiente;

    public MedicamentoLiquido() {
        super();
    }

    public double getVolumeMl() {
        return volumeMl;
    }

    public void setVolumeMl(double volumeMl) {
        MedicamentoLiquidoValidador.validarVolume(volumeMl);
        this.volumeMl = volumeMl;
    }

    public String getTipoRecipiente() {
        return tipoRecipiente;
    }

    public void setTipoRecipiente(String tipoRecipiente) {
        MedicamentoLiquidoValidador.validarTipoRecipiente(tipoRecipiente);
        this.tipoRecipiente = tipoRecipiente.trim();
    }

    @Override
    public String toString() {
        return "MedicamentoLiquido [SKU=" + getSku() + ", Volume=" + volumeMl + "ml, Recipiente=" + tipoRecipiente + "]";
    }
}