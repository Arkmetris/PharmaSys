package br.univ.pharmasys.model;

import java.time.LocalDate;
import br.univ.pharmasys.service.FuncionarioValidador;
import br.univ.pharmasys.service.TelefoneValidador;
import br.univ.pharmasys.util.ValidadorUtils;

public class Funcionario {

  private  long idFuncionario;
  private String nome;
  private  String cpf;
  private LocalDate dataNascimento;
  private String sexo;
  private String telefone;
  private int tipo;
  private String senha;
  private String email;


  public Funcionario(){

  }

  public  long getIdFuncionario() {
    return idFuncionario;
  }



  public void setIdFuncionario(long idFuncionario) {

      //Vai validar o id do funcionario, chamando o FuncionarioValidador.idFuncionarioValidar()
      FuncionarioValidador.idFuncionarioValidar(idFuncionario);
      this.idFuncionario = idFuncionario;
  }

  public String getNome() {
      return nome;
  }

  public void setNome(String nome) {

      //Vai validar o nome do funcionario, chamando o FuncionarioValidador.nomeValidar()
      nome = nome.trim();
      FuncionarioValidador.nomeValidar(nome);
      this.nome = nome;
  }

  public String getCpf() {
      return cpf;
  }

  public void setCpf(String cpf) {

      //Vai validar o CPF do funcionario, mas provavelmente vai ser mudado logo, logo
      cpf = cpf.trim();
      ValidadorUtils.cpfValido(cpf);
      cpf=cpf.replaceAll("\\D", "");
      this.cpf = cpf;
  }

  public LocalDate getDataNascimento() {

      return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {

      //Validação da data de nascimento do funcionario
      FuncionarioValidador.dataNascimentoValidar(dataNascimento);
       this.dataNascimento = dataNascimento;

  }

  public String getSexo() {

      return sexo;
  }

  public void setSexo(String sexo) {

      sexo = sexo.trim();
      FuncionarioValidador.sexoValidar(sexo);
      this.sexo = sexo;
  }

  public String getTelefone() {

      return telefone;
  }

  public void setTelefone(String telefone) {

      telefone = telefone.trim();
      TelefoneValidador.numeroTelefoneValidar(telefone);
      telefone = telefone.replaceAll("\\D", "");
      this.telefone = telefone;
  }

  public int getTipo() {

      return tipo;
  }

  public void setTipo(int tipo) {

      this.tipo = tipo;
  }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        senha= senha.trim();
        FuncionarioValidador.senhaValidar(senha);
        this.senha = senha;
    }

    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      email = email.trim();
      ValidadorUtils.emailValido(email);
      this.email = email;
    }

}

