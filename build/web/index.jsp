<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso</title>
        <link rel="stylesheet" href="css/estilo_ingreso.css">
    </head>
    <body>
        <h1>Formulario de registro</h1>
        <form action="validar_login.jsp" method="post" class="form-registro">

            <h2 class="form__titulo"><font face="arial">LOGIN</font></h2>
            
            <p class="form__link">
            <%
                String pass_incorrecta = request.getParameter("p");
                
                // si al llamar a el login se pasa un parametro para decir que la pass fue incorrecta
                if(pass_incorrecta != null){
                    if(pass_incorrecta.equals("si"))
                        out.print("Usuario no registrado, login invalido.");
                }
             %>
             </p>

            <div class="contenedor-inputs">
              <input type="number" name="id_usuario" placeholder="Identificador" class="input-100" required>
              <input type="password" name="pass_usuario" placeholder="ContraseÃ±a" class="input-100" required>
              <input type="submit" Value="Ingresar" class="btn-enviar">
              
              <p class="form__link">¿No tienes cuenta? <a href="registro_usuario.html">Registrate aqui</a></p>
            </div>
        </form>
        
    </body>
</html>
