<%@page import="Controladores.*"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.*"%>
<%@page import="Controladores.UsuarioController"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    if ((session.getAttribute("idusuario") == null) || (session.getAttribute("idusuario") == "")) {
        response.sendRedirect("ingresar");
    }
    
    int id_disciplina = Integer.parseInt(request.getParameter("d"));
    int id_municipio = Integer.parseInt(request.getParameter("m"));
    
    if(request.getParameter("codigo") != null)
        ClubController.insertarClubConDisciplina(request, id_municipio, id_disciplina);
    
    List<Club> clubes = ClubController.buscarClubesConDisciplinaYMunicipio(request, id_disciplina, id_municipio);
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1, minimun-scale=1">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
        <c:set var="req" value="${pageContext.request}" />
        <base href="${fn:replace(req.requestURL, req.requestURI, req.contextPath)}/" />
        <link rel="stylesheet" href="font/flaticon.css">
        <!-- Vinculamos con el estilo -->
        <link rel="stylesheet" href="css/estilo.css">
	<link rel="stylesheet" href="css/estilo_clubes.css">
	<link rel="stylesheet" href="css/estilo-items.css">
        
	<title>Clubes</title>
</head>
<body>
    
<jsp:include page="header.jsp"/>
<script type="text/javascript" src="js/clickItem.js"></script>

<div class="contenedor-principal">

    <div class="contenedor-izquierda">
        <div class="contenedor-busqueda">
            <div class="busqueda">
                <form action="" method="post">
                    <input type="text" placeholder="Buscar club por nombre" class="form-buscar-item input-busqueda" name="nombre_buscar">
                    <input type="submit" value="buscar" class="boton btn-buscar">
                </form>
            </div>
        </div>
        
        <div class="contenedor-lista">
            <% 
                for(Club club : clubes){
            %>
              
                <div class="item-group">
                    <div class="item" onclick="clickEnClub(<%= club.getId() %>)">
                        <div class="item-container">
                            <img src="img/img_clubes.png"
                                class="item-img">
                        </div>
                        <div class="item-textos">
                            <h2><%= club.getNombre() %></h2>
                            <p><br><%= club.getDireccion() %></p>
                        </div>
                    </div>
                </div>
                
            <%
                }// fin del foreach
            %>
        </div>
    </div>
        
    <script type="text/javascript">
        function clickEnClub(id_club){
            window.location="descripcion_club.jsp?id="+id_club;
        }
    </script>

    <div class="contenedor-derecha">
        

        <div class="contenedor-insertar-item">
            <div class="insertar-item">
                <form action="" method="post">
                    <h4>Nuevo Club</h4>
                    <hr>
                    <input type="text" class="input-insertar" name="codigo" placeholder="Codigo del club">
                    <input type="text" class="input-insertar" name="nombre" placeholder="Nombre del club">
                    <input type="text" class="input-insertar" name="direccion" placeholder="Direccion del club">

                    <input type="submit" class="input-insertar" value="Insertar" class="boton btn-insertar">
                </form>
                
            </div>
        </div>
    </div>

</div>


</body>
</html>
