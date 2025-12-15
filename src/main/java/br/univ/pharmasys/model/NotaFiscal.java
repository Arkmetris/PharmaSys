package br.univ.pharmasys.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {

    private Long id;
    private String numeroNota; // Identificador fiscal
    private LocalDateTime dataEmissao; // Rastreabilidade de Data/Hora 
    private BigDecimal valorTotal;
    
    private Funcionario funcionarioResponsavel;
    private String cpfCliente;

    private List<ItemNotaFiscal> itens; 

    public NotaFiscal() {
        this.dataEmissao = LocalDateTime.now();
        this.valorTotal = BigDecimal.ZERO;
        this.itens = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public List<ItemNotaFiscal> getItens() {
        return itens;
    }

    public void setItens(List<ItemNotaFiscal> itens) {
        this.itens = itens;
    }
    
    public void adicionarItem(ItemNotaFiscal item) {
        this.itens.add(item);
        if(item.getSubtotal() != null) {
            this.valorTotal = this.valorTotal.add(item.getSubtotal());
        }
    }

    @Override
    public String toString() {
        return "NotaFiscal [Nº=" + numeroNota + ", Data=" + dataEmissao + ", Total=" + valorTotal + "]";
    }
}