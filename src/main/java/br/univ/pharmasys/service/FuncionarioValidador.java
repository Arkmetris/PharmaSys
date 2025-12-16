package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.*;
import java.time.LocalDate;

public class FuncionarioValidador {

    public static void idFuncionarioValidar(long id) {

        if (id <= 0) {

            throw new IdInvalidoException("\nError: O ID de um funcionário precisa ser positivo");

        }
    }

    public static void nomeValidar(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new NomeInvalidoException("\nError: O Campo deve ser preenchido, não pode ficar vazio! ");
        }
        //Vai validar o nome tendo apenas letras e caracteres como "ç" ou "ã".
        if (!nome.matches("[\\p{L} ]+")) {

            throw new NomeInvalidoException("Atenção: Preencha o campo corretamente, sem números ou símbolos");
        }
    }

    public static void dataNascimentoValidar(LocalDate dataNascimento) {

        if (dataNascimento == null) {
            throw new DataInvalidoException("Error: O Campo deve ser preenchido!");
        }

        if (dataNascimento.isAfter(LocalDate.now())) {

            throw new DataInvalidoException("Error: data de nascimento inválida");
        }
    }

    public static void sexoValidar(String sexo) {

        if (sexo == null || sexo.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("Error: Campo não foi preenchido corretamente!");
        }

        sexo = sexo.trim();

        if (!sexo.matches("\\S+")) {

            throw new ErroDePreenchimentoInvalidoException("Atenção: Não pode ter espaçamentos nesse campo");
        }

    }

    public static void senhaValidar(String senha) {
        if (senha == null || senha.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("Error: Preencha o campo de senha!");
        }

        senha = senha.trim();

        //Vai verificar se a senha possui no mínimo 8 caracteres ou no máximo 14.
        if (senha.length() < 8 || senha.length() > 14) {

            throw new ErroDePreenchimentoInvalidoException("Atenção: Senha incompleta, ela deve ter no mínimo 8 dígitos e no máximo 14 dígitos");

        }

        if (!senha.matches("[A-Za-z0-9]+")) {
            throw new ErroDePreenchimentoInvalidoException(
                    "A senha deve conter apenas letras e números, sem espaços."
            );
        }
    }
}
