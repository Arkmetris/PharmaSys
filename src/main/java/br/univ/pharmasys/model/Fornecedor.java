package br.univ.pharmasys.model;

import br.univ.pharmasys.service.FornecedorValidador;
import br.univ.pharmasys.service.TelefoneValidador;
import br.univ.pharmasys.util.ValidadorUtils;

public class Fornecedor {

    private long idFornecedor;
    private String nome;
    private String cnpj;

    private String estado;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;

    private String email;
    private String telefoneId;

    private boolean inativo;

    public Fornecedor() {}

    public long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(long idFornecedor) {
        FornecedorValidador.idFornecedorValidar(idFornecedor);
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome.trim();
        FornecedorValidador.nomeValidar(nome);
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }
      
    public void setCnpj(String cnpj) {

        if (cnpj == null || cnpj.trim().isEmpty()) {
            throw new IllegalArgumentException("O CNPJ não pode estar vazio.");
        }
        boolean valido = ValidadorUtils.cnpjValido(cnpj);
        if (!valido) {
            throw new IllegalArgumentException("CNPJ inválido! Verifique os dígitos.");
        }
        this.cnpj = cnpj.replaceAll("\\D", "");
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado.trim();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep.replaceAll("\\D", "");
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua.trim();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro.trim();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email != null ? email.trim() : "";
        FornecedorValidador.emailValidar(email); 
        if (!ValidadorUtils.emailValido(email)) {
            throw new IllegalArgumentException("Formato de E-mail inválido.");
        }       
        this.email = email;
    }

    public String getTelefoneId() {
        return telefoneId;
    }

    public void setTelefoneId(String telefoneId) {
        TelefoneValidador.numeroTelefoneValidar(telefoneId);
        this.telefoneId = telefoneId.replaceAll("[^0-9]", "");
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

}
