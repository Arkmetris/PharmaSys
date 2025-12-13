package br.univ.pharmasys.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.univ.pharmasys.service.MedicamentoValidador;

public class Medicamento {

    private String sku;
    private String codigoBarras;
    private String nomeComercial;
    private String Fabricante;// Trocado por fabricante para não ter erro na tabela sql 
    private String dosagem;
    private String formaFarmaceutica;
    private String laboratorio;
    private LocalDate dataExpiracao;
    private int estoqueMin;
    private int estoqueMax;
    private int estoqueAtual;
    private BigDecimal preco;
    private boolean inativo;
    private long loteId;

    public Medicamento() {
    }

    //Classe Medicamento onde vai pegar os valores e recebera validações

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        sku = sku.trim();
        MedicamentoValidador.skuValidar(sku);
        this.sku = sku;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        codigoBarras = codigoBarras.trim();
        MedicamentoValidador.codigoBarrasValidar(codigoBarras);
        this.codigoBarras = codigoBarras;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {

        nomeComercial = nomeComercial.trim();
        MedicamentoValidador.nomeValidar(nomeComercial);
        this.nomeComercial = nomeComercial;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {

        Fabricante = Fabricante.trim();
        MedicamentoValidador.fabricanteValidar(Fabricante);
        this.Fabricante = Fabricante;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        dosagem = dosagem.trim();
        MedicamentoValidador.dosagemValidar(dosagem);
        this.dosagem = dosagem;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {

        formaFarmaceutica = formaFarmaceutica.trim();
        MedicamentoValidador.formaFarmaceuticaValidar(formaFarmaceutica);
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        laboratorio = laboratorio.trim();
        MedicamentoValidador.laboratorioValidar(laboratorio);
        this.laboratorio = laboratorio;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        MedicamentoValidador.dataExpiracaoValidar(dataExpiracao);
        this.dataExpiracao = dataExpiracao;
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(int estoqueMin) {
        // Cuidado: Certifique-se que o validador lida bem se estoqueMax for 0
        MedicamentoValidador.estoqueMinValidar(estoqueMin, estoqueMax);
        this.estoqueMin = estoqueMin;
    }

    public int getEstoqueMax() {
        return estoqueMax;
    }

    public void setEstoqueMax(int estoqueMax) {
        MedicamentoValidador.estoqueMaxValidar(estoqueMax, estoqueMin);
        this.estoqueMax = estoqueMax;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(int estoqueAtual) {
        MedicamentoValidador.estoqueAtualValidar(estoqueAtual, estoqueMin, estoqueMax);
        this.estoqueAtual = estoqueAtual;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public void setPreco(BigDecimal preco) {
        MedicamentoValidador.precoValido(preco);
        this.preco = preco;
    }


    public long getLoteId() {
        return loteId;
    }

    public void setLoteId(long loteId) {

        MedicamentoValidador.idLoteValidar(loteId);
        this.loteId = loteId;
    }

}
