
<%@page import="Controladores.EquipoController"%>
<%@page import="Controladores.ParticipanteController"%>
<%@page import="Modelos.Participante"%>
<%@page import="java.util.List"%>
<%
    if ((session.getAttribute("idusuario") == null) || (session.getAttribute("idusuario") == "")) {
        response.sendRedirect("ingresar");
    }
    
    String idParticipantes = "", error= "";
    boolean formacionExitosa= false;
    int id_club = Integer.parseInt(request.getParameter("id"));
    
    if(request.getParameter("id_equipo") != null){
        formacionExitosa = EquipoController.formarEquipo(request,
                idParticipantes, Integer.parseInt(request.getParameter("id_equipo")), id_club);
        
        if(formacionExitosa){
            response.sendRedirect("descripcion_club.jsp?id="+id_club);
        }else{
            error = "Error, no se guardo el equipo, intente con otro id";
        }
    }
    
    

    List<Participante> participantes = ParticipanteController.obtenerParticipantesDeUnClub(id_club);
    
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1">
        <link rel="stylesheet" href="css/crear_equipo/estilo-modal.css">
        <link rel="stylesheet" href="css/crear_equipo/estilo-formulario-modal.css">
        <link rel="stylesheet" href="css/crear_equipo/estilo-item-equipo.css">
    </head>

    <body>
        
        <jsp:include page="header.jsp"/>
        
        <div class="modal">
            <div class="contenedor">
                <div class="contenedor-izquierda">
                    <div class="contenedor-inputs">
                        <p><%= error %></p>
                        <form method="post">
                            <input type="text" name="id_equipo" placeholder="ID del equipo" class="input-100" required>
                            <input type="text" name="nombre_equipo" placeholder="Nombre del equipo" class="input-100" required>
                            <input placeholder="Fecha actual" name="fecha" class="input-100" type="text" onfocus="(this.type='date')"  id="date" required>
                            <select name="disciplina" class="seleccion-100" required>
                                <option value="0_disciplina" disabled selected hidden>Escoja una disciplina</option>
                                <option value="1_disciplina">Ciclismo</option>
                                <option value="2_disciplina">Futbol</option>
                                <option value="3_disciplina">Esqui</option>
                                <option value="4_disciplina">Baloncesto</option>
                            </select>
                            <input type="submit" Value="Crear equipo" class="btn-enviar" required>
                        </form>
                    </div>
                </div>
                <!-- 
                <hr class="linea-vertical">
                <div class="contenedor-derecha">
                    
                
                    <div class="texto-centrado">
                      <h3 class="texto-sin-margin">Seleccione los participantes</h3>
                    </div>
                    
                    <div class="contenedor-lista">
                        <%
                            for(Participante participante : participantes){
                        %>
                        
                            <div class="item-group">
                                <div class="item">
                                    <div class="item-textos">
                                            <h3 class="text-item"><%= participante.getNombres()+" "+participante.getApellidos() %></h3>
                                            <input type="checkbox" onClick="if(this.checked){<% idParticipantes += (participante.getId()+","); %> alert(<%= idParticipantes %>);}" name="item1" value="Si" class="check">
                                            <p class="text-item id-participante">Edad: <%= participante.getEdad() %></p>
                                    </div>
                                </div>
                           </div>
                            
                        <%
                            }// fin de foreach
                        %>
                    </div>
                    
                    
                    -->
                </div>
            </div>
        </div>
                    
 
    </body>
</html>
