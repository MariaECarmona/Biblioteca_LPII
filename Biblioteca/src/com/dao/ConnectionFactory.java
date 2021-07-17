package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private Connection conn;

    public Connection getConexao(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
        }catch (SQLException erro){
            throw  new RuntimeException("Erro 1: " + erro);
        }
    }
}
