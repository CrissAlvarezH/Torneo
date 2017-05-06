<%@page import="Conexion.DBUtilidades"%>
<%

String id = request.getParameter("id_usuario");
String pass = request.getParameter("pass_usuario");

if(new DBUtilidades().validarUsuario(Integer.parseInt(id), pass)){
    response.sendRedirect("http://localhost:8081/Torneos/pagina_principal/principal.html");
}else{
    response.sendRedirect("http://localhost:8081/Torneos/index.jsp?p=si");
}

%>
