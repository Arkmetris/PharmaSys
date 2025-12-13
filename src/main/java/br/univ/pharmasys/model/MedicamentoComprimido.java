package br.univ.pharmasys.model;
//a
import br.univ.pharmasys.service.MedicamentoComprimidoValidador;
//a
import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;

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