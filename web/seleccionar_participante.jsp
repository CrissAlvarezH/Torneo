<%@page import="Controladores.ParticipanteController"%>
<%@page import="Modelos.Participante"%>
<%@page import="Modelos.Participante"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if ((session.getAttribute("idusuario") == null) || (session.getAttribute("idusuario") == "")) {
        response.sendRedirect("ingresar");
    }
    
    int id_club = Integer.parseInt(request.getParameter("club"));
    int id_equipo = Integer.parseInt(request.getParameter("id"));
  
    
    List<Participante> participantes = ParticipanteController.obtenerParticipantesParaAgregarEquipo(id_club, id_equipo);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/elegir_participante/estilo-formulario-modal-elegir.css">
        <link rel="stylesheet" href="css/elegir_participante/estilo-item-elegir-participante.css">
        <link rel="stylesheet" href="css/elegir_participante/estilo-modal-elegir-participante.css">
        
        
        <title>Seleccionar participante</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <div class="modal">
        <div class="contenedor-elegir">
                <div class="contenedor-derecha">

                    <div class="texto-centrado">
                      <h3 class="texto-sin-margin">Seleccione un participante</h3>
                    </div>
                    <div class="contenedor-lista">
                        
                        <%
                            for(Participante participante : participantes){
                        %>
                            <div class="item-group" onclick="clickEnParticipante(<%= participante.getId() %>, <%= id_club %>, <%= id_equipo %>)">
                                <div class="item">
                                    <div class="item-textos">
                                            <h3 class="text-item"><%= participante.getNombres()+" "+participante.getApellidos() %></h3>
                                            <p class="text-item id-participante">Edad: <%= participante.getEdad() %></p>
                                    </div>
                                </div>
                            </div>
 
                        <%
                            }
                        %>
                        
                      </div>
                        
                    <script type="text/javascript">
                        
                        function clickEnParticipante(id_participante, id_club, id_equipo){
                            window.location="inscribir_participante_en_equipo.jsp?part="+
                                    id_participante+"&equi="+id_equipo+"&club="+id_club;
                        }

                        function mandarAlert(){
                            alert('aler mandado');
                        }
                    </script>  

                </div>
        </div>
        </div>
    </body>
</html>
