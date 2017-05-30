<%@page import="Controladores.TorneoController"%>
<%
    if ((session.getAttribute("idusuario") == null) || (session.getAttribute("idusuario") == "")) {
        response.sendRedirect("ingresar");
    }
    
    boolean inscripcionExitosa = false;
    String mensageError = "";
    // verificamos que llenó el formulario
    if(request.getParameter("id_torneo") != null){
        inscripcionExitosa = TorneoController.registrarTorneo(request);
        
        if(inscripcionExitosa){
            response.sendRedirect("torneos.jsp");
        }else{
            mensageError = "No se pudo realizar el registro";
        }
    }
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Unisports - Register championship</title>
        <link rel="stylesheet" href="css/registro-torneo/estilo_registro_torneo.css">
    </head>
    <body>
        
        <jsp:include page="header.jsp"/>
        
        <h1>Formulario de registro de torneo</h1>
        
        <form action="" method="post" class="form-registro">
            <p><%= mensageError %></p>
            <h2 class="form__titulo"><font face="arial">REGISTRA UN TORNEO</font></h2>
            <div class="contenedor-inputs">
            <input type="text" name="id_torneo" placeholder="Codigo del torneo" class="input-100" required>
            <input type="text" name="nombre_torneo" placeholder="Nombre del torneo" class="input-100" required>
            <select name="deporte" class="seleccion-100" required>
                <option value="0_deporte" disabled selected hidden>Selecciona un deporte</option>
                <option value="1_deporte">Futbol</option>
                <option value="2_deporte">Esqui</option>
                <option value="3_deporte">Ciclismo</option>
                <option value="4_deporte">Esgrima</option>
            </select>
            <input type="text" name="descripcion" placeholder="Descripcion" class="input-100" required>
            <input placeholder="Fecha de inicio" name="fecha_inicio" class="textbox-n" type="text" onfocus="(this.type='date')"  id="date" required>
            <input placeholder="Fecha de fin" name="fecha_fin" class="textbox-n" type="text" onfocus="(this.type='date')"  id="date" required>
            </select>
            <input type="submit" Value="Registrar torneo" class="btn-enviar" required>
            </div>
        </form>
    </body>
</html>
