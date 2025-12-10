package br.univ.pharmasys.model;
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
        
        if (quantidadeComprimidos <= 0) {
            throw new ErroDePreenchimentoInvalidoException("A quantidade de comprimidos deve ser maior que zero.");
        }
        this.quantidadeComprimidos = quantidadeComprimidos;
    }
}