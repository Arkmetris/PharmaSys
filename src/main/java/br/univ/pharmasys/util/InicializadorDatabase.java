package br.univ.pharmasys.util;

import br.univ.pharmasys.dao.FuncionarioDAO;
import br.univ.pharmasys.model.Funcionario;

public class InicializadorDatabase {

    public static void verificarEInicializar() {
        FuncionarioDAO dao = new FuncionarioDAO();
        
        // Dados do Admin Padrão
        String cpfAdmin = "11111111111"; 
        

        if (dao.buscarPorCpf(cpfAdmin) == null) {
            
            System.out.println(">> Banco de dados vazio ou sem Admin. Criando usuário padrão...");

            Funcionario admin = new Funcionario();
            admin.setNome("Administrador Gerente");
            admin.setCpf(cpfAdmin);
            admin.setSenha("admin12345");
            admin.setTipo(3);
            admin.setSexo("M");
            admin.setTelefone("81999999999");
            admin.setEmail("Email");
            
            dao.create(admin);
            
            System.out.println(">> SUCESSO! Admin criado.");
            System.out.println(">> Use CPF: 11111111111 | Senha: admin12345");
            
        } else {
            System.out.println(">> Sistema iniciado. Admin padrão já verificado no banco.");
        }
    }
}