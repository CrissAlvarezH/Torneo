/*
 * Clase creada con el unico objetido de hacer operaciones de INSERT, DELETE
 * y UPDATE en las tablas de la base de datos.
 */
package Conexion;

import Modelos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CristianAlvarez
 */
public class BDCrud {

    private static final Connection conexion = Conector.getConexion();
    private static PreparedStatement sentenciaPreparada;

    
    public static ResultSet ejecutarConsulta(String sql) throws SQLException{
       
        return sentenciaPreparada.executeQuery(sql);
    }
    
    /**
     * ******* METODOS PARA INSERTAR REGISTROS EN LAS ENTIDADES ************
     */
    
    
    /**
     * Usuario es creado para manejar la plataforma dependiendo del rol
     *
     * @param usuario
     * @return
     * @throws SQLException
     */
    public static boolean insertarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, usuario.getId());
            sentenciaPreparada.setString(2, usuario.getNombres());
            sentenciaPreparada.setString(3, usuario.getApellidos());
            sentenciaPreparada.setString(4, usuario.getSexo());
            sentenciaPreparada.setString(5, usuario.getRol());
            sentenciaPreparada.setString(6, usuario.getPass());
            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;

    }

    public static boolean insertarClub(Club club) throws SQLException {
        String sql = "INSERT INTO club VALUES (?, ?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, club.getId());
            sentenciaPreparada.setString(2, club.getNombre());
            sentenciaPreparada.setString(3, club.getDireccion());
            sentenciaPreparada.setInt(4, club.getId_municipio());
            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean insertarCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria VALUES (?, ?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, categoria.getId());
            sentenciaPreparada.setString(2, categoria.getTipo());
            sentenciaPreparada.setString(3, categoria.getDescripcion());
            sentenciaPreparada.setString(4, categoria.getGenero());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean insertarDisciplina(Disciplina disciplina) throws SQLException {
        String sql = "INSERT INTO disciplina VALUES (?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, disciplina.getId());
            sentenciaPreparada.setString(2, disciplina.getNombre());
            sentenciaPreparada.setString(3, disciplina.getDescripcion());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean insertarEncuentro(Encuentro encuentro) throws SQLException {
        String sql = "INSERT INTO encuentro VALUES (?, ?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, encuentro.getId());
            sentenciaPreparada.setString(2, encuentro.getUbicacion());
            sentenciaPreparada.setString(3, encuentro.getFecha());
            sentenciaPreparada.setString(4, encuentro.getHora());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean insertarEquipo(Equipo equipo) throws SQLException {
        String sql = "INSERT INTO equipo VALUES (?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, equipo.getId());
            sentenciaPreparada.setString(2, equipo.getNombre());
            sentenciaPreparada.setString(3, equipo.getFecha_fundacion());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean insertarMunicipio(Municipio municipio) throws SQLException {
        String sql = "INSERT INTO municipio VALUES (?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, municipio.getId());
            sentenciaPreparada.setString(2, municipio.getNombre());
            sentenciaPreparada.setString(3, municipio.getDepartamento());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;

    }

    public static boolean insertarParticipacion(Participacion participacion)
            throws SQLException {
        String sql = "INSERT INTO participacion VALUES (?, ?, ?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, participacion.getId());
            sentenciaPreparada.setString(2, participacion.getTipo());
            sentenciaPreparada.setString(3, participacion.getDescripcion());
            sentenciaPreparada.setString(4, participacion.getFecha());
            sentenciaPreparada.setString(5, participacion.getHora());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean insertarParticipante(Participante participante)
            throws SQLException {
        String sql = "INSERT INTO participante VALUES (?, ?, ?, ?, ?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, participante.getId());
            sentenciaPreparada.setString(2, participante.getNombres());
            sentenciaPreparada.setString(3, participante.getApellidos());
            sentenciaPreparada.setInt(4, participante.getEdad());
            sentenciaPreparada.setString(5, participante.getSexo());
            sentenciaPreparada.setFloat(6, participante.getEstatura());
            sentenciaPreparada.setFloat(7, participante.getPeso());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;

    }

    public static boolean insertarPenalizacion(Penalizacion penalizacion)
            throws SQLException {
        String sql = "INSERT INTO penalizacion VALUES (?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, penalizacion.getId());
            sentenciaPreparada.setString(2, penalizacion.getTipo());
            sentenciaPreparada.setString(3, penalizacion.getDescripcion());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;

    }

    public static boolean insertarTorneo(Torneo torneo) throws SQLException {
        String sql = "INSERT INTO torneo VALUES (?, ?, ?, ?, ?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, torneo.getId());
            sentenciaPreparada.setString(2, torneo.getNombre());
            sentenciaPreparada.setString(3, torneo.getFecha_inicio());
            sentenciaPreparada.setString(4, torneo.getFecha_fin());
            sentenciaPreparada.setString(5, torneo.getDescripcion());
            sentenciaPreparada.setInt(6, torneo.getId_disciplina());
            sentenciaPreparada.setInt(7, torneo.getId_categoria());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    // Como las entidades hijas no tienen campos propios insertamos directamente
    // en la tabla torneos
    public static boolean insertarTorneoColectivoConOposicion(Torneo torneo)
            throws SQLException {

        // insertamos en la tabla hija torneo_colectivo
        String sql_colectivo = "INSERT INTO torneo_colectivo VALUES (?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql_colectivo);
            sentenciaPreparada.setInt(1, torneo.getId());

            if (sentenciaPreparada.executeUpdate() == 1) {
                // tambien en la subhija de colectivo: con oposicion 
                String sql = "INSERT INTO torneo_colectivo_con_oposicion VALUES (?);";

                sentenciaPreparada = conexion.prepareStatement(sql);
                sentenciaPreparada.setInt(1, torneo.getId());

                if (sentenciaPreparada.executeUpdate() == 1) {
                    // luego en la tabla padre
                    return insertarTorneo(torneo);
                }

            }
        }

        return false;

    }

    public static boolean insertarTorneoColectivoSinOposicion(Torneo torneo)
            throws SQLException {

        // insertamos en la tabla hija torneo_colectivo
        String sql_colectivo = "INSERT INTO torneo_colectivo VALUES (?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql_colectivo);
            sentenciaPreparada.setInt(1, torneo.getId());

            if (sentenciaPreparada.executeUpdate() == 1) {

                // tambien en la subhija de colectivo: sin oposicion 
                String sql = "INSERT INTO torneo_colectivo_sin_oposicion VALUES (?);";

                sentenciaPreparada = conexion.prepareStatement(sql);
                sentenciaPreparada.setInt(1, torneo.getId());

                if (sentenciaPreparada.executeUpdate() == 1) {
                    // luego en la tabla padre
                    return insertarTorneo(torneo);

                }

            }

        }

        return false;
    }

    public static boolean insertarTorneoIndividualConEnfrentamiento(Torneo torneo)
            throws SQLException {

        // insertamos en la tabla hija torneo_individual
        String sql_colectivo = "INSERT INTO torneo_individual VALUES (?);";

        if (conexion != null) {

            sentenciaPreparada = conexion.prepareStatement(sql_colectivo);
            sentenciaPreparada.setInt(1, torneo.getId());

            if (sentenciaPreparada.executeUpdate() == 1) {

                // tambien en la subhija de indidual: con enfrentamiento 
                String sql = "INSERT INTO torneo_individual_con_enfrentamiento VALUES (?);";

                sentenciaPreparada = conexion.prepareStatement(sql);
                sentenciaPreparada.setInt(1, torneo.getId());

                if (sentenciaPreparada.executeUpdate() == 1) {
                    // luego en la tabla padre
                    return insertarTorneo(torneo);
                }

            }

        }

        return false;

    }

    public static boolean insertarTorneoIndividualSinEnfrentamiento(Torneo torneo)
            throws SQLException {

        // insertamos en la tabla hija torneo_individual
        String sql_colectivo = "INSERT INTO torneo_individual VALUES (?);";

        if (conexion != null) {

            sentenciaPreparada = conexion.prepareStatement(sql_colectivo);
            sentenciaPreparada.setInt(1, torneo.getId());

            if (sentenciaPreparada.executeUpdate() == 1) {
                // tambien en la subhija de indidual: sin enfrentamiento 
                String sql = "INSERT INTO torneo_individual_sin_enfrentamiento VALUES (?);";

                sentenciaPreparada = conexion.prepareStatement(sql);
                sentenciaPreparada.setInt(1, torneo.getId());

                if (sentenciaPreparada.executeUpdate() == 1) {
                    // luego en la tabla padre
                    return insertarTorneo(torneo);
                }

            }

        }
        return false;
    }

    /**
     * *********************************************************************
     */
    /**
     * ******** METODOS PARA INSERTAR REGISTROS EN LAS RELACIONES **********
     */
    /**
     * Metodo encargado de inscribir un participante en un equipo
     *
     * @param id_participante
     * @param id_equipo
     * @param cargo es el cargo del participante en el equipo (capitan, jugador)
     * @param posicion es en que numero o posicion juega el participante
     * @return
     * @throws java.sql.SQLException Error al preparar la sentencia
     */
    public static boolean participanteEquipo(int id_participante, int id_equipo,
            String cargo, String posicion)
            throws SQLException {

        String sql = "INSERT INTO participante_equipo VALUES (?, ?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_participante);
            sentenciaPreparada.setInt(2, id_equipo);
            sentenciaPreparada.setString(3, cargo);
            sentenciaPreparada.setString(4, posicion);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    // Insertamos el resultado de un encuentro entre participantes
    public static boolean participanteEncuentro(int id_participante, int id_encuentro, int puntos)
            throws SQLException {
        String sql = "INSERT INTO participante_encuentro VALUES (?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_participante);
            sentenciaPreparada.setInt(2, id_encuentro);
            sentenciaPreparada.setInt(3, puntos);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    // Incribimos un participante en una disciplina
    public static boolean participanteDisciplina(int id_participante, int id_disciplina)
            throws SQLException {

        String sql = "INSERT INTO participante_disciplina VALUES (?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_participante);
            sentenciaPreparada.setInt(2, id_disciplina);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;

    }

    // Relacionamos un participante con una categoria
    public static boolean participanteCategoria(int id_participante, int id_categoria)
            throws SQLException {

        String sql = "INSERT INTO participante_categoria VALUES (?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_participante);
            sentenciaPreparada.setInt(2, id_categoria);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    /**
     * Cuando un participante realiza su demostracion y recibe una valoracion
     *
     * @param id_participante
     * @param id_participacion
     * @param valoracion son los puntos que recibe el participante
     * @throws SQLException
     */
    public static boolean participanteParticipacion(int id_participante,
            int id_participacion, int valoracion)
            throws SQLException {

        String sql = "INSERT INTO participante_participacion VALUES (?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_participante);
            sentenciaPreparada.setInt(2, id_participacion);
            sentenciaPreparada.setInt(3, valoracion);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    // cada participante esta 'inscrito' en un club
    public static boolean participanteClub(int id_participante, int id_club)
            throws SQLException {

        String sql = "INSERT INTO participante_club VALUES (?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_participante);
            sentenciaPreparada.setInt(2, id_club);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    // relacionamos participante y penalizacion
    public static boolean participantePenalizacion(int id_participante, int id_penalizacion)
            throws SQLException {

        String sql = "INSERT INTO participante_penalizacion VALUES (?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_participante);
            sentenciaPreparada.setInt(2, id_penalizacion);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;

    }

    // Inscribimos una disciplina en un club
    public static boolean disciplinaClub(int id_disciplina, int id_club)
            throws SQLException {

        String sql = "INSERT INTO disciplina_club VALUES (?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_disciplina);
            sentenciaPreparada.setInt(2, id_club);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;

    }

    // Las disciplinas que hay en un municipio
    public static boolean disciplinaMunicipio(int id_disciplina, int id_municipio)
            throws SQLException {

        String sql = "INSERT INTO disciplina_municipio VALUES (?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_disciplina);
            sentenciaPreparada.setInt(2, id_municipio);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    /**
     * Inscribimos un club en un torneo
     *
     * @param cargo es el papel del club en el torneo (organizador, visitante)
     * @param id_club identificador del club
     * @param id_torneo torneo al cual se va a inscribir el club
     * @throws java.sql.SQLException
     */
    public static boolean clubTorneo(int id_club, int id_torneo, String cargo)
            throws SQLException {

        String sql = "INSERT INTO club_torneo VALUES (?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_club);
            sentenciaPreparada.setInt(2, id_torneo);
            sentenciaPreparada.setString(3, cargo);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    /**
     * Para cuando se lleva a cabo un encuentro
     *
     * @param id_equipo es uno de los dos equipos que se estan enfrentando
     * @param id_encuentro
     * @param puntos esto depende del deponte (goles, canastas, etc..)
     * @throws SQLException
     */
    public static boolean equipoEncuentro(int id_equipo, int id_encuentro, int puntos)
            throws SQLException {

        String sql = "INSERT INTO equipo_encuentro VALUES (?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_equipo);
            sentenciaPreparada.setInt(2, id_encuentro);
            sentenciaPreparada.setInt(3, puntos);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    /**
     * Cuando se lleva a cabo una participacion de un equipo
     *
     * @param id_equipo
     * @param id_participacion
     * @param valoracion esto será la valoracion, puntos, o como se defina segun
     * el deporte
     * @throws SQLException
     */
    public static boolean equipoParticipacion(int id_equipo, int id_participacion, int valoracion)
            throws SQLException {

        String sql = "INSERT INTO equipo_participacion VALUES (?, ?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_equipo);
            sentenciaPreparada.setInt(2, id_participacion);
            sentenciaPreparada.setInt(3, valoracion);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    // Relacion entre equipo y disciplina
    public static boolean equipoDisciplina(int id_equipo, int id_disciplina)
            throws SQLException {

        String sql = "INSERT INTO equipo_disciplina VALUES (?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_equipo);
            sentenciaPreparada.setInt(2, id_disciplina);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    // relacionamos a equipo con torneo_colectivo
    public static boolean equipoTorneoColectivo(int id_equipo, int id_torneo_colectivo)
            throws SQLException {

        String sql = "INSERT INTO equipo_torneo_colectivo VALUES (?, ?);";

        if (conexion != null) {

            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_equipo);
            sentenciaPreparada.setInt(2, id_torneo_colectivo);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    // relacion entre equipo y penalizacion (solo estos dos)
    public static boolean equipoPenalizacion(int id_equipo, int id_penalizacion)
            throws SQLException {

        String sql = "INSERT INTO equipo_penalizacion VALUES (?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_equipo);
            sentenciaPreparada.setInt(2, id_penalizacion);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    // relacionamos equipo con club (los clubs forman los equipos)
    public static boolean equipoClub(int id_equipo, int id_club) throws SQLException {
        String sql = "INSERT INTO equipo_club VALUES (?, ?);";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_equipo);
            sentenciaPreparada.setInt(2, id_club);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;

    }
    
    // relacionamos encuentro con torneo
    public static boolean encuentroTorneo(int id_encuentro, int id_torneo)
                    throws SQLException{
        String sql = "INSERT INTO encuentro_torneo VALUES(?, ?);";
        
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_encuentro);
            sentenciaPreparada.setInt(2, id_torneo);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }
    
    // relacionamos particiapcion con torneo
    public static boolean participacionTorneo(int id_participacion, int id_torneo)
                    throws SQLException{
        String sql = "INSERT INTO participacion_torneo VALUES(?, ?);";
        
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_participacion);
            sentenciaPreparada.setInt(2, id_torneo);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    /**
     * *********************************************************************
     */
    /**
     * ******** METODOS PARA ELIMINAR REGISTROS EN LAS ENTIDADES **********
     */
    public static boolean eliminarUsuario(int id_usuario) throws SQLException {
        String sql = "DELECT FROM usuario WHERE id_usuario=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_usuario);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    public static boolean eliminarEquipo(int id_equipo) throws SQLException {
        String sql = "DELECT FROM equipo WHERE id_equipo=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_equipo);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    public static boolean eliminarMunicipio(int id_municipio) throws SQLException {
        String sql = "DELECT FROM municipio WHERE id_municipio=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_municipio);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    public static boolean eliminarDisciplina(int id_disciplina) throws SQLException {
        String sql = "DELECT FROM disciplina WHERE id_disciplina=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_disciplina);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean eliminarCategoria(int id_categoria) throws SQLException {
        String sql = "DELECT FROM categoria WHERE id_categoria=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_categoria);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    public static boolean eliminarClub(int id_club) throws SQLException {
        String sql = "DELECT FROM club WHERE id_club=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_club);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    public static boolean eliminarEncuentro(int id_encuentro) throws SQLException {
        String sql = "DELECT FROM encuentro WHERE id_encuentro=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_encuentro);

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    public static boolean eliminarParticipacion(int id_participacion) throws SQLException {
        String sql = "DELECT FROM participacion WHERE id_participacion=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_participacion);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean eliminarParticipante(int id_participante) throws SQLException {
        String sql = "DELECT FROM participante WHERE id_participante=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_participante);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean eliminarPenalizacion(int id_penalizacion) throws SQLException {
        String sql = "DELECT FROM penalizacion WHERE id_penalizacion=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_penalizacion);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean eliminarTorneo(int id_torneo) throws SQLException {
        String sql = "DELECT FROM torneo WHERE id_torneo=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_torneo);

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;

    }

    /**
     * *********************************************************************
     */
    /**
     * ******** METODOS PARA MODFICIAR REGISTROS EN LAS ENTIDADES **********
     */
    public static boolean modificarUuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nombres_usuario=?, apellidos_usuario=?,"
                + " sexo_usuario=?, roll_usuario=?, pass_usuario=?"
                + "WHERE id_usuario=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setString(1, usuario.getNombres());
            sentenciaPreparada.setString(2, usuario.getApellidos());
            sentenciaPreparada.setString(3, usuario.getSexo());
            sentenciaPreparada.setString(4, usuario.getRol());
            sentenciaPreparada.setString(5, usuario.getPass());
            sentenciaPreparada.setInt(6, usuario.getId());

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    public static boolean modificarCategoria(Categoria categoria) throws SQLException {
        String sql = "UPDATE categoria SET tipo_categoria=?, "
                + "descripcion_categoria=?, genero_categoria=? "
                + "WHERE id_categoria=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setString(1, categoria.getTipo());
            sentenciaPreparada.setString(2, categoria.getDescripcion());
            sentenciaPreparada.setString(3, categoria.getGenero());
            sentenciaPreparada.setInt(4, categoria.getId());
            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;

    }

    public static boolean modificarClub(Club club) throws SQLException {
        String sql = "UPDATE club SET nombre_club=?, direccion_club=? "
                + "WHERE id_club=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setString(1, club.getNombre());
            sentenciaPreparada.setString(2, club.getDireccion());
            sentenciaPreparada.setInt(3, club.getId());

            return sentenciaPreparada.executeUpdate() == 1;

        }

        return false;
    }

    public static boolean modificarDisciplina(Disciplina disciplina) throws SQLException {
        String sql = "UPDATE disciplina SET nombre_disciplina=?,"
                + " descripcion_disciplina=? "
                + "WHERE id_disciplina=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setString(1, disciplina.getNombre());
            sentenciaPreparada.setString(2, disciplina.getDescripcion());
            sentenciaPreparada.setInt(3, disciplina.getId());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean modificarEncuentro(Encuentro encuentro) throws SQLException {
        String sql = "UPDATE encuentro SET ubicacion_encuentro=?,"
                + " fecha_encuentro=?, hora_encuentro=? "
                + "WHERE id_encuentro=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setString(1, encuentro.getUbicacion());
            sentenciaPreparada.setString(2, encuentro.getFecha());
            sentenciaPreparada.setString(3, encuentro.getHora());
            sentenciaPreparada.setInt(4, encuentro.getId());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean modificarEquipo(Equipo equipo) throws SQLException {
        String sql = "UPDATE equipo SET nombre_equipo=?, fecha_fundacion=? "
                + "WHERE id_equipo=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setString(1, equipo.getNombre());
            sentenciaPreparada.setString(2, equipo.getFecha_fundacion());
            sentenciaPreparada.setInt(3, equipo.getId());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean modificarMunicipio(Municipio municipio) throws SQLException {
        String sql = "UPDATE municipio SET nombre_municipio=?, "
                + "departamento_municipio=? "
                + "WHERE id_municipio=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setString(1, municipio.getNombre());
            sentenciaPreparada.setString(2, municipio.getDepartamento());
            sentenciaPreparada.setInt(3, municipio.getId());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean modificarParticipacion(Participacion participacion)
            throws SQLException {

        String sql = "UPDATE participacion SET tipo_participacion=?,"
                + " descripcion_participacion=?, fecha_participacion=?, "
                + "hora_participacion=? "
                + "WHERE id_participacion=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setString(1, participacion.getTipo());
            sentenciaPreparada.setString(2, participacion.getDescripcion());
            sentenciaPreparada.setString(3, participacion.getFecha());
            sentenciaPreparada.setString(4, participacion.getHora());
            sentenciaPreparada.setInt(5, participacion.getId());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean modificarParticipante(Participante participante)
            throws SQLException {

        String sql = "UPDATE participante SET nombre_participante=?, "
                + "apellidos_participante=?, edad_participante=?, "
                + "sexo_participante=?, estatura_participante=?, "
                + "peso_participante=? "
                + "WHERE id_participante=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setString(1, participante.getNombres());
            sentenciaPreparada.setString(2, participante.getApellidos());
            sentenciaPreparada.setInt(3, participante.getEdad());
            sentenciaPreparada.setString(4, participante.getSexo());
            sentenciaPreparada.setFloat(5, participante.getEstatura());
            sentenciaPreparada.setFloat(6, participante.getPeso());
            sentenciaPreparada.setInt(7, participante.getId());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean modificarPenalizacion(Penalizacion penalizacion)
            throws SQLException {

        String sql = "UPDATE penalizacion SET tipo_penalizacion=?,"
                + "descripcion_penalizacion=? WHERE id_penalizacion=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setString(1, penalizacion.getTipo());
            sentenciaPreparada.setString(2, penalizacion.getDescripcion());
            sentenciaPreparada.setInt(3, penalizacion.getId());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    public static boolean modificarTorneo(Torneo torneo) throws SQLException {
        String sql = "UPDATE torneo SET nombre_torneo=?, fecha_inicio=?, "
                + "fecha_fin=?, descripcion_torneo=?, id_disciplina_torneo=?,"
                + "id_categoria_torneo=?"
                + "WHERE id_torneo=?;";

        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setString(1, torneo.getNombre());
            sentenciaPreparada.setString(2, torneo.getFecha_inicio());
            sentenciaPreparada.setString(3, torneo.getFecha_fin());
            sentenciaPreparada.setString(4, torneo.getDescripcion());
            sentenciaPreparada.setInt(5, torneo.getId_disciplina());
            sentenciaPreparada.setInt(6, torneo.getId_categoria());
            sentenciaPreparada.setInt(7, torneo.getId());

            return sentenciaPreparada.executeUpdate() == 1;
        }

        return false;
    }

    /**
     * *********************************************************************
     */
    /**
     * ******** METODOS PARA SELECCIONAR REGISTROS EN LAS ENTIDADES
     *
     * @return
     * @throws java.sql.SQLException  **********
     */
    public static ResultSet todosLosUsuarios() throws SQLException {
        String sql = "SELECT * FROM usuario ;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }

    public ResultSet seleccionarUsuarioPorId(int id_usuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id_usuario=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_usuario);

            resultado = sentenciaPreparada.executeQuery();

        }

        return resultado;
    }

    public ResultSet seleccionarClubPorId(int id_club) throws SQLException {
        String sql = "SELECT * FROM club WHERE id_club=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_club);

            resultado = sentenciaPreparada.executeQuery();

        }

        return resultado;
    }

    public ResultSet seleccionarCategoriaPorId(int id_categoria) throws SQLException {
        String sql = "SELECT * FROM categoria WHERE id_categoria=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_categoria);

            resultado = sentenciaPreparada.executeQuery();

        }

        return resultado;
    }

    public ResultSet seleccionarDisciplinaPorId(int id_disciplina) throws SQLException {
        String sql = "SELECT * FROM disciplina WHERE id_disciplina=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_disciplina);

            resultado = sentenciaPreparada.executeQuery();

        }

        return resultado;
    }

    public ResultSet seleccionarEncuentroPorId(int id_encuentro) throws SQLException {
        String sql = "SELECT * FROM encuentro WHERE id_encuentro=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_encuentro);

            resultado = sentenciaPreparada.executeQuery();

        }

        return resultado;
    }

    public ResultSet seleccionarEquipoPorId(int id_equipo) throws SQLException {
        String sql = "SELECT * FROM equipo WHERE id_equipo=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_equipo);

            resultado = sentenciaPreparada.executeQuery();

        }

        return resultado;
    }
    
    public static ResultSet seleccionarMunicipioPorId(int id_municipio) throws SQLException {
        String sql = "SELECT * FROM municipio WHERE id_municipio=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_municipio);

            resultado = sentenciaPreparada.executeQuery();

        }

        return resultado;
    }

    public ResultSet seleccionarParticupacionPorId(int id_participacion) throws SQLException {
        String sql = "SELECT * FROM participacion WHERE id_participacion=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_participacion);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }

    public ResultSet seleccionarParticipantePorId(int id_participante) throws SQLException {
        String sql = "SELECT * FROM participante WHERE id_participante=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_participante);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }

    public ResultSet seleccionarPenalizacionPorId(int id_penalizacion) throws SQLException {
        String sql = "SELECT * FROM penalizacion WHERE id_penalizacion=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_penalizacion);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }

    public ResultSet seleccionarTorneoPorId(int id_torneo) throws SQLException {
        String sql = "SELECT * FROM torneo WHERE id_torneo=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_torneo);

            resultado = sentenciaPreparada.executeQuery();

        }

        return resultado;
    }

    /**
     * *********************************************************************
     */
    public void cerrarSentencia() throws SQLException {
        if (conexion != null) {
            sentenciaPreparada.close();
        }
    }
}
