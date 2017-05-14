<%
session.setAttribute("idusuario", null);
session.invalidate();
response.sendRedirect("ingresar");
%>