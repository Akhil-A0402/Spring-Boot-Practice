package com.example.SpringBootPractice.jpaPractice.part1.withoutJpa;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@Component
public class DatabaseConnection {
    public Connection getConnection (){
        try {
            // H2 driver loading
            Class.forName("org.h2.Driver");

            // Establishing connection with DB
            return DriverManager.getConnection("jdbc:h2:mem:userDB", "sa", "");
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
