<%-- 
    Document   : personas
    Created on : 31/01/2024, 10:39:45 PM
    Author     : JLoyes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.modelo.Persona"%>
<%@page import="com.modelo.PersonaDAO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%! 
            PersonaDAO personadao = new PersonaDAO();
        %>
        <div class="container">
            <%@include file= "../template/menu.jsp"%>
            <div class="row align-items-start">
                <div class="col-5">
                    <h1>Gestión de Personas</h1>
                </div><!-- comment -->
                <div class="col-5 align-self-center">
                    <div class="d-grid gap-2">
                       <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Crear</button>
 
                    </div>

                </div><!-- comment -->
                
            </div>
          
            <div class="table-responsive">
                <table class="table table-dark">
                    <thead>
                        <th>Id</th>
                        <th>Direccion</th>
                        <th>Numero de Documento</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Telefono</th><!-- comment -->
                        <th>Nombre</th><!-- comment -->
                        <th>Tipo</th><!-- comment -->
                        <th>Acciones</th>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Persona> personas = personadao.mostrarPersonas();
                            
                            for(Persona persona : personas) {
                                
                            
                        %>
                        <tr>
                            <td class="id"><%=persona.getId()%></td>
                            <td class="direccion"><%=persona.getDireccion()%></td>
                            <td class="numerodocumento"><%=persona.getNumerodocumento()%></td>
                            <td class="email"><%=persona.getEmail()%></td>
                            <td class="password"><%=persona.getPassword()%></td>
                            <td class="telefono"><%=persona.getTelefono()%></td>
                            <td class="nombre"><%=persona.getNombre()%></td>
                            <td class="tipo"><%=persona.getTipo()%></td>
                            <td>
                                <button type="button" class="btn btn-secondary editar" data-bs-toggle="modal" data-bs-target="#exampleModal">Editar</button>
                                <button type="button" class="btn btn-danger eliminar" data-bs-toggle="modal" data-bs-target="#exampleModal">Eliminar</button>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
        </div>
                            <!-- Button trigger modal -->
             
                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                  <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Registro de Persona</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                      </div>
                      <div class="modal-body">
                          <form action="${pageContext.servletContext.contextPath}/PersonaServlet" method="post" role="form">
                              <div class="row">
                                  <div class="col-5">
                                      <label>Id</label>
                                      <input type="number" name="id" id="id"  class="form-control">
                                  </div>
                                  <div class="col-5">
                                      <label>Direccion</label>
                                      <input type="text" name="direccion" class="form-control" id="direccion" >
                                  </div>
                              </div>
                              <div class="row">
                                  <div class="col-5">
                                      <label>Numero de Documento</label>
                                      <input type="text" name="numerodocumento" id="numerodocumento"  class="form-control">
                                  </div>
                                  <div class="col-5">
                                      <label>Email</label>
                                      <input type="email" name="email" class="form-control" id="email" >
                                  </div>
                              </div>
                              <div class="row">
                                  <div class="col-5">
                                      <label>Password</label>
                                      <input type="password" name="password" id="password"  class="form-control">
                                  </div>
                                  <div class="col-5">
                                      <label>Telefono</label>
                                      <input type="text" name="telefono" class="form-control" id="telefono">
                                  </div>
                              </div><!-- comment -->
                              <div class="row">
                                  <div class="col-5">
                                      <label>Nombre</label>
                                      <input type="text" name="nombre" id="nombre" class="form-control">
                                  </div>
                                  <div class="col-5">
                                      <label>Tipo</label>
                                      <select class="form-control" name="tipo" id="tipo">
                                          <option value="cliente">Cliente</option>
                                          <option value="empleado">Empleado</option>
                                      </select>
                                  </div>
                              </div>
                              <hr>
                              <div class="row">
                                  <div class="col-8">
                                      <button type="submit" class="btn btn-secondary" name="editar">Editar</button>
                                      <button type="submit" class="btn btn-danger" name="eliminar">Eliminar</button>

                                      <button type="submit" class="btn btn-primary" name="guardar">Guardar</button>
                                  </div>
                              </div>
                          </form>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        
                      </div>
                    </div>
                  </div>
                </div>

                
            </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
        <%
            if(request.getAttribute("message") != null) {
                
            
        %>
        <script>alert('<%=request.getAttribute("message")%>')</script>
        <%
            
            }
        %>
        <script src="${pageContext.servletContext.contextPath}/js/persona.js"></script>
    
    </body>
</html>
