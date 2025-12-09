package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MedicamentoValidador {

    // Contém validações de campos do Medicamento
    // Todos os atributos são verificados antes de salvar/atualizar

    public static void skuValidar(String sku) {
        if (sku == null || sku.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O campo SKU não pode estar vazio.");
        }

        sku = sku.trim();
        if (!sku.matches("\\S+")) {
            throw new ErroDePreenchimentoInvalidoException("O SKU não pode conter espaços.");
        }
    }

    public static void codigoBarrasValidar(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O código de barras deve ser preenchido.");
        }

        codigo = codigo.trim();

        if (codigo.length() != 13) {
            throw new ErroDePreenchimentoInvalidoException("O código de barras deve ter exatamente 13 caracteres.");
        }

        if (!codigo.matches("\\S+")) {
            throw new ErroDePreenchimentoInvalidoException("O código de barras não pode conter espaços.");
        }
    }

    public static void nomeValidar(String nome) {
        if (nome == null) {
            throw new NomeInvalidoException("O nome do medicamento é obrigatório.");
        }

        nome = nome.trim();

        if (nome.isEmpty()) {
            throw new NomeInvalidoException("O nome do medicamento não pode estar vazio.");
        }

        if (!nome.matches("\\S+")) {
            throw new NomeInvalidoException("O nome do medicamento não pode conter espaços.");
        }
    }

    public static void fabricanteValidar(String fabricante) {
        if (fabricante == null || fabricante.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O fabricante não pode estar vazio.");
        }

        fabricante = fabricante.trim();

        if (!fabricante.matches("\\S+")) {
            throw new ErroDePreenchimentoInvalidoException("O fabricante não pode conter espaços.");
        }
    }

    public static void dosagemValidar(String dose) {
        if (dose == null || dose.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("A dosagem não pode estar vazia.");
        }

        dose = dose.trim();

        if (!dose.matches("\\S+")) {
            throw new ErroDePreenchimentoInvalidoException("A dosagem não pode conter espaços.");
        }
    }

    public static void formaFarmaceuticaValidar(String forma) {
        if (forma == null || forma.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("A forma farmacêutica não pode estar vazia.");
        }

        forma = forma.trim();

        if (!forma.matches("\\S+")) {
            throw new ErroDePreenchimentoInvalidoException("A forma farmacêutica não pode conter espaços.");
        }
    }

    public static void laboratorioValidar(String laboratorio) {
        if (laboratorio == null || laboratorio.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O laboratório não pode estar vazio.");
        }

        laboratorio = laboratorio.trim();

        if (!laboratorio.matches("\\S+")) {
            throw new ErroDePreenchimentoInvalidoException("O laboratório não pode conter espaços.");
        }
    }

    public static void dataExpiracaoValidar(LocalDate data) {
        if (data == null) {
            throw new DataInvalidoException("A data de validade não pode ser nula.");
        }

        if (data.isBefore(LocalDate.now())) {
            throw new DataInvalidoException("A data de validade deve ser futura.");
        }
    }

    public static void estoqueMinValidar(int minimo, int maximoAtual) {
        if (minimo < 0) {
            throw new EstoqueMinInvalidoException("O estoque mínimo não pode ser negativo.");
        }

        if (minimo > maximoAtual) {
            throw new EstoqueMinInvalidoException("O estoque mínimo não pode ser maior que o estoque máximo.");
        }
    }

    public static void estoqueMaxValidar(int maximo, int minimoAtual) {
        if (maximo <= 0) {
            throw new EstoqueMaxInvalidoException("O estoque máximo deve ser maior que zero.");
        }

        if (minimoAtual > maximo) {
            throw new EstoqueMaxInvalidoException("O estoque mínimo não pode ser maior que o máximo.");
        }
    }

    public static String estoqueAtualValidar(int atual, int minimo, int maximo) {
        if (atual < 0) {
            throw new ErroDePreenchimentoInvalidoException("O estoque atual não pode ser negativo.");
        }

        if (atual <= minimo) {
            return "Estoque baixo.";
        }

        if (atual >= maximo) {
            return "Estoque cheio.";
        }

        return "Estoque atual: " + atual;
    }

    public static void precoValido(BigDecimal preco) {
        if (preco == null) {
            throw new CustoUnitarioInvalidoException("O preço não pode ser nulo.");
        }

        if (preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new CustoUnitarioInvalidoException("O preço deve ser maior que zero.");
        }
    }
}
