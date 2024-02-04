/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author JLoyes
 */
public class Conexion {
    
    private Connection connection;
    
    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/acerogar?useSSL=false&serverTimezone=UTC","root","lutero93061404307");
            
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println("No se pudo establecer conexión");
        }
    }
    
    public void desconectar() {
        try {
           if(!connection.isClosed()) {
               connection.close();
           }
            
        } catch(SQLException e) {
            System.out.println("No se pudo desconectar");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
    
}
