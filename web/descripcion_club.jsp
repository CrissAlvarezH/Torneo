
<%@page import="Controladores.ParticipanteController"%>
<%@page import="Controladores.EquipoController"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.*"%>
<%@page import="Controladores.ClubController"%>
<%
    if ((session.getAttribute("idusuario") == null) || (session.getAttribute("idusuario") == "")) {
        response.sendRedirect("ingresar");
    }
    
    int id_club = Integer.parseInt(request.getParameter("id"));
    
    Club club = ClubController.obtenerClub(id_club);
    List<Equipo> equipos = EquipoController.obtenerEquipos(id_club);
    List<Participante> participantes = ParticipanteController.obtenerParticipantesDeUnClub(id_club);
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="css/descripcion-club/estilo_descripcion_club.css">
	<link rel="stylesheet" href="css/descripcion-club/estilo-items-clubs.css">
 
	<title>Club</title>
</head>
<body>
    
<jsp:include page="header.jsp"/>

<div class="contenedor-superior">
	<div class="contenedor-izq">
		<h2 class="nombre"><%= club.getNombre() %></h2>

		<div class="texto-club">
			<h4>Id <%= club.getId() %></h4>
			<h4>Direccion <%= club.getDireccion() %></h4>
		</div>
	</div>

	<div class="contenedor-derecha">
		<div class="contenedor-botones">
			<div class="botones">
				<input type="button" onclick="clickEnInscribirParticipante(<%= club.getId() %>)" class="btn-derecha" value="Inscribir Paricipante">
                                <input type="button" onclick="clickEnFormarEquipo(<%= club.getId() %>)" class="btn-derecha" value="Formar Equipo">
			</div>
		</div>
	</div>
        
        <script type="text/javascript">
            function clickEnInscribirParticipante(id_club){
                window.location="inscribir_participante.jsp?id="+id_club;
            }
            
            function clickEnFormarEquipo(id_club){
                window.location="crear_equipo.jsp?id="+id_club;
            }
            
            function clickEnEquipo(id_equipo, id_club){
                window.location="info_equipo.jsp?id="+id_equipo+"&club="+id_club;
            }
        </script>                
</div>

<div class="contenedor-inferior">
	<div class="contenedor-equipos">

            <div class="contenedor-izquierda">
                <!--<div class="contenedor-busqueda">
                    <div class="busqueda">
                        <form action="" method="post">
                            <input type="text" placeholder="Buscar item" class="form-buscar-item input-busqueda" name="buscar_item">
                            <input type="submit" value="buscar" class="boton btn-buscar">
                        </form>
                    </div>
                </div>-->
                
                <div class="contenedor-busqueda">
                    <h2>Equipos</h2>
                </div>

                <div class="contenedor-lista">
                    <%
                        for(Equipo equipo : equipos){
                    %>
                    
                    <div class="item-group" onclick="clickEnEquipo(<%= equipo.getId()%>, <%= club.getId() %>)">
                            <div class="item">
                                <div class="item-container">
                                    <img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQOZqyOCKrRpzt7OwVXOi1yspqIigW0OEXIQAsxJPX5-avqv5mtj6Haog"
                                                    class="item-img">
                                </div>
                                <div class="item-textos">
                                    <h2><%= equipo.getNombre() %></h2>
                                    <br>
                                    <p>Id: <%= equipo.getId() %></p>
                                </div>
                            </div>
                        </div>
                    <%
                        }// fin del foreach
                    %>
                </div>
            </div>
	</div>

	<div class="contenedor-participantes">
		<div class="contenedor-izquierda">
			<!--<div class="contenedor-busqueda">
				<div class="busqueda">
					<form action="" method="post">
						<input type="text" placeholder="Buscar item" class="form-buscar-item input-busqueda" name="buscar_item">
						<input type="submit" value="buscar" class="boton btn-buscar">
					</form>
				</div>
			</div>-->
                        <div class="contenedor-busqueda">
                            <h2>Participantes</h2>
                        </div>

	<div class="contenedor-lista">
            <%
                for(Participante participante : participantes){
            %>
            <div class="item-group">
                <div class="item">
                    <div class="item-container">
                        <img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQOZqyOCKrRpzt7OwVXOi1yspqIigW0OEXIQAsxJPX5-avqv5mtj6Haog"
                                        class="item-img">
                    </div>
                    <div class="item-textos">
                        <h2><%= participante.getNombres()+" "+participante.getApellidos() %> </h2>
                        <br>
                        <p>Edad: <%= participante.getEdad() %></p>
                    </div>
                </div>
            </div>
            <%
                }// fin de foreach
            %>
	</div>
</div>

</body>
</html>
