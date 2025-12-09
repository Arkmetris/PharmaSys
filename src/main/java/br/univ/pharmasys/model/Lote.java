package br.univ.pharmasys.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Lote {

    private int numeroLote;              
    private String skuMedicamento;
    private LocalDate validade;
    private int quantidadeRecebida;
    private int quantidadeAtual;
    private BigDecimal preco;

    public Lote() {}

  
    public int getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getSkuMedicamento() {
        return skuMedicamento;
    }

    public void setSkuMedicamento(String skuMedicamento) {
        this.skuMedicamento = skuMedicamento;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public int getQuantidadeRecebida() {
        return quantidadeRecebida;
    }

    public void setQuantidadeRecebida(int quantidadeRecebida) {
        this.quantidadeRecebida = quantidadeRecebida;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
