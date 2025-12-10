package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoteValidador {

     //Aqui vai possuir todas as validações de Lote.java
    //Os valores que entrarem em Lote.java serão tratados na hora que esses métodos forem chamados

    public static void skuMedicamentoValidar(String sku) {

        if (sku == null || sku.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("\nError: Em seu lote, o sku do seu medicamento não pode ser vazio e nem nulo!");
        }

        sku = sku.trim();

        if(!sku.matches("\\S+")){
            throw new ErroDePreenchimentoInvalidoException("Não pode espaço no meio do sku");
        }


    }

    public static void dataValidadadeValidador(LocalDate data) {


        if (data == null) {

            throw new DataInvalidoException("A data de validade não pode ser nula!");
        }
        else if (data.isBefore(LocalDate.now())) {

            throw new DataInvalidoException("Error: Não tem como o produto já estar vencido!");
        }
    }

    public static void numeroLoteValidador(int numeroLote) {
        if (numeroLote <= 0) {
            throw new ErroDePreenchimentoInvalidoException("\nError: Não pode ser negativo ou igual a 0");
        }
    }

    public static void quantidadeRecebidaValidador(int quantidadeRecebida) {

        //Vai validar a quantidade recebida

        if (quantidadeRecebida < 0){
            throw new QuantidadeInvalidaException("Atenção: não pode ser negativo!");
        }
    }

    public static void quantidadeAtualValidador(int quantidadeAtual) {

        //Vai validar a quantidade atual

        if (quantidadeAtual < 0){
            throw new QuantidadeInvalidaException("Atenção: não pode ser negativo!");
        }
    }


  public static void precoValidador (BigDecimal custo) {


      if(custo == null){
          throw new CustoUnitarioInvalidoException("\nError:Não pode ser nulo!");
      }

      else if (custo.compareTo(BigDecimal.ZERO)== 0){
          throw new CustoUnitarioInvalidoException("Error: Não pode ser zero!");
      }
      else if (custo.compareTo(BigDecimal.ZERO) < 0) {
          throw new CustoUnitarioInvalidoException("Error: Não pode ser negativo!");
      }
  }

}
