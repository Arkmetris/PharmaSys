package br.univ.pharmasys.model;


import java.time.LocalDate;

public class Medicamento {
    
    private String sku;
    private String codigoBarras;
    private String nomeComercial;
    private String principioAtivo;
    private String dosagem;
    private String formaFarmaceutica;
    private String laboratorio;
    private LocalDate dataExpiracao;
    private int estoqueMin;
    private int estoqueMax;
    private boolean inativo;


    public Medicamento(){
        
    }
    
    //Objetivo aqui é fazer um ""escopo"" para o projeto de LPOO
    //Muito provavelmente não terá todas as funcionalidades, e provavelmente terá que ser corrigido logo depois!
    
    public String getSku(){
        return sku;
    }
    
    public void setSku (String sku){
         if (sku == null) {
           throw new IllegalArgumentException("\nERROR: É obrigatório todo medicamento ter um sku!");  
        }
        
        sku = sku.trim();
        
        if ( sku.isEmpty()){
           throw new IllegalArgumentException("\nO seu sku está vazio!");
        }
        else {
            this.sku = sku;
        }
    }
    
    public String getCodigoBarras(){
        return codigoBarras;
    }
    
    public void setCodigoBarras (String codigoBarras){
        if(codigoBarras == null || codigoBarras.trim().isEmpty()) {
             throw new IllegalArgumentException("Atenção: o seu código de barras não pode ser vazio ou nulo");        
        }
        
        this.codigoBarras = codigoBarras;
    }
    
    public String getNomeComercial(){
        return nomeComercial;
    }
    
    public void setNomeComercial (String nomeComercial){
        
        //Verificar o nome do medicamento e ver se ele foi corretamente digitado
        
        if (nomeComercial == null) {
           throw new IllegalArgumentException("\nERROR: É obrigatório todo medicamento ter um nome!");
        }
        
        nomeComercial = nomeComercial.trim();
       
        if (nomeComercial.isEmpty()){
            throw new IllegalArgumentException("\nERROR: Remédio não encontrado ou não existe!!");
        }
        else{          
            this.nomeComercial = nomeComercial;
        }
    }
    
    public String getPrincipioAtivo(){
        return principioAtivo;
    }
    
    public void setPrincipioAtivo (String principioAtivo){
        
        if(principioAtivo == null || principioAtivo.trim().isEmpty()){
           throw new IllegalArgumentException("\nEstá inválido ou vazio!");
        }
        
        this.principioAtivo = principioAtivo;
    }
    
    public String getDosagem(){
        return dosagem;
    }
    
    public void setDosagem (String dosagem){
        
        if(dosagem == null){
           throw new IllegalArgumentException("\nError: A dosagem do medicamento não pode estar vazia!");
        }
        
        dosagem = dosagem.trim();
         
        if(dosagem.isEmpty()){
          throw new IllegalArgumentException("\nError: A dosagem foi escrita de uma forma errada, ou está vazia");  
        }
        else {
              this.dosagem = dosagem;       
        }
    }
    
    public String getForma(){
        return formaFarmaceutica;
    }
    
    public void setForma(String forma){
        if(forma == null || forma.trim().isEmpty()){
            throw new IllegalArgumentException("\nError: a forma está vazia ou nula");
        }
        
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getLaboratorio(){
        return laboratorio;
    }


    //Validar se o que será escrito na parte de laboratório

    public void setLaboratorio(String laboratorio){

        if(laboratorio == null || laboratorio.trim().isEmpty()){
            throw new IllegalArgumentException("\nError: Está vazia ou nula");
        }

        this.laboratorio = laboratorio;
    }

    public LocalDate getDataExpiracao(){
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao){

        //Forma de validar a data de expiração de um medicamento
        //Provavelmente vai sofrer certas alterações futuramente

        if(dataExpiracao == null){
            throw new IllegalArgumentException("Error: A data de validade não pode ser vazia!");
        }
        else if(dataExpiracao.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Error:O produto deve ter validade futura!");
        }

        this.dataExpiracao = dataExpiracao;
    }

    public int getEstoqueMin(){
        return estoqueMin;
    }
    
    public void setEstoqueMin(int estoqueMin){

        if (estoqueMin < 0) {
           throw new IllegalArgumentException("\nError:O estoque não pode ser menor que zero!");
        }
        else if (estoqueMax > 0 && estoqueMin > estoqueMax){
            
         throw new IllegalArgumentException("\nError: Estoque mínimo não pode ser maior que o máximo");
          
        }
        else{
            this.estoqueMin = estoqueMin;
      }
 }
    
    public int getEstoqueMax(){
        return estoqueMax;
    }
    
    public void setEstoqueMax(int estoqueMax){
        
        if (estoqueMax <= 0){
            throw new IllegalArgumentException("\nError: o estoque máximo não pode ser negativo ou igual a 0!");
        }
        else if ( estoqueMin > 0 && estoqueMin>estoqueMax) {
            throw new IllegalArgumentException("\nError: o estoque mínimo não pode ser maior que o máximo!");
        }
        else {
             this.estoqueMax = estoqueMax;
        }
    }
    
    public boolean isInativo(){
        return inativo;
    }
    
    public void setInativo(boolean inativo){
        this.inativo = inativo;
    }
    
    public String analisarEstoque(int estoqueAtual){
        
        //Analisar a situação atual do estoque
        
        if(estoqueAtual < 0){
           throw new IllegalArgumentException("\nError:Não pode existir um estoque negativo!");
        }
        else if (estoqueAtual <= estoqueMin) {
           return ("\nAtenção: Estoque vazio, o mínimo que deveria se ter no seu estoque é: " + estoqueMin);
        }
        else if (estoqueAtual >= estoqueMax){
            
            return("\nAtenção Estoque cheio, o máximo que o seu estoque aguenta é: " + estoqueMax);
        }
        else {
            return("\nSeu estoque atual é: " + estoqueAtual);
        }
    }
}

   
    
  
