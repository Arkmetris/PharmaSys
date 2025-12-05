package br.univ.pharmasys.model;

import br.univ.pharmasys.service.FornecedorValidador;

public class Fornecedor {
    
    private long idFornecedor;
    private String nome;
    private String cnpj;
    private boolean inativo;
    
    public Fornecedor(long idFornecedor, String nome, String cnpj, boolean inativo) {

        FornecedorValidador.idFornecedorValidar(idFornecedor);
        FornecedorValidador.nomeValidar(nome);
        FornecedorValidador.cnpjValidar(cnpj);


        this.idFornecedor = idFornecedor;
        this.nome = nome.trim();
        this.cnpj = cnpj.replaceAll("\\D", "");
        this.inativo = inativo;
       
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
        this.nome = nome.trim();
            
    }
    
    public String getCnpj (){
    
          return this.cnpj;   
    }
    
    public void setCnpj(String cnpj){
        
        //Validar o cnpj do fornecedor!

        FornecedorValidador.cnpjValidar(cnpj);
        this.cnpj = cnpj.replaceAll("\\D ","");
    }
    
    public boolean isInativo(){
          
        return this.inativo;
    }
    
    public void setInativo(boolean inativo){
            
        this.inativo = inativo;
    }
    
}
