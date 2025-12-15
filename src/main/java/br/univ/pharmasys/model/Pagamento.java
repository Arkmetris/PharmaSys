package br.univ.pharmasys.model;

import br.univ.pharmasys.service.PagamentoValidador;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pagamento {

    private long  idPagamento;
    private Pedido idPedido;
    private MetodoPagamento metodo;
    private BigDecimal valor;
    private LocalDate dataPagamento;
    private String qrCode;

    public Pagamento(){

    }

     public long getIdPagamento() {
        return idPagamento;
     }

     public void setIdPagamento(long idPagamento) {
        PagamentoValidador.idPagamentoValidador(idPagamento);
        this.idPagamento = idPagamento;
     }

     public Pedido getIdPedido() {
        return idPedido;
     }

     public void setIdPedido(Pedido idPedido) {
        PagamentoValidador.idPedidoValidador(idPedido);
        this.idPedido = idPedido;
     }

     public MetodoPagamento getMetodo() {
        return metodo;
     }

     public void setMetodo(MetodoPagamento metodo) {
        PagamentoValidador.metodoValidador(metodo);
        this.metodo = metodo;

        if(metodo != MetodoPagamento.PIX){
            this.qrCode = null;
        }
     }

     public BigDecimal getValor() {
        return valor;
     }

     public void setValor(BigDecimal valor) {
        PagamentoValidador.valorValidador(valor);
        this.valor = valor;
     }

     public LocalDate getDataPagamento() {
        return dataPagamento;
     }

     public void setDataPagamento(LocalDate dataPagamento) {
        PagamentoValidador.dataPagamentoValidador(dataPagamento);
        this.dataPagamento = dataPagamento;
     }

     public String getQrCode() {
        return qrCode;
     }

     public void setQrCode(String qrCode) {
         if (metodo == null) {
             throw new IllegalStateException("Defina o método de pagamento antes de informar o QR Code.");
         }

         if (metodo != MetodoPagamento.PIX) {
             throw new IllegalStateException("QR Code só é permitido para pagamento via Pix.");
         }
         PagamentoValidador.qrCodeValidador(qrCode);
         this.qrCode = qrCode.trim();
     }

}
