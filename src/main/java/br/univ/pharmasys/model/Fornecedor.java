package br.univ.pharmasys.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gabri
 */
public class Fornecedor {
    
    private long idFornecedor;
    private String nome;
    private String cnpj;
    private boolean inativo;
    
    public Fornecedor(){
       
    }
    
    public long getIdFornecedor(){
         
        return this.idFornecedor;
    
    }
    
    public void setIdFornecedor(long idFornecedor){
         
        if(idFornecedor <=0){
           throw new IllegalArgumentException("\nError: O ID de um fornecedor deve ser sempre positiva e maior que zero");
        }
        
        this.idFornecedor = idFornecedor;
    }
    
    public String getNome(){
        
        return this.nome;
        
    }
    
    public void setNome (String nome){
        
        if(nome == null || nome.trim().isEmpty() == true){
        
            throw new IllegalArgumentException("\nError: inválido ou vazio!");
        }
        
        nome = nome.trim();
        
        this.nome = nome;
            
    }
    
    public String getCnpj (){
    
          return this.cnpj;   
    }
    
    public void setCnpj(String cnpj){
        
        //Validar o cnpj do fornecedor!
        
        if (cnpj == null || cnpj.trim().isEmpty() == true){
            throw new IllegalArgumentException("Error: Não pode ser nulo ou vazio!");
        }
        
          cnpj = cnpj.replaceAll("\\D", "");
        
        if (cnpj.length() != 14){
            throw new IllegalArgumentException("Error: Todo CNPJ deve conter 14 dígitos!");
        }
        
        this.cnpj = cnpj;
    }
    
    public boolean isInativo(){
          
        return this.inativo;
    }
    
    public void setInativo(boolean inativo){
            
        this.inativo = inativo;
    }
    
}
