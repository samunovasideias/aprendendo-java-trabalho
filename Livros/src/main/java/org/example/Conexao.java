package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class Conexao {



        public static Connection getcon() throws SQLException {
            String url="jdbc:postgresql://localhost:5432/livraria";
            String user="postgres";
            String password="sambm1409";
            return DriverManager.getConnection(url,user,password);


        }
}
