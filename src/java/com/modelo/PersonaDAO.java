/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import com.conexion.Conexion;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author JLoyes
 */
public class PersonaDAO extends Conexion{
    
    public ArrayList<Persona> mostrarPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();
        
        try {
            this.conectar();
            String consulta = "SELECT * FROM Persona";
            PreparedStatement pre = this.getConnection().prepareStatement(consulta);
            ResultSet resultSet = pre.executeQuery();
            
            while(resultSet.next()) {
                Persona persona = new Persona();
                persona.setId(resultSet.getInt(1));
                persona.setDireccion(resultSet.getString(2));
                persona.setNumerodocumento(resultSet.getString(3));
                persona.setEmail(resultSet.getString(4));
                persona.setPassword(resultSet.getString(5));
                persona.setTelefono(resultSet.getString(6));
                persona.setNombre(resultSet.getString(7));
                persona.setFechaRegistro(resultSet.getDate(8));
                persona.setTipo(resultSet.getString(9));
                
                personas.add(persona);
            }
        } catch(Exception e) {
            System.out.println("No se pudo consultar los datos de personas");
        } finally {
            this.desconectar();
        }
        
        return personas;
        
    }
    
    public int ingresarPersona(Persona persona) {
        int respuesta = 0;
        
        try {
            this.conectar();
            
            String sql = "INSERT INTO Persona (id, direccion, numerodocumento, email, password, telefono, nombre, tipo) "
                                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pre = this.getConnection().prepareStatement(sql);
            pre.setInt(1, persona.getId());
            pre.setString(2, persona.getDireccion());
            pre.setString(3, persona.getNumerodocumento());
            pre.setString(4, persona.getEmail());
            pre.setString(5, persona.getPassword());
            pre.setString(6, persona.getTelefono());
            pre.setString(7, persona.getNombre());
            pre.setString(8, persona.getTipo());
            
            respuesta = pre.executeUpdate();
            
        }catch(SQLException e) {
            System.out.println("Error al ingresar persona");
        } finally {
            this.desconectar();
        }
        
        return respuesta;
    }
    
    
    public int modificarPersona(Persona persona) {
        int respuesta = 0;
        
        try {
            this.conectar();
            
            String sql = "UPDATE Persona SET direccion = ?, numerodocumento = ?, email = ?, "
                    + "password = ?, telefono = ?, nombre = ?, tipo = ? WHERE id = ?";
            
            PreparedStatement pre = this.getConnection().prepareStatement(sql);
            pre.setInt(8, persona.getId());
            pre.setString(1, persona.getDireccion());
            pre.setString(2, persona.getNumerodocumento());
            pre.setString(3, persona.getEmail());
            pre.setString(4, persona.getPassword());
            pre.setString(5, persona.getTelefono());
            pre.setString(6, persona.getNombre());
            pre.setString(7, persona.getTipo());
            
            respuesta = pre.executeUpdate();
            
        }catch(SQLException e) {
            System.out.println("Error al modificar persona");
        } finally {
            this.desconectar();
        }
        
        return respuesta;
    }
    
    public int eliminarPersona(Persona persona) {
        int respuesta = 0;
        
        try {
            this.conectar();
            
            String sql = "DELETE FROM Persona WHERE id = ?";
            
            PreparedStatement pre = this.getConnection().prepareStatement(sql);
            pre.setInt(1, persona.getId());
           
            respuesta = pre.executeUpdate();
            
        }catch(SQLException e) {
            System.out.println("Error al eliminar persona");
        } finally {
            this.desconectar();
        }
        
        return respuesta;
    }
    
    
}
