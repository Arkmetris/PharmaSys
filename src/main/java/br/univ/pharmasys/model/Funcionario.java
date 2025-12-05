package br.univ.pharmasys.model;

import java.time.LocalDate;
import br.univ.pharmasys.service.FuncionarioValidador;

public abstract class Funcionario {

  protected  long idFuncionario;
  protected String nome;
  protected  String cpf;
  protected LocalDate dataNascimento;
  protected String sexo;
  protected String telefone;
  protected int tipo;


  public Funcionario(){

  }

  public  long getIdFuncionario() {
    return idFuncionario;
  }

  public void setIdFuncionario(long idFuncionario) {
      FuncionarioValidador.idFuncionarioValidar(idFuncionario);
      this.idFuncionario = idFuncionario;
  }

  public String getNome() {
      return nome;
  }

  public void setNome(String nome) {
      FuncionarioValidador.nomeValidar(nome);
      nome = nome.trim();
      this.nome = nome;
  }

  public String getCpf() {
      return cpf;
  }

  public void setCpf(String cpf) {
      FuncionarioValidador.cpfValidar(cpf);
      cpf=cpf.replaceAll("\\D", "");
      this.cpf = cpf;
  }

  public LocalDate getDataNascimento() {

      return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {

      FuncionarioValidador.dataNascimentoValidar(dataNascimento);
       this.dataNascimento = dataNascimento;

  }

  public String getSexo() {

      return sexo;
  }

  public void setSexo(String sexo) {
      FuncionarioValidador.sexoValidar(sexo);
      sexo = sexo.trim();
      this.sexo = sexo;
  }

  public String getTelefone() {

      return telefone;
  }

  public void setTelefone(String telefone) {

      FuncionarioValidador.telefoneValidar(telefone);
      telefone = telefone.replaceAll("\\D", "");
      this.telefone = telefone;
  }

  public int getTipo() {

      return tipo;
  }

  public void setTipo(int tipo) {

      this.tipo = tipo;
  }


}

