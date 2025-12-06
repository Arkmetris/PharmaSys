package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.*;
import java.time.LocalDate;

public class FuncionarioValidador {

    public static void idFuncionarioValidar(long id){

        if(id<=0){

            throw new IdInvalidoException("\nError: O ID de um funcionário precisa ser positivo");

        }
    }

    public static void nomeValidar(String nome){

       if(nome==null || nome.trim().isEmpty()){
           throw new NomeInvalidoException("\nError: O Campo deve ser preenchido, não pode ficar vazio! ");
       }
 AceitaMatheus

 main
   }

   public static void cpfValidar(String cpf){

       if(cpf==null || cpf.trim().isEmpty()){
           throw new CpfInvalidoException("Error: Campo não foi preenchido!");
       }

       cpf = cpf.replaceAll("\\D", "");

       if(cpf.length()!=11){
           throw new CpfInvalidoException("Error: todo CPF deve conter 11 digitos!");
       }

   }

   public static void dataNascimentoValidar(LocalDate dataNascimento){

       if (dataNascimento==null){
           throw new DataNascimentoInvalidoException("Error: O Campo deve ser preenchido!");
       }

       if (dataNascimento.isAfter(LocalDate.now())){

           throw new DataNascimentoInvalidoException("Error: data de nascimento inválida");
       }
   }

   public static void sexoValidar(String sexo){

       if(sexo==null || sexo.trim().isEmpty()){
           throw new ErroDePreenchimentoInvalidoException("Error: Campo não foi preenchido!");
       }

       sexo = sexo.trim();

       if(!sexo.matches("\\S+")){

           throw new ErroDePreenchimentoInvalidoException("Atenção: Não pode ter espaçamentos nesse campo");
       }

   }

   public static void telefoneValidar(String telefone){

       if(telefone ==null || telefone.isEmpty()){
           throw new TelefoneInvalidoException("Error: Preencha o campo de telefone!");
       }

       telefone = telefone.replaceAll("\\D", "");

       if(telefone.length()!=11){
           throw new TelefoneInvalidoException("Error: O número deve conter 11 digitos!");
       }
       if(telefone.trim().matches("\\S+")){


           throw new TelefoneInvalidoException("Error: O campo de telefone deve ser preenchido!");

       }
   }

    public static void senhaValidar(String senha){

        if(senha==null || senha.trim().isEmpty()){
            throw new ErroDePreenchimentoInvalidoException("Atenção: Preencha o campo de senha!");
        }
        senha = senha.trim();

        if(!senha.matches("\\S+")){
            throw new ErroDePreenchimentoInvalidoException("Falta de preenchimento da senha");
        }

    }
}
