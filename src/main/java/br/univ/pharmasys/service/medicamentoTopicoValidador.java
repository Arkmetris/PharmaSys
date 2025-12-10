package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;

public class medicamentoTopicoValidador {

    public static void validarPeso(double peso) {
        if (peso <= 0) {
            throw new ErroDePreenchimentoInvalidoException("O peso em gramas deve ser maior que zero.");
        }
    }

    public static void validarTipoEmbalagem(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O tipo de embalagem é obrigatório.");
        }
        if (!tipo.trim().matches("\\S+")) {
            throw new ErroDePreenchimentoInvalidoException("O tipo de embalagem não pode conter espaços.");
        }
    }
}
