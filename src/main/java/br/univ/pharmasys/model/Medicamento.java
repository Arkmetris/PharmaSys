package br.univ.pharmasys.model;

import java.time.LocalDate;
import java.util.Objects;

public class Medicamento {

    private String sku;
    private String codigoBarras;
    private String nomeComercial;
    private String formaFarmaceutica;
    private String dosagem;
    private String fabricante;
    private LocalDate dataExpiracao;
    private String laboratorio;
    private int estoqueMin;
    private int estoqueMax;
    private Integer loteId; // Nullable, corresponde a LOTE_ID na tabela

    public Medicamento() {
    }

    // ---------- Getters & Setters com validações ----------

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        if (sku == null) {
            throw new IllegalArgumentException("ERROR: É obrigatório todo medicamento ter um sku!");
        }
        sku = sku.trim();
        if (sku.isEmpty()) {
            throw new IllegalArgumentException("ERROR: O seu sku está vazio!");
        }
        this.sku = sku;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        if (codigoBarras == null || codigoBarras.trim().isEmpty()) {
            throw new IllegalArgumentException("Atenção: o seu código de barras não pode ser vazio ou nulo");
        }
        this.codigoBarras = codigoBarras.trim();
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        if (nomeComercial == null) {
            throw new IllegalArgumentException("ERROR: É obrigatório todo medicamento ter um nome!");
        }
        nomeComercial = nomeComercial.trim();
        if (nomeComercial.isEmpty()) {
            throw new IllegalArgumentException("ERROR: Remédio não encontrado ou não existe!!");
        }
        this.nomeComercial = nomeComercial;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        if (formaFarmaceutica == null || formaFarmaceutica.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: a forma farmacêutica está vazia ou nula");
        }
        this.formaFarmaceutica = formaFarmaceutica.trim();
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        if (dosagem == null) {
            throw new IllegalArgumentException("Error: A dosagem do medicamento não pode estar vazia!");
        }
        dosagem = dosagem.trim();
        if (dosagem.isEmpty()) {
            throw new IllegalArgumentException("Error: A dosagem foi escrita de uma forma errada, ou está vazia");
        }
        this.dosagem = dosagem;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        if (fabricante == null || fabricante.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Fabricante não pode ser vazio ou nulo");
        }
        this.fabricante = fabricante.trim();
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        if (dataExpiracao == null) {
            throw new IllegalArgumentException("Error: A data de validade não pode ser vazia!");
        } else if (dataExpiracao.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Error: O produto deve ter validade futura!");
        }
        this.dataExpiracao = dataExpiracao;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        if (laboratorio == null || laboratorio.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Laboratório não pode ser vazio ou nulo");
        }
        this.laboratorio = laboratorio.trim();
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(int estoqueMin) {
        if (estoqueMin < 0) {
            throw new IllegalArgumentException("Error: O estoque mínimo não pode ser menor que zero!");
        }
        if (this.estoqueMax > 0 && estoqueMin > this.estoqueMax) {
            throw new IllegalArgumentException("Error: Estoque mínimo não pode ser maior que o máximo");
        }
        this.estoqueMin = estoqueMin;
    }

    public int getEstoqueMax() {
        return estoqueMax;
    }

    public void setEstoqueMax(int estoqueMax) {
        if (estoqueMax <= 0) {
            throw new IllegalArgumentException("Error: o estoque máximo não pode ser negativo ou igual a 0!");
        }
        if (this.estoqueMin > 0 && this.estoqueMin > estoqueMax) {
            throw new IllegalArgumentException("Error: o estoque mínimo não pode ser maior que o máximo!");
        }
        this.estoqueMax = estoqueMax;
    }

    public Integer getLoteId() {
        return loteId;
    }

    public void setLoteId(Integer loteId) {
        // loteId pode ser null (campo opcional na tabela)
        this.loteId = loteId;
    }

    // ---------- equals/hashCode/toString (úteis em coleções e logs) ----------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicamento)) return false;
        Medicamento that = (Medicamento) o;
        return Objects.equals(sku, that.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "sku='" + sku + '\'' +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", nomeComercial='" + nomeComercial + '\'' +
                ", formaFarmaceutica='" + formaFarmaceutica + '\'' +
                ", dosagem='" + dosagem + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", dataExpiracao=" + dataExpiracao +
                ", laboratorio='" + laboratorio + '\'' +
                ", estoqueMin=" + estoqueMin +
                ", estoqueMax=" + estoqueMax +
                ", loteId=" + loteId +
                '}';
    }
}
