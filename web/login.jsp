<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Conexion.DBUtilidades"%>
<%
    String error = "";
    //SI YA ESTÁ AUTENTICADO LO LLEVAMOS A LA PÁGINA PRINCIPAL
    if ((session.getAttribute("idusuario") != null)) {
        response.sendRedirect("");
    }
    
    //VERIFICAMOS QUE ES UN POST
    if (request.getParameter("id_usuario") != null) {
        String id = request.getParameter("id_usuario");
        String pass = request.getParameter("pass_usuario");
        
        Boolean validarUsuario = new DBUtilidades().validarUsuario(Integer.parseInt(id), pass);

        if (validarUsuario) {
            session.setAttribute("idusuario", id);
            response.sendRedirect("");
        } else {
            error = "Usuario o contraseña incorrecta";
        }
    } 
    
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso</title>
        <link rel="stylesheet" href="css/estilo_ingreso.css">
    </head>
    <body>
        <h1>Formulario de registro</h1>
        <form action="ingresar" method="post" class="form-registro">

            <h2 class="form__titulo"><font face="arial">LOGIN</font></h2>
            
            <p class="form__link">
            <%
                if (error != "") {
                    out.print(error);
                }
            %>
            </p>

            <div class="contenedor-inputs">
                <input type="number" name="id_usuario" placeholder="Identificador" class="input-100" required>
                <input type="password" name="pass_usuario" placeholder="Contrase&ntilde;a" class="input-100" required>
                <input type="submit" Value="Ingresar" class="btn-enviar">

                <p class="form__link">¿No tienes cuenta? <a href="registro">Registrate aqui</a></p>
            </div>
        </form>

    </body>
</html>
