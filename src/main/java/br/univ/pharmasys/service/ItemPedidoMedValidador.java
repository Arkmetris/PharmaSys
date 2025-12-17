package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.*;
import br.univ.pharmasys.model.Medicamento;
import br.univ.pharmasys.model.Pedido;


import java.math.BigDecimal;

public class ItemPedidoMedValidador {

    public static void idItemPedidoValidador(long id){
        if(id <= 0){
            throw new IdInvalidoException("Error: O ID não pode ser negativo ou igual a 0");
        }
    }

    public static void pedidoValidador(Pedido idpedido){
        if(idpedido == null){
            throw new ErroDePreenchimentoInvalidoException("Um item deve estar vinculado a um pedido.");
        }
    }

    public static void medicamentoValidador(Medicamento medicamento){
        if(medicamento == null){
            throw new ErroDePreenchimentoInvalidoException("Um item deve estar vinculado a um medicamento.");
        }
    }

    public static void quantidadeValidador(int quantidade){
        if(quantidade <=0){
            throw new QuantidadeInvalidaException("Quantidade deve ser positivo ou igual a 0");
        }
    }

    public static void valorValidador(BigDecimal valor){
        if(valor == null){
            throw new PrecoInvalidoException("O valor não pode ser nulo!");
        }

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new CustoUnitarioInvalidoException("O valor deve ser maior que zero.");
        }
    }


}
