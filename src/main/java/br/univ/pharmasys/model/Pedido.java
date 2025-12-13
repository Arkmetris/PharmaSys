package br.univ.pharmasys.model;

import java.time.LocalDate;
import br.univ.pharmasys.exceptions.QuantidadeInvalidaException;

public class Pedido {
	private long id_pedido;
	private int quantidade;
	private Status status;
	private LocalDate data;
	private double preco_unitario;
	private double valor_total;


public  long getIdPedido() {
return id_pedido;
}

public int getquantidade() {
return quantidade;
}
public void setQuantidade(int quantidade) {
if(quantidade <=0){
  throw new QuantidadeInvalidaException("Preencha uma quantidade válida");}
this.quantidade = quantidade;
calcularValorTotal();
}

public Status getStatus() {
return status;
}public void setStatus(Status status) {
    this.status = status;
}

public LocalDate getData() {
  return data;
 }public void setData(LocalDate data) {
    this.data = data;
}

public double getPrecoUnitario() {
	return preco_unitario;
}public void setPrecoUnitario(double preco_unitario) {
    this.preco_unitario = preco_unitario;
    calcularValorTotal();
}

public double getValorTotal() {
	  return valor_total;
}
private void calcularValorTotal() {
    if (quantidade > 0 && preco_unitario >0) {
    	this.valor_total = this.quantidade * this.preco_unitario;}}
}
