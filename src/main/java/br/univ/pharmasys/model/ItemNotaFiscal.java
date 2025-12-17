package br.univ.pharmasys.model;

import java.math.BigDecimal;

public class ItemNotaFiscal {

    private long idItem;
    private NotaFiscal notaFiscal; // Vincula à nota pai
    private Medicamento medicamento; // Vincula ao produto
    private int quantidade;
    private BigDecimal precoUnitario; // Preço no momento da venda
    private BigDecimal subtotal;

    public ItemNotaFiscal() {
    }

    public ItemNotaFiscal(Medicamento medicamento, int quantidade, BigDecimal precoUnitario) {
        this.medicamento = medicamento;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        calcularSubtotal();
    }

    private void calcularSubtotal() {
        if (this.precoUnitario != null && this.quantidade > 0) {
            this.subtotal = this.precoUnitario.multiply(new BigDecimal(this.quantidade));
        } else {
            this.subtotal = BigDecimal.ZERO;
        }
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        calcularSubtotal();
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
        calcularSubtotal();
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}