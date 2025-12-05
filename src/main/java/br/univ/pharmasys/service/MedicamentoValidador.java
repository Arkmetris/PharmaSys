package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MedicamentoValidador {


    public static void skuValidar(String sku){

        if (sku == null || sku.trim().isEmpty()){

            throw new ErroDePreenchimentoInvalidoException("Campo Vazio!");

        }


    }

    public static void codigoBarrasValidar(String codigo){
        if (codigo == null || codigo.trim().isEmpty()){

            throw new ErroDePreenchimentoInvalidoException("Campo do código de barras deve ser preenchido!");

        }
    }

    public static void nomeValidar(String nome){

        if (nome == null) {
            throw new NomeInvalidoException("ERROR: É obrigatório todo medicamento ter um nome!");
        }

        nome = nome.trim();

        if (nome.isEmpty()){
            throw new NomeInvalidoException("ERROR: Remédio não encontrado ou não existe!!");
        }

    }

    public static void principioAtivoValidar(String principio){

        if(principio == null || principio.trim().isEmpty()){
            throw new ErroDePreenchimentoInvalidoException("Está inválido ou vazio!");
        }

    }

    public static void dosagemValidar(String dose){

        if(dose == null){
            throw new ErroDePreenchimentoInvalidoException("Error: A dosagem do medicamento não pode estar vazia!");
        }

        dose = dose.trim();

        if(dose.isEmpty()){
            throw new ErroDePreenchimentoInvalidoException("Error: A dosagem foi escrita de uma forma errada, ou está vazia");
        }

    }

    public static void formaFarmaceuticaValidar(String formaFarmaceutica){

        if(formaFarmaceutica == null || formaFarmaceutica.trim().isEmpty()){
            throw new ErroDePreenchimentoInvalidoException("Error: a forma está vazia ou nula");
        }

    }

    public static void laboratorioValidar(String laboratorio){

        if(laboratorio == null || laboratorio.trim().isEmpty()){
            throw new ErroDePreenchimentoInvalidoException("Error: Está vazia ou nula");
        }
    }

    public static void dataExpiracaoValidar(LocalDate data){

        if(data == null){
            throw new DataInvalidoException("Error: A data de validade não pode ser vazia!");
        }
        else if(data.isBefore(LocalDate.now())){
            throw new DataInvalidoException("Error:O produto deve ter validade futura!");
        }

    }

    public static void estoqueMinValidar (int minimo, int maximoAtual){


        if (minimo < 0) {
            throw new EstoqueMinInvalidoException("Error:O estoque não pode ser menor que zero!");
        }
        else if (maximoAtual > 0 && minimo > maximoAtual){

            throw new EstoqueMinInvalidoException("Error: Estoque mínimo não pode ser maior que o máximo");

        }

    }

    public static void estoqueMaxValidar (int maximo, int minimoAtual){

        if (maximo <= 0){
            throw new EstoqueMaxInvalidoException("Error: o estoque máximo não pode ser negativo ou igual a 0!");
        }
        else if (maximo > 0 && minimoAtual>maximo) {
            throw new EstoqueMaxInvalidoException("Error: o estoque mínimo não pode ser maior que o máximo!");
        }

    }

    public static String estoqueAtualValidar (int estoqueAtual, int minimoAtual, int maximoAtual){

        if(estoqueAtual < 0){
            throw new ErroDePreenchimentoInvalidoException("Error:Não pode existir um estoque negativo!");
        }
        else if (estoqueAtual <= minimoAtual) {

            return("Estoque atual quase vazio");

        }
        else if (estoqueAtual >= maximoAtual) {

           return("Estoque muito cheio");

        }
        else {

            return("Estoque atual: " + estoqueAtual);

        }

    }

    public static void precoValido (BigDecimal preco){

        if(preco == null){
            throw new CustoUnitarioInvalidoException("\nError:Não pode ser nulo!");
        }

        else if (preco.compareTo(BigDecimal.ZERO)== 0){
            throw new CustoUnitarioInvalidoException("Error: Não pode ser zero!");
        }
        else if (preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new CustoUnitarioInvalidoException("Error: Não pode ser negativo!");
        }


    }


}
