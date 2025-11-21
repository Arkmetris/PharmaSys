package model;

import java.lang.Math;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Lote {
    
  private long idLote;               
  private String skuMedicamento;      
  private String numeroLote;         
  private LocalDate dataValidade;    
  private int quantidade;            
  private BigDecimal custoUnitario;
    
  
  public Lote(){
      
  }
  
  public long getIdLote(){
    return this.idLote;
  }
  
  public void setIdLote(long idLote){
      
      if(idLote <= 0){
         throw new IllegalArgumentException("\nError: O ID do lote deve ser sempre positivo e maior que zero!");
      }
      
    this.idLote = idLote;
  }
  
  public String getSkuMedicamento(){
    return this.skuMedicamento;
  }
  
  public void setSkuMedicamento(String skuMedicamento){
    
      if(skuMedicamento == null || skuMedicamento.trim().isEmpty() == true){
        throw new IllegalArgumentException("\nError: Em seu lote, o sku do seu medicamento não pode ser vazio e nem nulo!");
      }
      
      skuMedicamento = skuMedicamento.trim();
      
      this.skuMedicamento = skuMedicamento;
  }
  
  public String getNumeroLote(){
    return this.numeroLote;
  }
  
  public void setNumeroLote(String numeroLote){
      
      if(numeroLote == null || numeroLote.trim().isEmpty() == true){
         throw new IllegalArgumentException("\nError: Não pode ser vazio ou nulo!");
      }
      
      numeroLote = numeroLote.trim();
      
      this.numeroLote = numeroLote;
  }
  
  public LocalDate getDataValidade(){
     return this.dataValidade;
  }
  
  public void setDataValidade(LocalDate dataValidade){
      
      if(dataValidade == null){
         throw new IllegalArgumentException("A data de validade não pode ser nula!");
      }
      else if(dataValidade.isBefore(LocalDate.now())){
         throw new IllegalArgumentException("Error: Não tem como o produto já estar vencido!");
      }
      
     this.dataValidade = dataValidade;
  }
  
  public int getQuantidade(){
    return this.quantidade;
  }
  
  public void setQuantidade(int quantidade){
      
     if (quantidade < 0){
        throw new IllegalArgumentException("Atenção: não pode ser negativo!");
     } 
      
     this.quantidade = quantidade;
    }
  
  public BigDecimal getCustoUnitario(){
      
      return this.custoUnitario;
  }
  
  public void setCustoUnitario(BigDecimal custoUnitario){
      
      if(custoUnitario == null){
         throw new IllegalArgumentException("\nError:Não pode ser nulo!");
      }
      
      else if (custoUnitario.compareTo(BigDecimal.ZERO)== 0){
          throw new IllegalArgumentException("Error: Não pode ser zero!");
      }
      else if (custoUnitario.compareTo(BigDecimal.ZERO) < 0) {
           throw new IllegalArgumentException("Error: Não pode ser negativo!");
      }
      else {
          this.custoUnitario = custoUnitario;
      }
  }

}  
  
