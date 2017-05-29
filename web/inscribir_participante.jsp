<!DOCTYPE html>
<html lang="es">
    <head>
       <meta charset="UTF-8">
       <meta name="viewport" content="width=device-width, user-scalable=no,  initial=scale=1, maxinum-scale=1, maxinum-scale=1">
       <link rel="stylesheet" href="css/inscribir-participante/estilo_ventana_participante.css">
        <link rel="stylesheet"href="css/inscribir-participante/estio_formulario_participante.css">
    </head>

    <body>

        <input type="checkbox" id="cerrar">
        <label for="cerrar" id="btn-cerrar">Cerrar</label>
        <div class="modal">
            <div class="contenido">
        <form action="participacion.jsp" method="post" class="form-registro">
            <h2 class="form__titulo"><font face="arial">INSCRIBE UN PARTICIPANTE</font></h2>
            <div class="contenedor-inputs">
            <input type="text" name="id_participante" placeholder="ID del participante" class="input-100" required>
            <input type="text" name="nombre_participante" placeholder="Nombres del participante" class="input-48" required>
            <input type="text" name="apellidos" placeholder="Apellidos del participante" class="input-48" required>
            <input type="number" name="edad" placeholder="edad" class="input-48" required>
            <select name="sexo" class="seleccion-48" required>
                <option value="0_sexo" disabled selected hidden>Selecciona sexo</option>
                <option value="1_sexo">Masculino</option>
                <option value="2_sexo">Femenino</option>
            </select>
            <input type="text" name="estatura" placeholder="Estatura" class="input-48" required>
            <input type="text" name="peso" placeholder="peso" class="input-48" required>
            </select>
            <input type="submit" Value="Inscribir participante" class="btn-enviar" required>
            </div>
             </form>
         </div>
     </div>
        <main>
            <h1>Ventana modal con HTML y CSS</h1><p>dmhufhscuhgucioxopWDJZIOWEJFOWHGOHO,XH,Ujofjw,fjiowxjfijjwfg,cjcgjriocjmiocehgcsahag,roxjrioe,jqjixjawjoecjhehcrojgiejrxjrjerjjgjcerjcjerjrjeiwjcivjejjeopecjpoj,chojpjixmurhehcrgiorcircigo</p>
        </main>

    </body>
</html>
