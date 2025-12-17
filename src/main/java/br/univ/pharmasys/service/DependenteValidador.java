package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;
import br.univ.pharmasys.model.Funcionario;
import java.time.LocalDate;

public class DependenteValidador {

    public static void validarFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new ErroDePreenchimentoInvalidoException("O dependente deve estar vinculado a um funcionário.");
        }
    }

    public static void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O nome do dependente é obrigatório.");
        }
        if (!nome.trim().matches(".*\\S.*")) { 
            // Permite nomes compostos poremn não sem ter espaços vazios
             throw new ErroDePreenchimentoInvalidoException("Nome inválido.");
        }
    }

    public static void validarParentesco(String parentesco) {
        if (parentesco == null || parentesco.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O grau de parentesco é obrigatório.");
        }
    }

    public static void validarDataNascimento(LocalDate data) {
        if (data == null) {
            throw new ErroDePreenchimentoInvalidoException("A data de nascimento é obrigatória.");
        }
        if (data.isAfter(LocalDate.now())) {
            throw new ErroDePreenchimentoInvalidoException("A data de nascimento não pode ser futura.");
        }
    }
}