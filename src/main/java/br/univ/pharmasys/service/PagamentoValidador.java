package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.CustoUnitarioInvalidoException;
import br.univ.pharmasys.exceptions.DataInvalidoException;
import br.univ.pharmasys.exceptions.ErroDePreenchimentoInvalidoException;
import br.univ.pharmasys.exceptions.IdInvalidoException;

import br.univ.pharmasys.model.MetodoPagamento;
import br.univ.pharmasys.model.Pedido;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PagamentoValidador {

    public static void idPagamentoValidador(long idPagamento) {
        if (idPagamento <= 0) {

            throw new IdInvalidoException("\nError: O ID de um pagamento precisa ser positivo");

        }
    }

    public static void idPedidoValidador(Pedido idPedido){

        if (idPedido == null){
            throw new ErroDePreenchimentoInvalidoException("O pedido não pode ser nulo.");
        }
    }

    public static void dataPagamentoValidador(LocalDate dataPagamento) {
        if (dataPagamento == null) {
            throw new DataInvalidoException("A data de pagamento não pode ser nula.");
        }

        if (dataPagamento.isBefore(LocalDate.now())) {
            throw new DataInvalidoException("A data de pagamento deve ser futura.");
        }
    }

    public static void valorValidador(BigDecimal valor){
        if (valor == null){
            throw new CustoUnitarioInvalidoException("\nError:Não pode ser nulo!");
        }
        else if (valor.compareTo(BigDecimal.ZERO)== 0){
            throw new CustoUnitarioInvalidoException("Error: Não pode ser zero!");
        }
        else if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new CustoUnitarioInvalidoException("Error: Não pode ser negativo!");
        }
    }

   public static void qrCodeValidador(String qrCode) {
       if (qrCode == null || qrCode.trim().isEmpty()) {
           throw new ErroDePreenchimentoInvalidoException("O QR Code do Pix deve ser informado.");
       }

       qrCode = qrCode.trim();

       // QR Code Pix (EMV) normalmente tem dezenas ou centenas de caracteres
       if (qrCode.length() < 20) {
           throw new ErroDePreenchimentoInvalidoException("QR Code do Pix inválido.");
       }
    }

    public static void metodoValidador(MetodoPagamento metodo) {
        if (metodo == null) {
            throw new ErroDePreenchimentoInvalidoException(
                    "O método de pagamento deve ser informado."
            );
        }
    }
}
