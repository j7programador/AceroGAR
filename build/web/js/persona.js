/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function llenarFormulario(fila) {
    var id = $(fila).find(".id").text();
    var direccion = $(fila).find(".direccion").text();
    var numerodocumento = $(fila).find(".numerodocumento").text();
    var email = $(fila).find(".email").text();
    var password = $(fila).find(".password").text();
    var telefono = $(fila).find(".telefono").text();
    var nombre = $(fila).find(".nombre").text();
    
    
    $('#id').val(id);
    $('#direccion').val(direccion);
    $('#numerodocumento').val(numerodocumento);
    $('#email').val(email);
    $('#password').val(password);
    $('#telefono').val(telefono);
    $('#nombre').val(nombre);
    
}

$(document).ready(function() {
    
    $("#exampleModal").on("hidden.bs.modal", function() {
        $('form')[0].reset();
    });
    
    $(document).on('click', '.editar', function() {
        llenarFormulario($(this).closest('tr'));
    });
    
    $(document).on('click', '.eliminar', function() {
        llenarFormulario($(this).closest('tr'));
    });
});

