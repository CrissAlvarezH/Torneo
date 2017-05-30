
<%@page import="Controladores.ParticipanteController"%>
<%@page import="Modelos.Participante"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.Equipo"%>
<%@page import="Controladores.EquipoController"%>
<%
    if ((session.getAttribute("idusuario") == null) || (session.getAttribute("idusuario") == "")) {
        response.sendRedirect("ingresar");
    }
    
    int id_club = Integer.parseInt(request.getParameter("club"));
    int id_equipo = Integer.parseInt(request.getParameter("id"));
  
    Equipo equipo = EquipoController.obtenerEquipo(id_equipo);
    
    List<Participante> participantes = ParticipanteController.obtenerParticipantesDeEquipo(id_equipo);
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1">
        <link rel="stylesheet" href="css/info-equipo/estilo-modal-equipo.css">
        <link rel="stylesheet" href="css/info-equipo/estilo-formulario-equipo.css">
        <link rel="stylesheet" href="css/info-equipo/estilo-item-equipo.css">
        
    
    </head>

    <body>
        <jsp:include page="header.jsp"/>
        
        <div class="modal">
            <div class="contenedor">
                <div class="contenedor-izquierda">

                    <div class="texto-centrado">
                      <h1 class="texto-sin-margin"><%= equipo.getNombre() %></h1>
                    </div>
                    
                    <div class="h2">
                        <h3 class="text-sin-margin">Id: <%= equipo.getId() %></h3>
                    </div>
                    
                    <div class="div_btn">
                        <input class="btn-inscribir-p" onclick="clickEnAgregarParticipante(<%= equipo.getId() %>, <%= id_club %>)" type="button" value="Agregar un participante">
                        
                    </div>
                    <div class="div_btn">
                        <input class="btn-volver" onclick="clickEnVolver(<%= id_club %>)" type="button" value="Volver">
                    </div>
                </div>
                    
                <script type="text/javascript">
                    function clickEnAgregarParticipante(id_equipo, id_club){
                        window.location="seleccionar_participante.jsp?id="+id_equipo+"&club="+id_club;
                    }

                    function clickEnVolver(id_club){
                        window.location="descripcion_club.jsp?id="+id_club;
                    }

                    function mandarAlert(){
                        alert('aler mandado');
                    }
                </script>  


                <hr class="linea-vertical">
                <div class="contenedor-derecha">

                    <div class="texto-centrado">
                      <h3 class="texto-sin-margin">Participantes</h3>
                    </div>
                    <div class="contenedor-lista">
                        <%
                            for(Participante participante : participantes){
                        %>
                        
                            <div class="item-group">
                                <div class="item">
                                    <div class="item-textos">
                                            <h4 class="text-item"><%= participante.getNombres()+" "+participante.getApellidos() %></h4>
                                            <p class="text-item id-participante">Edad: <%= participante.getEdad() %></p>
                                    </div>
                                </div>
                            </div>

                        <%
                            }// fin de foreach
                        %>
                      </div>
                </div>
            </div>
        </div>
    </body>
</html>
