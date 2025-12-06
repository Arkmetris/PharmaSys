package br.univ.pharmasys.model;

import java.time.LocalDate;
import java.math.BigDecimal;

import br.univ.pharmasys.service.LoteValidador;

public class Lote {
    
	private long idLote;
	private String skuMedicamento;
	private int numeroLote;   
	private LocalDate validade;
	private int quantidadeRecebida;
	private int quantidadeAtual;
	private BigDecimal preco;
//mudei as class para ficar igual ao banco  de dados, agora falta mudar o codigo e agrecentar em vez de  quantidade usar quantidade recebida e qunatitade atual

  public Lote() {


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

      skuMedicamento = skuMedicamento.trim();
      LoteValidador.skuMedicamentoValidar(skuMedicamento);
      this.skuMedicamento = skuMedicamento;
  }
  
  public String getNumeroLote(){
    return this.numeroLote;
  }
  
  public void setNumeroLote(String numeroLote){

      numeroLote = numeroLote.trim();
      LoteValidador.numeroLoteValidador(numeroLote);
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
  
