package br.univ.pharmasys.model;

import java.time.LocalDate;

public abstract class Funcionario {

  protected long idFuncionario;
  protected String nome;
  protected String cpf;
  protected LocalDate dataNascimento;
  protected String sexo;
  protected String telefone;
  protected int tipo;


  public Funcionario(int idFuncionario, String nome, String cpf, LocalDate dataNascimento,String sexo,  String telefone, int tipo){

      this.idFuncionario = idFuncionario;
      this.nome = nome;
      this.cpf = cpf;
      this.dataNascimento = dataNascimento;
      this.sexo = sexo;
      this.telefone = telefone;
      this.tipo = tipo;

  }

  public  long getIdFuncionario() {
    return idFuncionario;
  }

  public void setIdFuncionario(long idFuncionario) {

      if(idFuncionario<=0){

          throw new IllegalArgumentException("\nError: O ID de um funcionário precisa ser positivo");

      }

      this.idFuncionario = idFuncionario;
  }

  public String getNome() {
      return nome;
  }

  public void setNome(String nome) {

      if(nome==null || nome.trim().isEmpty()){
          throw new IllegalArgumentException("\nError: O Campo deve ser preenchido, não pode ficar vazio! ");
      }
      nome = nome.trim();
      this.nome = nome;
  }

  public String getCpf() {
      return cpf;
  }

  public void setCpf(String cpf) {
      if(cpf==null || cpf.trim().isEmpty()){
          throw new IllegalArgumentException("Error: Campo não foi preenchido!");
      }

      cpf = cpf.replaceAll("\\D", "");

      if(cpf.length()!=11){
          throw new IllegalArgumentException("Error: todo CPF deve conter 11 digitos!");
      }

      this.cpf = cpf;
  }

  public LocalDate getDataNascimento() {
      return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {

       if (dataNascimento==null){
           throw new IllegalArgumentException("Error: O Campo deve ser preenchido!");
       }

       if (dataNascimento.isAfter(LocalDate.now())){

           throw new IllegalArgumentException("Error: data de nascimento inválida");
       }

       this.dataNascimento = dataNascimento;

  }

  public String getSexo() {
      return sexo;
  }

  public void setSexo(String sexo) {
      if(sexo==null || sexo.trim().isEmpty()){
          throw new IllegalArgumentException("Error: Campo não foi preenchido!");
      }

      sexo = sexo.trim();
      this.sexo = sexo;
  }

  public String getTelefone() {
      return telefone;
  }

  public void setTelefone(String telefone) {

      if(telefone ==null || telefone.trim().isEmpty()){
          throw new IllegalArgumentException("Error: Preencha o campo de telefone!");
      }

      telefone = telefone.trim();

      telefone = telefone.replaceAll("\\D", "");

      if(telefone.length()!=11){
          throw new IllegalArgumentException("Error: O número deve conter 11 digitos!");
      }

      this.telefone = telefone;
  }

  public int getTipo() {
      return tipo;
  }

  public void setTipo(int tipo) {
      this.tipo = tipo;
  }


}
