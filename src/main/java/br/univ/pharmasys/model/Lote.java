package br.univ.pharmasys.model;

import br.univ.pharmasys.service.LoteValidador;

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


    public String getSkuMedicamento(){

        return this.skuMedicamento;
    }

    public void setSkuMedicamento(String skuMedicamento){
        skuMedicamento = skuMedicamento.trim();
        LoteValidador.skuMedicamentoValidar(skuMedicamento);
        this.skuMedicamento = skuMedicamento;
    }



    public LocalDate getValidade(){
        return this.validade;
    }

    public void setValidade(LocalDate validade){

        LoteValidador.dataValidadadeValidador(validade);
        this.validade = validade;
    }

    public int getNumeroLote(){
        return this.numeroLote;
    }

    public void setNumeroLote(int numeroLote){

        LoteValidador.numeroLoteValidador(numeroLote);
        this.numeroLote = numeroLote;
    }

    public int getQuantidadeRecebida(){
        return this.quantidadeRecebida;
    }

    public void setQuantidadeRecebida(int quantidadeRecebida){

        LoteValidador.quantidadeRecebidaValidador(quantidadeRecebida);
        this.quantidadeRecebida = quantidadeRecebida;
    }

    public int getQuantidadeAtual(){
        return this.quantidadeAtual;
    }

    public void setQuantidadeAtual(int quantidadeAtual){

        LoteValidador.quantidadeAtualValidador(quantidadeAtual);
        this.quantidadeAtual = quantidadeAtual;
    }

    public BigDecimal getPreco(){

        return this.preco;
    }

    public void setPreco(BigDecimal preco){

        LoteValidador.precoValidador(preco);
        this.preco = preco;

    }
}