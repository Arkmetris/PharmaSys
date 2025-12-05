package br.univ.pharmasys.model;


import java.time.LocalDate;
import br.univ.pharmasys.service.MedicamentoValidador;


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
    private int estoqueAtual;
    private boolean inativo;


    public Medicamento(String sku, String codigoBarras, String nomeComercial, String principioAtivo, String dosagem, String formaFarmaceutica,
                       String laboratorio, LocalDate dataExpiracao, int estoqueMin, int estoqueMax, int estoqueAtual, boolean inativo) {


               MedicamentoValidador.skuValidar(sku);
               MedicamentoValidador.codigoBarrasValidar(codigoBarras);
               MedicamentoValidador.nomeValidar(nomeComercial);
               MedicamentoValidador.principioAtivoValidar(principioAtivo);
               MedicamentoValidador.dosagemValidar(dosagem);
               MedicamentoValidador.formaFarmaceuticaValidar(formaFarmaceutica);
               MedicamentoValidador.laboratorioValidar(laboratorio);
               MedicamentoValidador.dataExpiracaoValidar(dataExpiracao);
               MedicamentoValidador.estoqueMinValidar(estoqueMin, estoqueMax);
               MedicamentoValidador.estoqueMaxValidar(estoqueMax, estoqueMin);
               MedicamentoValidador.estoqueAtualValidar(estoqueAtual, estoqueMin, estoqueMax);

               this.sku = sku;
               this.codigoBarras = codigoBarras;
               this.nomeComercial = nomeComercial;
               this.principioAtivo = principioAtivo;
               this.dosagem = dosagem;
               this.formaFarmaceutica = formaFarmaceutica;
               this.laboratorio = laboratorio;
               this.dataExpiracao = dataExpiracao;
               this.estoqueMin = estoqueMin;
               this.estoqueMax = estoqueMax;
               this.estoqueAtual = estoqueAtual;
               this.inativo = inativo;


    }
    
    //Objetivo aqui é fazer um ""escopo"" para o projeto de LPOO
    //Muito provavelmente não terá todas as funcionalidades, e provavelmente terá que ser corrigido logo depois!
    
    public String getSku(){
        return sku;
    }
    
    public void setSku (String sku){

        MedicamentoValidador.skuValidar(sku);
        this.sku = sku.trim();
    }
    
    public String getCodigoBarras(){
        return codigoBarras;
    }
    
    public void setCodigoBarras (String codigoBarras){

        MedicamentoValidador.codigoBarrasValidar(codigoBarras);
        codigoBarras = codigoBarras.trim();
        this.codigoBarras = codigoBarras;
    }
    
    public String getNomeComercial(){
        return nomeComercial;
    }
    
    public void setNomeComercial (String nomeComercial){
        
        //Verificar o nome do medicamento e ver se ele foi corretamente digitado
        MedicamentoValidador.nomeValidar(nomeComercial);
        this.nomeComercial = nomeComercial.trim();
    }
    
    public String getPrincipioAtivo(){
        return principioAtivo;
    }
    
    public void setPrincipioAtivo (String principioAtivo){

        MedicamentoValidador.principioAtivoValidar(principioAtivo);
        principioAtivo = principioAtivo.trim();
        this.principioAtivo = principioAtivo;
    }
    
    public String getDosagem(){
        return dosagem;
    }
    
    public void setDosagem (String dosagem){

        MedicamentoValidador.dosagemValidar(dosagem);
        dosagem = dosagem.trim();
        this.dosagem = dosagem;

    }
    
    public String getFormaFarmaceutica(){
        return formaFarmaceutica;
    }
    
    public void setFormaFarmaceutica(String forma){

        MedicamentoValidador.formaFarmaceuticaValidar(formaFarmaceutica);
        formaFarmaceutica = forma.trim();
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getLaboratorio(){
        return laboratorio;
    }


    //Validar se o que será escrito na parte de laboratório

    public void setLaboratorio(String laboratorio){

        MedicamentoValidador.laboratorioValidar(laboratorio);
        laboratorio = laboratorio.trim();
        this.laboratorio = laboratorio;
    }

    public LocalDate getDataExpiracao(){
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao){

        //Forma de validar a data de expiração de um medicamento
        //Provavelmente vai sofrer certas alterações futuramente

        MedicamentoValidador.dataExpiracaoValidar(dataExpiracao);
        this.dataExpiracao = dataExpiracao;
    }

    public int getEstoqueMin(){
        return estoqueMin;
    }
    
    public void setEstoqueMin(int estoqueMin){

        MedicamentoValidador.estoqueMinValidar(estoqueMin, estoqueMax);
        this.estoqueMin = estoqueMin;

    }
    
    public int getEstoqueMax(){
        return estoqueMax;
    }
    
    public void setEstoqueMax(int estoqueMax){

        MedicamentoValidador.estoqueMaxValidar(estoqueMax, estoqueMin);
        this.estoqueMax = estoqueMax;
    }
    
    public boolean isInativo(){

        return inativo;
    }
    
    public void setInativo(boolean inativo){

        this.inativo = inativo;
    }

    public int  getEstoqueAtual(){
        return estoqueAtual;
    }

    public void setEstoqueAtual(int estoqueAtual){
        
        //Analisar a situação atual do estoque

        MedicamentoValidador.estoqueAtualValidar(estoqueAtual, estoqueMin, estoqueMax);
        this.estoqueAtual = estoqueAtual;
    }
}

   
    
  
