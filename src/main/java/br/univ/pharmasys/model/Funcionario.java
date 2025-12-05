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


  public Funcionario(int idFuncionario, String nome, String cpf, LocalDate dataNascimento,String sexo,  String telefone, int tipo){

        FuncionarioValidador.idFuncionarioValidar(idFuncionario);
        FuncionarioValidador.nomeValidar(nome);
        FuncionarioValidador.cpfValidar(cpf);
        FuncionarioValidador.dataNascimentoValidar(dataNascimento);
        FuncionarioValidador.sexoValidar(sexo);
        FuncionarioValidador.telefoneValidar(telefone);

       this.idFuncionario = idFuncionario;
       this.nome = nome.trim();
       this.cpf = cpf.replaceAll("\\D", "");
       this.dataNascimento = dataNascimento;
       this.sexo = sexo.trim();
       this.telefone = telefone.replaceAll("\\D", "");
       this.tipo = tipo;

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
      this.nome = nome;
  }

  public String getCpf() {
      return cpf;
  }

  public void setCpf(String cpf) {
      FuncionarioValidador.cpfValidar(cpf);
      this.cpf = cpf.replaceAll("\\D", "");
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
      this.sexo = sexo.trim();
  }

  public String getTelefone() {

      return telefone;
  }

  public void setTelefone(String telefone) {

      FuncionarioValidador.telefoneValidar(telefone);
      this.telefone = telefone.replaceAll("\\D", "");
  }

  public int getTipo() {

      return tipo;
  }

  public void setTipo(int tipo) {

      this.tipo = tipo;
  }


}
