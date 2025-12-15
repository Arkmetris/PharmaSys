package br.univ.pharmasys.model;

import br.univ.pharmasys.service.MedicamentoComprimidoValidador;

public class MedicamentoComprimido extends Medicamento {

    private int quantidadeComprimidos;

    public MedicamentoComprimido() {
        super();
    }

    public int getQuantidadeComprimidos() {
        return quantidadeComprimidos;
    }

    public void setQuantidadeComprimidos(int quantidadeComprimidos) {
    	MedicamentoComprimidoValidador.validarQuantidade(quantidadeComprimidos);
        this.quantidadeComprimidos = quantidadeComprimidos;
    }

}