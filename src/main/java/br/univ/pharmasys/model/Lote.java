package br.univ.pharmasys.model;

import java.time.LocalDate;
import java.math.BigDecimal;

import br.univ.pharmasys.service.LoteValidador;

public class Lote {
    
	private long idLote;
	private String skuMedicamento;
	private LocalDate validade;
    private String numeroLote;
	private int quantidadeRecebida;
	private int quantidadeAtual;
	private BigDecimal preco;
//mudei as class para ficar igual ao banco  de dados, agora falta mudar o codigo e agrecentar em vez de  quantidade usar quantidade recebida e qunatitade atual

  public Lote() {


  }

  //Criação da classe Lote (models) possuindo validações

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
  

  
  public LocalDate getValidade(){
     return this.validade;
  }
  
  public void setValidade(LocalDate validade){

      LoteValidador.dataValidadadeValidador(validade);
      this.validade = validade;
  }

    public String getNumeroLote(){
        return this.numeroLote;
    }

    public void setNumeroLote(String numeroLote){

        numeroLote = numeroLote.trim();
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
  
