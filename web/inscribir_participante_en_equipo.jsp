<%-- 
    Document   : inscribir_participante_en_equipo
    Created on : 30-may-2017, 9:04:32
    Author     : CristianAlvarez
--%>

<%@page import="Controladores.ParticipanteController"%>
<%
    int id_participante = Integer.parseInt(request.getParameter("part"));
    int id_equipo = Integer.parseInt(request.getParameter("equi"));
    int id_club = Integer.parseInt(request.getParameter("club"));
    
    if(ParticipanteController.inscribirParticipanteEnEquipo(id_participante, id_equipo)){
        response.sendRedirect("info_equipo.jsp?id="+id_equipo+"&club="+id_club);
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1></h1>
    </body>
</html>
