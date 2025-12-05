package br.univ.pharmasys.model;

import java.time.LocalDate;
import java.math.BigDecimal;

import br.univ.pharmasys.service.LoteValidador;

public class Lote {
    
  private long idLote;               
  private String skuMedicamento;      
  private String numeroLote;         
  private LocalDate dataValidade;    
  private int quantidade;            
  private BigDecimal custoUnitario;

  public Lote(long idLote, String skuMedicamento, String numeroLote, LocalDate dataValidade, int quantidade, BigDecimal custoUnitario) {

      LoteValidador.idLoteValidador(idLote);
      LoteValidador.skuMedicamentoValidar(skuMedicamento);
      LoteValidador.numeroLoteValidador(numeroLote);
      LoteValidador.dataValidadadeValidador(dataValidade);
      LoteValidador.quantidadeValidador(quantidade);
      LoteValidador.custoUnitarioValidador(custoUnitario);

      this.idLote = idLote;
      this.skuMedicamento = skuMedicamento;
      this.numeroLote = numeroLote;
      this.dataValidade = dataValidade;
      this.quantidade = quantidade;
      this.custoUnitario = custoUnitario;

  }
  
  public long getIdLote(){

      return this.idLote;
  }
  
  public void setIdLote(long idLote){

      LoteValidador.idLoteValidador(idLote);
      this.idLote = idLote;
  }
  
  public String getSkuMedicamento(){

      return this.skuMedicamento;
  }
  
  public void setSkuMedicamento(String skuMedicamento){

      LoteValidador.skuMedicamentoValidar(skuMedicamento);
      skuMedicamento = skuMedicamento.trim();
      
      this.skuMedicamento = skuMedicamento;
  }
  
  public String getNumeroLote(){
    return this.numeroLote;
  }
  
  public void setNumeroLote(String numeroLote){


      LoteValidador.numeroLoteValidador(numeroLote);
      numeroLote = numeroLote.trim();
      
      this.numeroLote = numeroLote;
  }
  
  public LocalDate getDataValidade(){
     return this.dataValidade;
  }
  
  public void setDataValidade(LocalDate dataValidade){

      LoteValidador.dataValidadadeValidador(dataValidade);
      this.dataValidade = dataValidade;
  }
  
  public int getQuantidade(){
    return this.quantidade;
  }
  
  public void setQuantidade(int quantidade){

      LoteValidador.quantidadeValidador(quantidade);
      this.quantidade = quantidade;
    }
  
  public BigDecimal getCustoUnitario(){
      
      return this.custoUnitario;
  }
  
  public void setCustoUnitario(BigDecimal custoUnitario){

      LoteValidador.custoUnitarioValidador(custoUnitario);
      this.custoUnitario = custoUnitario;

  }

}  
  
