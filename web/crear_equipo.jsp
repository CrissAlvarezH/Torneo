<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1">
        <link rel="stylesheet" href="css/crear_equipo/estilo-modal.css">
        <link rel="stylesheet" href="css/crear_equipo/estilo-formulario-modal.css">
        <link rel="stylesheet" href="css/crear_equipo/estilo-item-equipo.css">
    </head>

    <body>
        <input type="checkbox" id="cerrar">
        <label for="cerrar" id="btn-cerrar">Cerrar</label>
        <div class="modal">
            <div class="contenedor">
                <div class="contenedor-izquierda">
                    <div class="contenedor-inputs">
                        <input type="text" name="id_equipo" placeholder="ID del equipo" class="input-100" required>
                        <input type="text" name="nombre_equipo" placeholder="Nombre del equipo" class="input-100" required>
                        <input placeholder="Fecha actual" class="input-100" type="text" onfocus="(this.type='date')"  id="date" required>
                        <select name="disciplina" class="seleccion-100" required>
                            <option value="0_disciplina" disabled selected hidden>Escoja una disciplina</option>
                            <option value="1_disciplina">Disciplina 1</option>
                            <option value="2_disciplina">Disciplina 2</option>
                            <option value="3_disciplina">Disciplina 3</option>
                            <option value="4_disciplina">Disciplina 4</option>
                        </select>
                        <input type="submit" Value="Crear equipo" class="btn-enviar" required>
                    </div>
                </div>
                <hr class="linea-vertical">
                <div class="contenedor-derecha">

                    <div class="texto-centrado">
                      <h3 class="texto-sin-margin">Seleccione los participantes</h3>
                    </div>
                    <div class="contenedor-lista">
                        <div class="item-group">
                            <div class="item">
                                <div class="item-textos">
                                        <h4 class="text-item">Item numero 1</h4>
                                        <input type="checkbox" name="item1" value="Si" class="check">
                                        <p class="text-item id-participante">Descripcion</p>
                                </div>
                            </div>
                       </div>

                      </div>
                </div>
            </div>
        </div>
    </body>
</html>
