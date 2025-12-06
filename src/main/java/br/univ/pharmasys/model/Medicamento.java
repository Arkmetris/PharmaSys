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
 AceitaMatheus
        sku = sku.trim();

        sku=sku.trim();
 main
        MedicamentoValidador.skuValidar(sku);
        this.sku = sku;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
 AceitaMatheus
        codigoBarras = codigoBarras.trim();

        codigoBarras=codigoBarras.trim();
 main
        MedicamentoValidador.codigoBarrasValidar(codigoBarras);
        this.codigoBarras = codigoBarras;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
 AceitaMatheus
        nomeComercial = nomeComercial.trim();

        nomeComercial=nomeComercial.trim();
 main
        MedicamentoValidador.nomeValidar(nomeComercial);
        this.nomeComercial = nomeComercial;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
 AceitaMatheus
        principioAtivo = principioAtivo.trim();

        principioAtivo=principioAtivo.trim();
 main
        MedicamentoValidador.principioAtivoValidar(principioAtivo);
        this.principioAtivo = principioAtivo;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
 AceitaMatheus
        dosagem = dosagem.trim();

        dosagem =  dosagem.trim();
 main
        MedicamentoValidador.dosagemValidar(dosagem);
        this.dosagem = dosagem;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
 AceitaMatheus
        formaFarmaceutica = formaFarmaceutica.trim();

        formaFarmaceutica =  formaFarmaceutica.trim();
 main
        MedicamentoValidador.formaFarmaceuticaValidar(formaFarmaceutica);
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
 AceitaMatheus
        laboratorio = laboratorio.trim();

        laboratorio =  laboratorio.trim();
 main
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
}