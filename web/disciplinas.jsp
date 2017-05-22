<%@page import="Controladores.*"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.*"%>
<%@page import="Controladores.UsuarioController"%>
<%
    if ((session.getAttribute("idusuario") == null) || (session.getAttribute("idusuario") == "")) {
        response.sendRedirect("ingresar");
    }
    
    int id_municipio = Integer.parseInt(request.getParameter("id"));
    
    if(request.getParameter("codigo") != null)
        DisciplinaController.insertarDisciplinaDeMunicipio(request, id_municipio);
    
    List<Disciplina> disciplinas = DisciplinaController.buscarDisciplinaPorNombre(request, id_municipio);
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1, minimun-scale=1">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
        
        <link rel="stylesheet" href="font/flaticon.css">
        <!-- Vinculamos con el estilo -->
        <link rel="stylesheet" href="css/estilo.css">
	<link rel="stylesheet" href="css/estilo_clubes.css">
	<link rel="stylesheet" href="css/estilo-items.css">
        
	<title>Diciplinas</title>
</head>
<body>
    
<jsp:include page="header.jsp"/>
<script type="text/javascript" src="js/clickItem.js"></script>

<div class="contenedor-principal">

    <div class="contenedor-izquierda">
        <div class="contenedor-busqueda">
            <div class="busqueda">
                <form action="" method="post">
                    <input type="text" placeholder="Buscar disciplina por nombre" class="form-buscar-item input-busqueda" name="nombre_buscar">
                    <input type="submit" value="buscar" class="boton btn-buscar">
                </form>
            </div>
        </div>
        
        <div class="contenedor-lista">
            <% 
                for(Disciplina disciplina : disciplinas){
            %>
              
                <div class="item-group">
                    <div class="item" onclick="clickEnMunicipio(<%= disciplina.getId() %>)">
                        <div class="item-container">
                            <img src="img/img_disciplina.png"
                                class="item-img">
                        </div>
                        <div class="item-textos">
                            <h2><%= disciplina.getNombre() %></h2>
                            <p><br><%= disciplina.getDescripcion() %></p>
                        </div>
                    </div>
                </div>
                
            <%
                }// fin del foreach
            %>
        </div>
    </div>

    <div class="contenedor-derecha">
        

        <div class="contenedor-insertar-item">
            <div class="insertar-item">
                <form action="" method="post">
                    <h4>Nueva Disciplina</h4>
                    <hr>
                    <input type="text" class="input-insertar" name="codigo" placeholder="Codigo de la disciplina">
                    <input type="text" class="input-insertar" name="nombre" placeholder="Nombre de la disciplina">
                    <input type="text" class="input-insertar" name="descripcion" placeholder="Descripcion de la disciplina">

                    <input type="submit" class="input-insertar" value="Insertar" class="boton btn-insertar">
                </form>
                
            </div>
        </div>
    </div>

</div>


</body>
</html>
