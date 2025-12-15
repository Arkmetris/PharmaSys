package br.univ.pharmasys.model;

import java.time.LocalDate;
import br.univ.pharmasys.service.PedidoValidador;
import java.math.BigDecimal;

public class Pedido {
    private long idPedido;
    private int quantidade;
    private Status status;
    private LocalDate data;
    private BigDecimal preco_unitario;
    private BigDecimal valor_total;


    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        PedidoValidador.idPedidoValidar(idPedido);
        this.idPedido = idPedido;
    }

    public int getquantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        PedidoValidador.quantidadeValidar(quantidade);
        this.quantidade = quantidade;
        calcularValorTotal();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        PedidoValidador.statusValidador(status);
        this.status = status;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        PedidoValidador.dataPedidoValidar(data);
        this.data = data;
    }

    public BigDecimal getPrecoUnitario() {
        return preco_unitario;
    }

    public void setPrecoUnitario(BigDecimal preco_unitario) {
        PedidoValidador.precoValido(preco_unitario);
        this.preco_unitario = preco_unitario;
        calcularValorTotal();
    }

    public BigDecimal getValorTotal() {

        return valor_total;
    }

    private void calcularValorTotal() {
        if (preco_unitario == null || quantidade <= 0) {
            this.valor_total = BigDecimal.ZERO;
            return;
        }

        this.valor_total = preco_unitario
                .multiply(BigDecimal.valueOf(quantidade));
    }
}



