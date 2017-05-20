<%@page import="java.util.List"%>
<%@page import="Modelos.Usuario"%>
<%@page import="Controladores.UsuarioController"%>
<%
    if ((session.getAttribute("idusuario") == null) || (session.getAttribute("idusuario") == "")) {
        response.sendRedirect("ingresar");
    }
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
	<title>Clubes</title>
</head>
<body>
    
<jsp:include page="header.jsp"/>

<div class="contenedor-principal">

    <div class="contenedor-izquierda">
        <div class="contenedor-busqueda">
            <div class="busqueda">
                <form action="" method="post">
                    <input type="text" placeholder="Buscar item" class="form-buscar-item input-busqueda" name="buscar_item">
                    <input type="submit" value="buscar" class="boton btn-buscar">
                </form>
            </div>
        </div>
        
        <div class="contenedor-lista">
            <% 
                List<Usuario> usuarios = UsuarioController.obtenerUsuarios();

                for(Usuario usuario : usuarios){
            %>
            <div class="item-group">
                <div class="item">
                    <div class="item-container">
                        <img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQOZqyOCKrRpzt7OwVXOi1yspqIigW0OEXIQAsxJPX5-avqv5mtj6Haog"
                            class="item-img">
                    </div>
                    <div class="item-textos">
                        <h2><%= usuario.getNombres() + " " + usuario.getApellidos() %></h2>
                        <p><%= usuario.getRol() %></p>
                    </div>
                </div>
            </div>
            <%
                }// fin del foreach
            %>
        </div>
    </div>

    <div class="contenedor-derecha">
        <div class="contenedor-filtros">
            <div class="filtros">
                <form action="" method="post">
                    <h4>Filtros</h4>
                    <hr> <!-- linea horizontal -->
                    <select name="municipio" id="selecteable">
                        <option selected value="0">Elige una opcion</option>
                        <option value="1">Municipio 1</option>
                        <option value="2">Municipio 2</option>
                        <option value="3">Municipio 3</option>
                    </select>
                    <input type="submit" class="input-insertar" value="Aplicar" class="boton btn-insertar">
                </form>
            </div>
        </div>

        <div class="contenedor-insertar-item">
            <div class="insertar-item">
                <form action="insertarItem.jsp" method="post">
                    <h4>Nuevo item</h4>
                    <hr>
                    <input type="text" class="input-insertar" name="codigo-item" placeholder="Codigo item">
                    <input type="text" class="input-insertar" name="nombre-item" placeholder="Nombre item">
                    <input type="text" class="input-insertar" name="descripcion-item" placeholder="Descripcion item">

                    <input type="submit" class="input-insertar" value="Insertar" class="boton btn-insertar">
                </form>
            </div>
        </div>
    </div>

</div>


</body>
</html>
