package br.univ.pharmasys.model;
//
import br.univ.pharmasys.service.DependenteValidador;
import java.time.LocalDate;

public class Dependente {

    private Long id;
    private Funcionario funcionario; 
    private String cpfFuncionario; 
    private String nome;
    private String parentesco;
    private LocalDate dataNascimento;

    public Dependente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        DependenteValidador.validarFuncionario(funcionario);
        this.funcionario = funcionario;
        //Ao setar o objeto já preenche o CPF automaticamente
        if (funcionario != null && funcionario.getCpf() != null) {
            this.cpfFuncionario = funcionario.getCpf();
        }
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        //Chama a validação no serviço
        DependenteValidador.validarCpfFuncionario(cpfFuncionario);
        this.cpfFuncionario = cpfFuncionario.trim();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        DependenteValidador.validarNome(nome);
        this.nome = nome.trim();
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        DependenteValidador.validarParentesco(parentesco);
        this.parentesco = parentesco.trim();
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        DependenteValidador.validarDataNascimento(dataNascimento);
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public String toString() {
        return "Dependente [Nome=" + nome + ", Titular(CPF)=" + cpfFuncionario + "]";
    }
}