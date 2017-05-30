
<%@page import="Controladores.ParticipanteController"%>
<%
    if ((session.getAttribute("idusuario") == null) || (session.getAttribute("idusuario") == "")) {
        response.sendRedirect("ingresar");
    }
    
    int id_club = Integer.parseInt(request.getParameter("id"));
    boolean inscripcionExitosa = false;
    String mensageError = "";
    // verificamos que llenó el formulario
    if(request.getParameter("peso") != null){
        inscripcionExitosa = ParticipanteController
                .inscribirEnClub(request, id_club, Integer.parseInt(request.getParameter("id_participante")));
        
        if(inscripcionExitosa){
            response.sendRedirect("descripcion_club.jsp?id="+id_club);
        }else{
            mensageError = "No se pudo realizar la inscripcion";
        }
    }
%>

<!DOCTYPE html>
<html lang="es">
    <head>
       <meta charset="UTF-8">
       <meta name="viewport" content="width=device-width, user-scalable=no,  initial=scale=1, maxinum-scale=1, maxinum-scale=1">
       <link rel="stylesheet" href="css/inscribir-participante/estilo_ventana_participante.css">
       <link rel="stylesheet"href="css/inscribir-participante/estio_formulario_participante.css">
       <link rel="stylesheet"href="css/estilo.css">
    </head>
    
    <body>  
        <jsp:include page="header.jsp"/>
        
        <div class="modal">
            <div class="contenido">
                <form action="" method="post" class="form-registro">
                    <h2 class="form__titulo"><font face="arial">INSCRIBE UN PARTICIPANTE</font></h2>
                    <div class="contenedor-inputs">
                        <p> <%= mensageError %> </p>
                        <input type="text" name="id_participante" placeholder="ID del participante" class="input-100" required>
                        <input type="text" name="nombres" placeholder="Nombres del participante" class="input-48" required>
                        <input type="text" name="apellidos" placeholder="Apellidos del participante" class="input-48" required>
                        <input type="number" name="edad" placeholder="edad" class="input-48" required>
                        <select name="sexo" class="seleccion-48" required>
                            <option value="0_sexo" disabled selected hidden>Selecciona sexo</option>
                            <option value="1_sexo">Masculino</option>
                            <option value="2_sexo">Femenino</option>
                        </select>
                        <input type="text" name="estatura" placeholder="Estatura" class="input-48" required>
                        <input type="text" name="peso" placeholder="peso" class="input-48" required>
                        </select>
                        <input type="submit" Value="Inscribir participante" class="btn-enviar" required>
                    </div>
                </form>
             </div>
         </div>
        
    </body>
</html>
