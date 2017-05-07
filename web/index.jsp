<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if ((session.getAttribute("idusuario") == null) || (session.getAttribute("idusuario") == "")) {
        response.sendRedirect("ingresar");
    }
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Mis clubs</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1, minimun-scale=1">
        <!-- Llamamos a los iconos -->
        <link rel="stylesheet" href="font/flaticon.css">
        <!-- Vinculamos con el estilo -->
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <main>
            <section id="banner">
                <img src="img/banner.jpg">
                <div class="contenedor">
                    <h2>Deportes y clubes municipales </h2>
                    <p>¿Cual es el mejor club para ti?</p>
                <a href="#">Leer más</a>
                </div>
            </section>
            
            <section id="Bienvenidos">
                <h2>Bienvendios a nuestro sitio web</h2>
                <p>Aqui podras...</p>
            </section>
            <section id="blog">
                <h3>Lo ultimo de nuestro blog</h3>
                <div class="contenedor">
                    <article>
                        <img src="img/Noticia1.jpg">
                        <h4>Jaguares y Patriotas no se hicieron daño e igualaron a un gol</h4>
                    </article>
                    <article>
                        <img src="img/Noticia2.jpg">
                        <h4>Abiertas las inscripciones para la carrera 10k Montería Verde</h4>
                    </article>
                    <article>
                        <img src="img/Noticia3.jpg">
                        <h4>Karateka monteriana obtuvo importante cupo a los Juegos Olímpicos de la Juventud 2018</h4>
                    </article>
                </div>
            </section>
            <section id="info">
                <h3>Lo que sea</h3>
                <div class="contenedor">
                    <div class="info-sport">
                        <img src="img/imagen1.png" alt="">
                        <h4>Competencia</h4>
                    </div>
                    <div class="info-sport">
                        <img src="img/imagen2.png" alt="">
                        <h4>Esfuerzo</h4>
                    </div>
                    <div class="info-sport">
                        <img src="img/imagen3.jpg" alt="">
                        <h4>Compañerismo</h4>
                    </div>
                    <div class="info-sport">
                        <img src="img/imagen4.jpg" alt="">
                        <h4>Meditacion</h4>
                    </div>
                </div>
            </section>
        </main>
        <footer>
            <div class="contenedor">
                <p class="copy">Club &copy; 2017</p>
                <div class="sociales">
                    <a class="flaticon-facebook-logo" href="#"></a>
                    <a class="flaticon-twitter-logo-on-black-background" href="#"></a>
                    <a class="flaticon-instagram-logo" href="#"></a>
                    <a class="flaticon-facebook-logo" href="#"></a>
                </div>
            </div>
        </footer>
    </body>
</html>