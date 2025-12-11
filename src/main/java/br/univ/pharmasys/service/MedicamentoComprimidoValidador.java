package br.univ.pharmasys.service;
//a
import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;

public class MedicamentoComprimidoValidador {

    public static void validarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new ErroDePreenchimentoInvalidoException("A quantidade de comprimidos deve ser maior que zero.");
        }
    }
}
