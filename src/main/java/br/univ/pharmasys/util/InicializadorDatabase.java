package br.univ.pharmasys.util;

import br.univ.pharmasys.dao.FuncionarioDAO;
import br.univ.pharmasys.model.Funcionario;
import java.time.LocalDate;

public class InicializadorDatabase {

    public static void verificarEInicializar() {
        FuncionarioDAO dao = new FuncionarioDAO();
        
        // Dados do Admin Padrão
        String cpfAdmin = "11122233396"; 
        

        if (dao.buscarPorCpf(cpfAdmin) == null) {
            
            System.out.println(">> Banco de dados vazio ou sem Admin. Criando usuário padrão...");

            Funcionario admin = new Funcionario();
            admin.setNome("Administrador Gerente");
            admin.setCpf(cpfAdmin);
            admin.setSenha("admin12345");
            admin.setTipo(3);
            admin.setSexo("Masc");
            admin.setTelefone("81999999999");
            admin.setEmail("admin@pharmasys.com");
            admin.setDataNascimento(LocalDate.of(1990, 1, 1));
            
            dao.create(admin);
            
            System.out.println(">> SUCESSO! Admin criado.");
            System.out.println(">> Use CPF: " + cpfAdmin + " | Senha: admin12345");
            
        } else {
            System.out.println(">> Sistema iniciado. Admin padrão já verificado no banco.");
        }
    }
}