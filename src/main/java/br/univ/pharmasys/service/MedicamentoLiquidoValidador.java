package br.univ.pharmasys.service;
import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;

public class MedicamentoLiquidoValidador {

    public static void validarVolume(double volume) {
        if (volume <= 0) {
            throw new ErroDePreenchimentoInvalidoException("O volume em ml deve ser maior que zero.");
        }
    }

    public static void validarTipoRecipiente(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O tipo de recipiente é obrigatório.");
        }
        if (!tipo.trim().matches("\\S+")) {
            throw new ErroDePreenchimentoInvalidoException("O tipo de recipiente não pode conter espaços.");
        }
    }
}