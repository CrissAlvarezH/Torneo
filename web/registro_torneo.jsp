<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Unisports - Register championship</title>
        <link rel="stylesheet" href="css/registro-torneo/estilo_registro_torneo.css">
    </head>
    <body>
        <h1>Formulario de registro de torneo</h1>
        <form action="participacion.jsp" method="post" class="form-registro">
            <h2 class="form__titulo"><font face="arial">REGISTRA UN TORNEO</font></h2>
            <div class="contenedor-inputs">
            <input type="text" name="nombre_torneo" placeholder="Nombre del torneo" class="input-48" required>
            <select name="categoria" class="seleccion-48" required>
                <option value="0_categoria" disabled selected hidden>Selecciona una categoria</option>
                <option value="1_categoria">Categoria 1</option>
                <option value="2_categoria">Categoria 2</option>
                <option value="3_categoria">Categoria 3</option>
                <option value="4_categoria">Categoria 4</option>
            </select>
            <select name="deporte" class="seleccion-100" required>
                <option value="0_deporte" disabled selected hidden>Selecciona un deporte</option>
                <option value="1_deporte">Futbol</option>
                <option value="2_deporte">Esqui</option>
                <option value="3_deporte">Ciclismo</option>
                <option value="4_deporte">Esgrima</option>
            </select>
            <select  name="organizador" class="seleccion-48" required>
                <option value="0_organizador" disabled selected hidden>Club organizador</option>
                <option value="1_organizador">-------</option>
                <option value="2_organizador">-------</option>
                <option value="3_organizador">-------</option>
                <option value="4_organizador">-------</option>
            </select>
            <input type="text" name="descripcion" placeholder="Descripcion" class="input-48" required>
            <input placeholder="Fecha de inicio" class="textbox-n" type="text" onfocus="(this.type='date')"  id="date" required>
            <input placeholder="Fecha de fin" class="textbox-n" type="text" onfocus="(this.type='date')"  id="date" required>
            </select>
            <input type="submit" Value="Registrar torneo" class="btn-enviar" required>
            </div>
        </form>
    </body>
</html>
