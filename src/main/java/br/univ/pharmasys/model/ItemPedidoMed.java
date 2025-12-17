package br.univ.pharmasys.model;

import br.univ.pharmasys.service.ItemPedidoMedValidador;

import java.math.BigDecimal;

public class ItemPedidoMed {

    private long idItemPedido;
    private Pedido idPedido;
    private Medicamento skuMedicamento;
    private int quantidade;
    private BigDecimal valorItem;
    private BigDecimal subtotal;

    public ItemPedidoMed() {

    }

    public long getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(long idItemPedido) {
        ItemPedidoMedValidador.idItemPedidoValidador(idItemPedido);
        this.idItemPedido = idItemPedido;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        ItemPedidoMedValidador.pedidoValidador(idPedido);
        this.idPedido = idPedido;
    }

    public Medicamento getSkuMedicamento() {
        return skuMedicamento;
    }

    public void setSkuMedicamento(Medicamento skuMedicamento) {
        ItemPedidoMedValidador.medicamentoValidador(skuMedicamento);
        this.skuMedicamento = skuMedicamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        ItemPedidoMedValidador.quantidadeValidador(quantidade);
        this.quantidade = quantidade;
    }

    public BigDecimal getValorItem() {
        return valorItem;
    }

    public void setValorItem(BigDecimal valorItem) {
        ItemPedidoMedValidador.valorValidador(valorItem);
        this.valorItem = valorItem;
        calcularSubtotal();
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    private void calcularSubtotal() {
        if (this.valorItem == null || this.quantidade <= 0) {
            this.subtotal= BigDecimal.ZERO;
            return;
        }

        this.subtotal = valorItem.multiply(BigDecimal.valueOf(quantidade));

    }

}


