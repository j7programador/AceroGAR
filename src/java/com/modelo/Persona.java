/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import java.util.Date;

/**
 *
 * @author JLoyes
 */
public class Persona {
    
    private int id;
    private String direccion;
    private String numerodocumento;
    private String email;
    private String password;
    private String telefono;
    private String nombre;
    private Date fechaRegistro;
    private String tipo;
    
    public Persona() {
        
    }

    public Persona(int id, String direccion, String numerodocumento, String email, String password, String telefono, String nombre, Date fechaRegistro, String tipo) {
        this.id = id;
        this.direccion = direccion;
        this.numerodocumento = numerodocumento;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
