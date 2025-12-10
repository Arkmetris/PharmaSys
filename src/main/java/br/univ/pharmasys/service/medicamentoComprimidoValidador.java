package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;

public class medicamentoComprimidoValidador {

    public static void validarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new ErroDePreenchimentoInvalidoException("A quantidade de comprimidos deve ser maior que zero.");
        }
    }
}
