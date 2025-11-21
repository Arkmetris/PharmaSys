package br.univ.pharmasys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DATABASE_NAME = "PharmaSys"; 
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME + "?useTimezone=true&serverTimezone=America/Recife";
    private static final String USER = "root"; 
    private static final String PASSWORD = "Caos@2007"; // <--- Coloque a senha que você definiu no mysql

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (SQLException e) {
            System.err.println("FALHA AO CONECTAR AO BANCO DE DADOS!");
            throw new RuntimeException("Erro de Conexão: " + e.getMessage(), e);
        }
    }
}