package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.CustoUnitarioInvalidoException;
import br.univ.pharmasys.exceptions.DataInvalidoException;
import br.univ.pharmasys.exceptions.IdInvalidoException;
import br.univ.pharmasys.exceptions.QuantidadeInvalidaException;

import java.time.LocalDate;
import java.math.BigDecimal;

public class PedidoValidador {

    //Aqui está todas as validações de pedido!

    public static void idPedidoValidar(long id) {

        if (id <= 0) {

            throw new IdInvalidoException("\nError: O ID de um pedido precisa ser positivo");
        }
    }

    public static void quantidadeValidar(int quantidade) {
        if (quantidade <= 0) {
            throw new QuantidadeInvalidaException("Preencha uma quantidade válida");
        }
    }

    public static void dataPedidoValidar(LocalDate data) {

        if (data == null) {
            throw new DataInvalidoException("Error: A data do pedido é obrigatória!");
        }

        if (data.isAfter(LocalDate.now())) {

            throw new DataInvalidoException("Error: data do pedido não pode ser futura!");
        }
    }

    public static void precoValido(BigDecimal preco) {
        if (preco == null) {
            throw new CustoUnitarioInvalidoException("O preço não pode ser nulo.");
        }

        if (preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new CustoUnitarioInvalidoException("O preço deve ser maior que zero.");
        }
    }

}
