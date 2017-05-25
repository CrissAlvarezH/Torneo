<%@page import="java.util.List"%>
<%@page import="Modelos.Usuario"%>
<%@page import="Controladores.UsuarioController"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if ((session.getAttribute("idusuario") == null) || (session.getAttribute("idusuario") == "")) {
        response.sendRedirect("ingresar");
    }
%>
<%@page import="java.sql.SQLException"%>
<%@page import="Conexion.BDCrud"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Conexion.DBUtilidades"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:set var="req" value="${pageContext.request}" />
        <base href="${fn:replace(req.requestURL, req.requestURI, req.contextPath)}/" />
        <link rel="stylesheet" href="font/flaticon.css">
        <!-- Vinculamos con el estilo -->
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="css/item_club.css">
        <title>Clubes</title>
        
    </head>
    
        <jsp:include page="header.jsp"/>
        
        <%
            List<Usuario> usuarios = UsuarioController.obtenerUsuarios();
            for (Usuario usuario: usuarios) {
        %>
            <a href="clubes">
                <div class="item-group">
                    <div class="item">
                        <div class="item-container">
                            <img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQOZqyOCKrRpzt7OwVXOi1yspqIigW0OEXIQAsxJPX5-avqv5mtj6Haog"
                                class="item-img">
                        </div>
                        <div class="item-container">
                            <h2><%= usuario.getNombres() %></h2>
                            <p><%= usuario.getApellidos()  %></p>
                        </div>
                    </div>
                </div>
            </a>
        <%
            }// fin del foreach
        %>
    
</html>
