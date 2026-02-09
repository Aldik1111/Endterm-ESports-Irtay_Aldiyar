package com.example.endtermesportsirtay_aldiyar.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection { // DB info
    private static final String URL = "jdbc:postgresql://localhost:5432/esports_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    private DatabaseConnection(){};

    public static Connection getConnection(){ // connect
        try{
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch(SQLException e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}


