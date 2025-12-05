package br.univ.pharmasys.model;

import java.math.BigDecimal;
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
    private BigDecimal preco;
    private boolean inativo;

    public Medicamento() {
    }

    // Objetivo aqui é fazer um "escopo" para o projeto de LPOO

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        MedicamentoValidador.skuValidar(sku);
        this.sku = sku.trim();
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        MedicamentoValidador.codigoBarrasValidar(codigoBarras);
        this.codigoBarras = codigoBarras.trim();
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        MedicamentoValidador.nomeValidar(nomeComercial);
        this.nomeComercial = nomeComercial.trim();
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        MedicamentoValidador.principioAtivoValidar(principioAtivo);
        this.principioAtivo = principioAtivo.trim();
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        MedicamentoValidador.dosagemValidar(dosagem);
        this.dosagem = dosagem.trim();
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        MedicamentoValidador.formaFarmaceuticaValidar(formaFarmaceutica);
        this.formaFarmaceutica = formaFarmaceutica.trim();
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        MedicamentoValidador.laboratorioValidar(laboratorio);
        this.laboratorio = laboratorio.trim();
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
}