package br.univ.pharmasys.service;
//a
import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;

public class MedicamentoInjetavelValidador {

    public static void validarViaAdministracao(String via) {
        if (via == null || via.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("A via de administração é obrigatória.");
        }
        if (!via.trim().matches("\\S+")) {
            throw new ErroDePreenchimentoInvalidoException("A via de administração não pode conter espaços.");
        }
    }

    public static void validarTemperatura(double min, double max) {
    	// Só valida se o Max já tiver sido setado

        if (max != 0 && min > max) {
            throw new ErroDePreenchimentoInvalidoException("A temperatura mínima não pode ser maior que a máxima.");
        }
    }
}