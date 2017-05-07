<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    /*if ((session.getAttribute("idusuario") != null)) {
        response.sendRedirect("");
    }*/
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Registro</title>
        <link rel="stylesheet" href="css/estilo_ingreso.css">
    </head>
    <body>
        <h1>Formulario de registro</h1>
        <form action="" method="post" class="form-registro">

            <h2 class="form__titulo"><font face="arial">REGISTRO</font></h2>
            <h3 id="error" class="form__error"></h3>

            <div class="contenedor-inputs">
                <input id="id" type="email" name="id" placeholder="N° de Idenficacion" class="input-100" required>
                <input id="nombre" type="text" name="nombre" placeholder="Nombre" class="input-48" required>
                <input id="apellidos" type="text" name="apellidos" placeholder="Apellidos" class="input-48" required>
                <input id="sexo" type="text" name="sexo" placeholder="Sexo. ej: Femenino"  class="input-48" required onkeyup="validarSexo()">
                <input id="password" type="password" name="clave" placeholder="Contraseña" class="input-48" required min="6">
                <input type="submit" Value="Registrar" class="btn-enviar">

                <p class="form__link">¿Ya tienes cuenta? <a href="ingresar">Ingresa aquí­</a></p>
            </div>
        </form>
        <script src="js/registro.js"></script>
    </body>
</html>
