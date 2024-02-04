/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.Persona;
import com.modelo.PersonaDAO;
import java.util.Date;

/**
 *
 * @author JLoyes
 */
public class PersonaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           int id = Integer.parseInt(request.getParameter("id"));
           String direccion = request.getParameter("direccion");
           String numerodocumento = request.getParameter("numerodocumento");
           String email = request.getParameter("email");
           String password = request.getParameter("password");
           String telefono = request.getParameter("telefono");
           String nombre = request.getParameter("nombre");
           String tipo = request.getParameter("tipo");
           Date fechaRegistro = new Date();
           
           String mensaje = "No se guardo exitosamente";
           
           int respuesta;
           
           Persona persona = new Persona(id, direccion, numerodocumento, email, password, telefono, nombre, fechaRegistro, tipo);
           PersonaDAO personadao = new PersonaDAO();
           
           if(request.getParameter("guardar") != null) {
               respuesta = personadao.ingresarPersona(persona);
               if(respuesta != 0) {
                   mensaje = "Se guardo el registro de forma exitosa";
               }
           } else if(request.getParameter("editar") != null) {
               respuesta = personadao.modificarPersona(persona);
               if(respuesta != 0) {
                   mensaje = "Se modifico el registro de forma exitosa";
               }
           } else if(request.getParameter("eliminar") != null) {
               respuesta = personadao.eliminarPersona(persona);
               if(respuesta != 0) {
                   mensaje = "Se elimino el registro de forma exitosa";
               }
           }
           
           request.setAttribute("message", mensaje);
           request.getRequestDispatcher("/views/personas.jsp").forward(request, response);
        } catch(Exception e) {
            System.out.println("" + e.getLocalizedMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
