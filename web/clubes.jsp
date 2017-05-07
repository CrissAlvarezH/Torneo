<%@page import="java.sql.SQLException"%>
<%@page import="Conexion.BDCrud"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Conexion.DBUtilidades"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="font/flaticon.css">
        <!-- Vinculamos con el estilo -->
        <link rel="stylesheet" href="css/estilo.css">
        <title>Clubes</title>
        
        <style>
            
            body {
                margin-top: 50px;
            }
            
            .item-group {
                display: flex;
                justify-content: center;
                padding-top: 20px;
            }

            .item {
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
                transition: 0.3s;
                border-radius: 5px;
                padding: 5px;
                width: 40%;
            }

            .item-container {
                padding-top: 2px;
                display: inline-block;
                width: 30%;
                vertical-align: middle;
            }

            .item-img {
                padding: 30px 10px;
                border-radius: 5px 5px 0 0;
                width: 70%;
            }

            .item:hover {
                box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
            }
        </style>
    </head>
    
        <jsp:include page="header.jsp"/>
        
        <%
            ResultSet result = null;
            try{
                result = new BDCrud().todosLosUsuarios();
            }catch(SQLException e){}
            
            while(result.next()){
        %>
            <a href="clubes.jsp">
                <div class="item-group">
                    <div class="item">
                        <div class="item-container">
                            <img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQOZqyOCKrRpzt7OwVXOi1yspqIigW0OEXIQAsxJPX5-avqv5mtj6Haog"
                                class="item-img">
                        </div>
                        <div class="item-container">
                            <h2><%= result.getString(2) %></h2>
                            <p><%= result.getString(3)  %></p>
                        </div>
                    </div>
                </div>
            </a>
        <%
            }// fin del while
        %>
    
</html>
