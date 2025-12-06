package br.univ.pharmasys.model;

import br.univ.pharmasys.service.FornecedorValidador;

public class Fornecedor {
    
    private long idFornecedor;
    private String nome;
    private String cnpj;
    private boolean inativo;
    
    public Fornecedor() {

    }
    
    public long getIdFornecedor(){
         
        return this.idFornecedor;
    
    }
    
    public void setIdFornecedor(long idFornecedor){

        FornecedorValidador.idFornecedorValidar(idFornecedor);
        this.idFornecedor = idFornecedor;
    }
    
    public String getNome(){
        
        return this.nome;
        
    }
    
    public void setNome (String nome){

        FornecedorValidador.nomeValidar(nome);
        nome = nome.trim();
        this.nome = nome;
            
    }
    
    public String getCnpj (){
    
          return this.cnpj;   
    }
    
    public void setCnpj(String cnpj){
        
        //Validar o cnpj do fornecedor!

        FornecedorValidador.cnpjValidar(cnpj);
        cnpj= cnpj.replaceAll("\\D ", "");
        this.cnpj = cnpj;
    }
    
    public boolean isInativo(){
          
        return this.inativo;
    }
    
    public void setInativo(boolean inativo){
            
        this.inativo = inativo;
    }
    
}
