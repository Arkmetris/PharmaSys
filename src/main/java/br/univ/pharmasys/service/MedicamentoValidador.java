package br.univ.pharmasys.service;

import br.univ.pharmasys.exceptions.*;

import java.math.BigDecimal;
import java.time.LocalDate;


public class MedicamentoValidador {


    public static void skuValidar(String sku){

        if (sku == null|| sku.trim().isEmpty()){

            throw new ErroDePreenchimentoInvalidoException("Campo Vazio!");

        }

        sku = sku.trim();

        if(!sku.matches("\\S+")){
            throw new ErroDePreenchimentoInvalidoException("Não pode espaço no meio do sku");
        }


    }


    public static void codigoBarrasValidar(String codigo){
        if (codigo == null || codigo.trim().isEmpty()){

            throw new ErroDePreenchimentoInvalidoException("Campo do código de barras deve ser preenchido!");
        }

        codigo = codigo.trim();
        if(codigo.length()!=13){

            throw new ErroDePreenchimentoInvalidoException("Código de barras deve ter 13 caracteres!");

        }
        else if(!codigo.matches("\\S+")){

            throw new ErroDePreenchimentoInvalidoException("Atenção: Não pode haver espaçamento no meio do código de barras");
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
        else if (!nome.matches("\\S+")){

            throw new NomeInvalidoException("Atenção: você não pode por espaçamento nos seus nomes!");
        }



    }

    public static void principioAtivoValidar(String principio){

        if(principio == null || principio.trim().isEmpty()){
            throw new ErroDePreenchimentoInvalidoException("Está inválido ou vazio!");
        }


        principio = principio.trim();

        if (!principio.matches("\\S+")){
            throw new ErroDePreenchimentoInvalidoException("Não é permitido espaçamento");
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
        else if (!dose.matches("\\S+")){

            throw new ErroDePreenchimentoInvalidoException("Atenção: Não é permitido espaçamentos na dosagem!");

        }

    }

    public static void formaFarmaceuticaValidar(String formaFarmaceutica){

        if(formaFarmaceutica == null || formaFarmaceutica.trim().isEmpty()){
            throw new ErroDePreenchimentoInvalidoException("Error: a forma está vazia ou nula");
        }

        formaFarmaceutica = formaFarmaceutica.trim();

        if(!formaFarmaceutica.matches("\\S+")){

            throw new ErroDePreenchimentoInvalidoException("Atenção: Não é permitido espaçamentos!");
        }

    }

    public static void laboratorioValidar(String laboratorio){

        if(laboratorio == null || laboratorio.trim().isEmpty()){
            throw new ErroDePreenchimentoInvalidoException("Error: Está vazia ou nula");
        }

        laboratorio = laboratorio.trim();

        if(!laboratorio.matches("\\S+")){

            throw new ErroDePreenchimentoInvalidoException("Atenção: Não é permitido espaçamentos");

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
