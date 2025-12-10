package br.univ.pharmasys.model;
//a
import br.univ.pharmasys.service.medicamentoComprimidoValidador;
//a
import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;

public class medicamentoComprimido extends Medicamento {

    private int quantidadeComprimidos;

    public medicamentoComprimido() {
        super();
    }

    public int getQuantidadeComprimidos() {
        return quantidadeComprimidos;
    }

    public void setQuantidadeComprimidos(int quantidadeComprimidos) {
    	medicamentoComprimidoValidador.validarQuantidade(quantidadeComprimidos);
        this.quantidadeComprimidos = quantidadeComprimidos;
    }
}