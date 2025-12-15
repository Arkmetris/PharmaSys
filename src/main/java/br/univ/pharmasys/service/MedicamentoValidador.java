package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MedicamentoValidador {

    // Contém validações de campos do Medicamento
    // Todos os atributos são verificados antes de salvar/atualizar

    public static void skuValidador(String sku) {
        if (sku == null || sku.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O campo SKU não pode estar vazio.");
        }

        sku = sku.trim();
        if (!sku.matches("[A-Z0-9\\-]+")) {
            throw new ErroDePreenchimentoInvalidoException("O SKU deve conter apenas letras maiúsculas, dígitos e hífen.");
        }
    }

    public static void codigoBarrasValidador(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O código de barras deve ser preenchido.");
        }

        codigo = codigo.trim();

        if (!codigo.matches("\\d{13}")) {
            throw new ErroDePreenchimentoInvalidoException("O código de barras deve conter exatamente 13 dígitos (somente números).");
        }
    }

    public static void nomeValidador(String nome) {
        if (nome == null) {
            throw new NomeInvalidoException("O nome do medicamento é obrigatório.");
        }

        nome = nome.trim();

        if (nome.isEmpty()) {
            throw new NomeInvalidoException("O nome do medicamento não pode estar vazio.");
        }

        if (!nome.matches("[\\p{L} ]+")) {
            throw new NomeInvalidoException("O nome do medicamento não pode conter números ou símbolos.");
        }
    }

    public static void fabricanteValidador(String fabricante) {
        if (fabricante == null || fabricante.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O fabricante não pode estar vazio.");
        }

        fabricante = fabricante.trim();
        if (!fabricante.matches("[\\p{L}\\p{N} .()\\-]+")) {
            throw new ErroDePreenchimentoInvalidoException("O fabricante contém caracteres inválidos.");
        }
    }

    public static void dosagemValidador(String dose) {
        if (dose == null || dose.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("A dosagem não pode estar vazia.");
        }

        dose = dose.trim();
        if (!dose.matches("[\\p{L}\\p{N} %/.,()\\-]+")) {
            throw new ErroDePreenchimentoInvalidoException("A dosagem contém caracteres inválidos.");
        }
    }

    public static void formaFarmaceuticaValidador(String forma) {
        if (forma == null || forma.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("A forma farmacêutica não pode estar vazia.");
        }

        forma = forma.trim();
        // Permite nomes como "comprimido revestido" (letras e espaços)
        if (!forma.matches("[\\p{L} ]+")) {
            throw new ErroDePreenchimentoInvalidoException("A forma farmacêutica contém caracteres inválidos.");
        }
    }

    public static void laboratorioValidador(String laboratorio) {
        if (laboratorio == null || laboratorio.trim().isEmpty()) {
            throw new ErroDePreenchimentoInvalidoException("O laboratório não pode estar vazio.");
        }

        laboratorio = laboratorio.trim();

        //Vai permitir caracteres especiais, letras, numeros e acentos...
        if (!laboratorio.matches("[\\p{L}\\p{N} .()\\-]+")) {
            throw new ErroDePreenchimentoInvalidoException("O laboratório contém caracteres inválidos.");
        }
    }

    public static void dataExpiracaoValidador(LocalDate data) {
        if (data == null) {
            throw new DataInvalidoException("A data de validade não pode ser nula.");
        }

        if (data.isBefore(LocalDate.now())) {
            throw new DataInvalidoException("A data de validade deve ser futura.");
        }
    }

    public static void estoqueMinValidador(int min, int max) {
        if (min < 0) {
            throw new EstoqueInvalidoException("O estoque mínimo não pode ser negativo.");
        }

        if (max > 0 && min > max) {
            throw new EstoqueInvalidoException("O estoque mínimo não pode ser maior que o estoque máximo.");
        }
    }

    public static void estoqueMaxValidador(int max, int min) {
        if (max <= 0) {
            throw new EstoqueInvalidoException("O estoque máximo deve ser maior que zero.");
        }

        if (min > 0 && min > max) {
            throw new EstoqueInvalidoException("O estoque mínimo não pode ser maior que o máximo.");
        }
    }

    public static String estoqueAtualValidador(int atual, int min, int max) {
        if (atual < 0) {
            throw new ErroDePreenchimentoInvalidoException("O estoque atual não pode ser negativo.");
        }

        if (min>0 && atual <= min) {
            return "Estoque baixo.";
        }

        if (max > 0 && atual >= max) {
            return "Estoque cheio.";
        }

        return "Estoque atual: " + atual;
    }

    public static void precoValidador(BigDecimal preco) {
        if (preco == null) {
            throw new CustoUnitarioInvalidoException("O preço não pode ser nulo.");
        }

        if (preco.signum() <= 0) {
            throw new CustoUnitarioInvalidoException("O preço deve ser maior que zero.");
        }
    }
}
