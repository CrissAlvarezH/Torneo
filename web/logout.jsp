<%
session.setAttribute("idusuario", null);
session.invalidate();
response.sendRedirect("login.jsp");
%>