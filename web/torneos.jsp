<%-- 
    Document   : torneos
    Created on : 30-may-2017, 9:26:23
    Author     : CristianAlvarez
--%>
<%@page import="Controladores.*"%>
<%@page import="java.util.List"%>
<%
    if ((session.getAttribute("idusuario") == null) || (session.getAttribute("idusuario") == "")) {
        response.sendRedirect("ingresar");
    }
    
    
    List<Torneo> torneos = TorneoController.listarTorneos();
    
%>

<%@page import="Modelos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilo_clubes.css">
	<link rel="stylesheet" href="css/estilo-items.css">
        <title>Torneos</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <div class="contenedor-principal">

        <div class="contenedor-izquierda">
            <!--<div class="contenedor-busqueda">
                <div class="busqueda">
                    <form action="" method="post">
                        <input type="text" placeholder="Buscar club por nombre" class="form-buscar-item input-busqueda" name="nombre_buscar">
                        <input type="submit" value="buscar" class="boton btn-buscar">
                    </form>
                </div>
            </div>-->
        
            <div class="contenedor-lista">
                <% 
                    for(Torneo torneo : torneos){
                %>

                    <div class="item-group">
                        <div class="item" onclick="clickEnClub()">
                            <div class="item-container">
                                <img src="img/img_clubes.png"
                                    class="item-img">
                            </div>
                            <div class="item-textos">
                                <h2><%= torneo.getNombre() %></h2>
                                <p><br><%= torneo.getDescripcion() %></p>
                            </div>
                        </div>
                    </div>

                <%
                    }// fin del foreach
                %>
        </div>
    </div>
        
    <script type="text/javascript">
        function clickEnInsertar(){
            window.location="registro_torneo.jsp";
        }
    </script>

    <div class="contenedor-derecha">
        

        <div class="contenedor-insertar-item">
            <div class="insertar-item">
                  
                <input type="submit" onclick="clickEnInsertar()" class="input-insertar" value="Crear Torneo" class="boton btn-insertar">
                
                
            </div>
        </div>
    </div>

</div>

    </body>
</html>
