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
    private Connection conexion;
    private PreparedStatement sentenciaPreparada;
    
    public BDCrud(){
        conexion = Conector.getConexion();
        sentenciaPreparada = null;
    }
    
    /********* METODOS PARA INSERTAR REGISTROS EN LAS ENTIDADES *************/
    
    /**
     * Usuario es creado para manejar la plataforma dependiendo del rol
     * @param usuario
     * @throws SQLException 
     */
    public void insertarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, usuario.getId());
        sentenciaPreparada.setString(2, usuario.getNombres());
        sentenciaPreparada.setString(3, usuario.getApellidos());
        sentenciaPreparada.setString(4, usuario.getSexo());
        sentenciaPreparada.setString(5, usuario.getRoll());
        sentenciaPreparada.setString(6, usuario.getPass());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void insertarClub(Club club) throws SQLException{
        String sql = "INSERT INTO club VALUES (?, ?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, club.getId());
        sentenciaPreparada.setString(2, club.getNombre());
        sentenciaPreparada.setString(3, club.getDireccion());
        sentenciaPreparada.setInt(4, club.getId_municipio());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void insertarCategoria(Categoria categoria) throws SQLException{
        String sql = "INSERT INTO categoria VALUES (?, ?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, categoria.getId());
        sentenciaPreparada.setString(2, categoria.getTipo());
        sentenciaPreparada.setString(3, categoria.getDescripcion());
        sentenciaPreparada.setString(4, categoria.getGenero());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void insertarDisciplina(Disciplina disciplina) throws SQLException{
        String sql = "INSERT INTO disciplina VALUES (?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, disciplina.getId());
        sentenciaPreparada.setString(2, disciplina.getNombre());
        sentenciaPreparada.setString(3, disciplina.getDescripcion());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void insertarEncuentro(Encuentro encuentro) throws SQLException{
        String sql = "INSERT INTO encuentro VALUES (?, ?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, encuentro.getId());
        sentenciaPreparada.setString(2, encuentro.getUbicacion());
        sentenciaPreparada.setString(3, encuentro.getFecha());
        sentenciaPreparada.setString(4, encuentro.getHora());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void insertarEquipo(Equipo equipo) throws SQLException{
        String sql = "INSERT INTO equipo VALUES (?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, equipo.getId());
        sentenciaPreparada.setString(2, equipo.getNombre());
        sentenciaPreparada.setString(3, equipo.getFecha_fundacion());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void insertarMunicipio(Municipio municipio) throws SQLException{
        String sql = "INSERT INTO municipio VALUES (?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, municipio.getId());
        sentenciaPreparada.setString(2, municipio.getNombre());
        sentenciaPreparada.setString(3, municipio.getDepartamento());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void insertarParticipacion(Participacion participacion) 
            throws SQLException{
        String sql = "INSERT INTO participacion VALUES (?, ?, ?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, participacion.getId());
        sentenciaPreparada.setString(2, participacion.getTipo());
        sentenciaPreparada.setString(3, participacion.getDescripcion());
        sentenciaPreparada.setString(4, participacion.getFecha());
        sentenciaPreparada.setString(5, participacion.getHora());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void insertarParticipante(Participante participante) 
            throws SQLException{
        String sql = "INSERT INTO participante VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, participante.getId());
        sentenciaPreparada.setString(2, participante.getNombres());
        sentenciaPreparada.setString(3, participante.getApellidos());
        sentenciaPreparada.setInt(4, participante.getEdad());
        sentenciaPreparada.setString(5, participante.getSexo());
        sentenciaPreparada.setFloat(6, participante.getEstatura());
        sentenciaPreparada.setFloat(7, participante.getPeso());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void insertarPenalizacion(Penalizacion penalizacion) 
            throws SQLException{
        String sql = "INSERT INTO penalizacion VALUES (?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, penalizacion.getId());
        sentenciaPreparada.setString(2, penalizacion.getTipo());
        sentenciaPreparada.setString(3, penalizacion.getDescripcion());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void insertarTorneo(Torneo torneo) throws SQLException{
        String sql = "INSERT INTO torneo VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, torneo.getId());
        sentenciaPreparada.setString(2, torneo.getNombre());
        sentenciaPreparada.setString(3, torneo.getFecha_inicio());
        sentenciaPreparada.setString(4, torneo.getFecha_fin());
        sentenciaPreparada.setString(5, torneo.getDescripcion());
        sentenciaPreparada.setInt(6, torneo.getId_disciplina());
        sentenciaPreparada.setInt(7, torneo.getId_categoria());
        
        sentenciaPreparada.executeUpdate();
    }
    
    // Como las entidades hijas no tienen campos propios insertamos directamente
    // en la tabla torneos
    public void insertarTorneoColectivoConOposicion(Torneo torneo) 
            throws SQLException{
        
        // insertamos en la tabla hija torneo_colectivo
        String sql_colectivo = "INSERT INTO torneo_colectivo VALUES (?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql_colectivo);
        sentenciaPreparada.setInt(1, torneo.getId());
        
        sentenciaPreparada.executeUpdate();
        
       // tambien en la subhija de colectivo: con oposicion 
        String sql = "INSERT INTO torneo_colectivo_con_oposicion VALUES (?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, torneo.getId());
        
        sentenciaPreparada.executeUpdate();
        
        // luego en la tabla padre
        insertarTorneo(torneo);
    }
    
    public void insertarTorneoColectivoSinOposicion(Torneo torneo) 
            throws SQLException{
        
        // insertamos en la tabla hija torneo_colectivo
        String sql_colectivo = "INSERT INTO torneo_colectivo VALUES (?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql_colectivo);
        sentenciaPreparada.setInt(1, torneo.getId());
        
        sentenciaPreparada.executeUpdate();
        
       // tambien en la subhija de colectivo: sin oposicion 
        String sql = "INSERT INTO torneo_colectivo_sin_oposicion VALUES (?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, torneo.getId());
        
        sentenciaPreparada.executeUpdate();
        
        // luego en la tabla padre
        insertarTorneo(torneo);
    }
    
    public void insertarTorneoIndividualConEnfrentamiento(Torneo torneo) 
            throws SQLException{
        
        // insertamos en la tabla hija torneo_individual
        String sql_colectivo = "INSERT INTO torneo_individual VALUES (?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql_colectivo);
        sentenciaPreparada.setInt(1, torneo.getId());
        
        sentenciaPreparada.executeUpdate();
        
       // tambien en la subhija de indidual: con enfrentamiento 
        String sql = "INSERT INTO torneo_individual_con_enfrentamiento VALUES (?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, torneo.getId());
        
        sentenciaPreparada.executeUpdate();
        
        // luego en la tabla padre
        insertarTorneo(torneo);
    }
    
    public void insertarTorneoIndividualSinEnfrentamiento(Torneo torneo) 
            throws SQLException {
        
        // insertamos en la tabla hija torneo_individual
        String sql_colectivo = "INSERT INTO torneo_individual VALUES (?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql_colectivo);
        sentenciaPreparada.setInt(1, torneo.getId());
        
        sentenciaPreparada.executeUpdate();
        
       // tambien en la subhija de indidual: sin enfrentamiento 
        String sql = "INSERT INTO torneo_individual_sin_enfrentamiento VALUES (?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, torneo.getId());
        
        sentenciaPreparada.executeUpdate();
        
        // luego en la tabla padre
        insertarTorneo(torneo);
    }
    
    /************************************************************************/
    
    
    
    /********** METODOS PARA INSERTAR REGISTROS EN LAS RELACIONES ***********/

    /**
     * Metodo encargado de inscribir un participante en un equipo 
     * @param id_participante 
     * @param id_equipo 
     * @param cargo es el cargo del participante en el equipo (capitan, jugador)
     * @param posicion es en que numero o posicion juega el participante
     * @throws java.sql.SQLException Error al preparar la sentencia
     */
    public void participanteEquipo(int id_participante, int id_equipo,
            String cargo, String posicion)
            throws SQLException{
        
        String sql = "INSERT INTO participante_equipo VALUES (?, ?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_participante);
        sentenciaPreparada.setInt(2, id_equipo);
        sentenciaPreparada.setString(3, cargo);
        sentenciaPreparada.setString(4, posicion);
        
        sentenciaPreparada.executeUpdate();
    }
    
    // Insertamos el resultado de un encuentro entre participantes
    public void participanteEncuentro(int id_participante, int id_encuentro, int puntos)
            throws SQLException {
        String sql = "INSERT INTO participante_encuentro VALUES (?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_participante);
        sentenciaPreparada.setInt(2, id_encuentro);
        sentenciaPreparada.setInt(3, puntos);
        
        sentenciaPreparada.executeUpdate();
    }
    
    // Incribimos un participante en una disciplina
    public void participanteDisciplina(int id_participante, int id_disciplina) 
            throws SQLException{
        
        String sql = "INSERT INTO participante_disciplina VALUES (?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_participante);
        sentenciaPreparada.setInt(2, id_disciplina);
        
        sentenciaPreparada.executeUpdate();
    }
    
    // Relacionamos un participante con una categoria
    public void participanteCategoria(int id_participante, int id_categoria)
                throws SQLException {
        
        String sql = "INSERT INTO participante_categoria VALUES (?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_participante);
        sentenciaPreparada.setInt(2, id_categoria);
        
        sentenciaPreparada.executeUpdate();
    }
    
    /**
     * Cuando un participante realiza su demostracion y recibe una valoracion
     * @param id_participante
     * @param id_participacion
     * @param valoracion son los puntos que recibe el participante
     * @throws SQLException 
     */
    public void participanteParticipacion(int id_participante,
            int id_participacion, int valoracion)
            throws SQLException {
        
        String sql = "INSERT INTO participante_participacion VALUES (?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_participante);
        sentenciaPreparada.setInt(2, id_participacion);
        sentenciaPreparada.setInt(3, valoracion);
        
        sentenciaPreparada.executeUpdate();
    }
    
    // cada participante esta 'inscrito' en un club
    public void participanteClub(int id_participante, int id_club) 
            throws SQLException {
        
        String sql = "INSERT INTO participante_club VALUES (?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_participante);
        sentenciaPreparada.setInt(2, id_club);
        
        sentenciaPreparada.executeUpdate();
    }
    
    // relacionamos participante y penalizacion
    public void participantePenalizacion(int id_participante, int id_penalizacion)
                throws SQLException {
        
        String sql = "INSERT INTO participante_penalizacion VALUES (?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_participante);
        sentenciaPreparada.setInt(2, id_penalizacion);
        
        sentenciaPreparada.executeUpdate();
    }
    
    // Inscribimos una disciplina en un club
    public void disciplinaClub(int id_disciplina, int id_club)
            throws SQLException{
        
        String sql = "INSERT INTO disciplina_club VALUES (?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_disciplina);
        sentenciaPreparada.setInt(2, id_club);
        
        sentenciaPreparada.executeUpdate();
    }
    
    // Las disciplinas que hay en un municipio
    public void disciplinaMunicipio(int id_disciplina, int id_municipio) 
            throws SQLException {
        
        String sql = "INSERT INTO disciplina_municipio VALUES (?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_disciplina);
        sentenciaPreparada.setInt(2, id_municipio);
        
        sentenciaPreparada.executeUpdate();
    }
    
    /**
     * Inscribimos un club en un torneo    
     * @param cargo es el papel del club en el torneo (organizador, visitante)
     * @param id_club identificador del club
     * @param id_torneo torneo al cual se va a inscribir el club
     * @throws java.sql.SQLException
     */
    public void clubTorneo(int id_club, int id_torneo, String cargo)
            throws SQLException{
        
        String sql = "INSERT INTO club_torneo VALUES (?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_club);
        sentenciaPreparada.setInt(2, id_torneo);
        sentenciaPreparada.setString(3, cargo);
        
        sentenciaPreparada.executeUpdate();
        
    }
    
    /**
     * Para cuando se lleva a cabo un encuentro
     * @param id_equipo es uno de los dos equipos que se estan enfrentando
     * @param id_encuentro 
     * @param puntos esto depende del deponte (goles, canastas, etc..)
     * @throws SQLException 
     */
    public void equipoEncuentro(int id_equipo, int id_encuentro, int puntos)
            throws SQLException{
        
        String sql = "INSERT INTO equipo_encuentro VALUES (?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_equipo);
        sentenciaPreparada.setInt(2, id_encuentro);
        sentenciaPreparada.setInt(3, puntos);
        
        sentenciaPreparada.executeUpdate();
    }
    
    /**
     * Cuando se lleva a cabo una participacion de un equipo
     * @param id_equipo
     * @param id_participacion
     * @param valoracion esto será la valoracion, puntos, o como se defina segun el deporte
     * @throws SQLException 
     */
    public void equipoParticipacion(int id_equipo, int id_participacion, int valoracion)
            throws SQLException{
        
        String sql = "INSERT INTO equipo_participacion VALUES (?, ?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_equipo);
        sentenciaPreparada.setInt(2, id_participacion);
        sentenciaPreparada.setInt(3, valoracion);
        
        sentenciaPreparada.executeUpdate();
    }
    
    // Relacion entre equipo y disciplina
    public void equipoDisciplina(int id_equipo, int id_disciplina) 
            throws SQLException{
        
        String sql = "INSERT INTO equipo_disciplina VALUES (?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_equipo);
        sentenciaPreparada.setInt(2, id_disciplina);
        
        sentenciaPreparada.executeUpdate();
    }
    
    // relacionamos a equipo con torneo_colectivo
    public void equipoTorneoColectivo(int id_equipo, int id_torneo_colectivo)
            throws SQLException {
        
        String sql = "INSERT INTO equipo_torneo_colectivo VALUES (?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_equipo);
        sentenciaPreparada.setInt(2, id_torneo_colectivo);
        
        sentenciaPreparada.executeUpdate();
    }
    
    // relacion entre equipo y penalizacion (solo estos dos)
    public void equipoPenalizacion(int id_equipo, int id_penalizacion)
            throws SQLException {
        
        String sql = "INSERT INTO equipo_penalizacion VALUES (?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_equipo);
        sentenciaPreparada.setInt(2, id_penalizacion);
        
        sentenciaPreparada.executeUpdate();
    }
    
    // relacionamos equipo con club (los clubs forman los equipos)
    public void equipoClub(int id_equipo, int id_club) throws SQLException{
        String sql = "INSERT INTO equipo_club VALUES (?, ?);";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_equipo);
        sentenciaPreparada.setInt(2, id_club);
        
        sentenciaPreparada.executeUpdate();
    }
    
    
    /************************************************************************/
    
    
    
    /********** METODOS PARA ELIMINAR REGISTROS EN LAS ENTIDADES ***********/
    
    public void eliminarUsuario(int id_usuario) throws SQLException {
        String sql = "DELECT FROM usuario WHERE id_usuario=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_usuario);
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void eliminarEquipo(int id_equipo) throws SQLException{
        String sql = "DELECT FROM equipo WHERE id_equipo=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_equipo);
        
        sentenciaPreparada.executeUpdate();
    }
     
    public void eliminarMunicipio(int id_municipio) throws SQLException{
        String sql = "DELECT FROM municipio WHERE id_municipio=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_municipio);
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void eliminarDisciplina(int id_disciplina) throws SQLException {
        String sql = "DELECT FROM disciplina WHERE id_disciplina=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_disciplina);
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void eliminarCategoria(int id_categoria) throws SQLException {
        String sql = "DELECT FROM categoria WHERE id_categoria=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_categoria);
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void eliminarClub(int id_club) throws SQLException {
        String sql = "DELECT FROM club WHERE id_club=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_club);
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void eliminarEncuentro(int id_encuentro) throws SQLException {
        String sql = "DELECT FROM encuentro WHERE id_encuentro=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_encuentro);
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void eliminarParticipacion(int id_participacion) throws SQLException {
        String sql = "DELECT FROM participacion WHERE id_participacion=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_participacion);
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void eliminarParticipante(int id_participante) throws SQLException {
        String sql = "DELECT FROM participante WHERE id_participante=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_participante);
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void eliminarPenalizacion(int id_penalizacion) throws SQLException {
        String sql = "DELECT FROM penalizacion WHERE id_penalizacion=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_penalizacion);
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void eliminarTorneo(int id_torneo) throws SQLException {
        String sql = "DELECT FROM torneo WHERE id_torneo=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_torneo);
        
        sentenciaPreparada.executeUpdate();
    }
    
    /************************************************************************/
    
    
    /********** METODOS PARA MODFICIAR REGISTROS EN LAS ENTIDADES ***********/
    
    public void modificarUuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nombres_usuario=?, apellidos_usuario=?,"
                + " sexo_usuario=?, roll_usuario=?, pass_usuario=?"
                + "WHERE id_usuario=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setString(1, usuario.getNombres());
        sentenciaPreparada.setString(2, usuario.getApellidos());
        sentenciaPreparada.setString(3, usuario.getSexo());
        sentenciaPreparada.setString(4, usuario.getRoll());
        sentenciaPreparada.setString(5, usuario.getPass());
        sentenciaPreparada.setInt(6, usuario.getId());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void modificarCategoria(Categoria categoria) throws SQLException {
        String sql = "UPDATE categoria SET tipo_categoria=?, "
                + "descripcion_categoria=?, genero_categoria=? "
                + "WHERE id_categoria=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setString(1, categoria.getTipo());
        sentenciaPreparada.setString(2, categoria.getDescripcion());
        sentenciaPreparada.setString(3, categoria.getGenero());
        sentenciaPreparada.setInt(4, categoria.getId());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void modificarClub(Club club) throws SQLException {
        String sql = "UPDATE club SET nombre_club=?, direccion_club=? "
                + "WHERE id_club=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setString(1, club.getNombre());
        sentenciaPreparada.setString(2, club.getDireccion());
        sentenciaPreparada.setInt(3, club.getId());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void modificarDisciplina(Disciplina disciplina) throws SQLException {
        String sql = "UPDATE disciplina SET nombre_disciplina=?,"
                + " descripcion_disciplina=? "
                + "WHERE id_disciplina=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setString(1, disciplina.getNombre());
        sentenciaPreparada.setString(2, disciplina.getDescripcion());
        sentenciaPreparada.setInt(3, disciplina.getId());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void modificarEncuentro(Encuentro encuentro) throws SQLException {
        String sql = "UPDATE encuentro SET ubicacion_encuentro=?,"
                + " fecha_encuentro=?, hora_encuentro=? "
                + "WHERE id_encuentro=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setString(1, encuentro.getUbicacion());
        sentenciaPreparada.setString(2, encuentro.getFecha());
        sentenciaPreparada.setString(3, encuentro.getHora());
        sentenciaPreparada.setInt(4, encuentro.getId());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void modificarEquipo(Equipo equipo) throws SQLException {
        String sql = "UPDATE equipo SET nombre_equipo=?, fecha_fundacion=? "
                + "WHERE id_equipo=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setString(1, equipo.getNombre());
        sentenciaPreparada.setString(2, equipo.getFecha_fundacion());
        sentenciaPreparada.setInt(3, equipo.getId());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void modificarMunicipio(Municipio municipio) throws SQLException {
        String sql = "UPDATE municipio SET nombre_municipio=?, "
                + "departamento_municipio=? "
                + "WHERE id_municipio=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setString(1, municipio.getNombre());
        sentenciaPreparada.setString(2, municipio.getDepartamento());
        sentenciaPreparada.setInt(3, municipio.getId());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void modificarParticipacion(Participacion participacion)
            throws SQLException {
        
        String sql = "UPDATE participacion SET tipo_participacion=?,"
                + " descripcion_participacion=?, fecha_participacion=?, "
                + "hora_participacion=? "
                + "WHERE id_participacion=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setString(1, participacion.getTipo());
        sentenciaPreparada.setString(2, participacion.getDescripcion());
        sentenciaPreparada.setString(3, participacion.getFecha());
        sentenciaPreparada.setString(4, participacion.getHora());
        sentenciaPreparada.setInt(5, participacion.getId());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void modificarParticipante(Participante participante)
            throws SQLException {
        
        String sql = "UPDATE participante SET nombre_participante=?, "
                + "apellidos_participante=?, edad_participante=?, "
                + "sexo_participante=?, estatura_participante=?, "
                + "peso_participante=? "
                + "WHERE id_participante=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setString(1, participante.getNombres());
        sentenciaPreparada.setString(2, participante.getApellidos());
        sentenciaPreparada.setInt(3, participante.getEdad());
        sentenciaPreparada.setString(4, participante.getSexo());
        sentenciaPreparada.setFloat(5, participante.getEstatura());
        sentenciaPreparada.setFloat(6, participante.getPeso());
        sentenciaPreparada.setInt(7, participante.getId());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void modificarPenalizacion(Penalizacion penalizacion)
           throws SQLException {
        
        String sql = "UPDATE penalizacion SET tipo_penalizacion=?,"
                + "descripcion_penalizacion=? WHERE id_penalizacion=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setString(1, penalizacion.getTipo());
        sentenciaPreparada.setString(2, penalizacion.getDescripcion());
        sentenciaPreparada.setInt(3, penalizacion.getId());
        
        sentenciaPreparada.executeUpdate();
    }
    
    public void modificarTorneo(Torneo torneo) throws SQLException {
        String sql = "UPDATE torneo SET nombre_torneo=?, fecha_inicio=?, "
                + "fecha_fin=?, descripcion_torneo=?, id_disciplina_torneo=?,"
                + "id_categoria_torneo=?"
                + "WHERE id_torneo=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setString(1, torneo.getNombre());
        sentenciaPreparada.setString(2, torneo.getFecha_inicio());
        sentenciaPreparada.setString(3, torneo.getFecha_fin());
        sentenciaPreparada.setString(4, torneo.getDescripcion());
        sentenciaPreparada.setInt(5, torneo.getId_disciplina());
        sentenciaPreparada.setInt(6, torneo.getId_categoria());
        sentenciaPreparada.setInt(7, torneo.getId());
        
        sentenciaPreparada.executeUpdate();
    }
    
    /************************************************************************/
    
    /********** METODOS PARA SELECCIONAR REGISTROS EN LAS ENTIDADES ***********/
    
    public ResultSet seleccionarUsuarioPorId(int id_usuario) throws SQLException{
        String sql = "SELECT * FROM usuario WHERE id_usuario=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_usuario);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        
        return resultado;
    }
    
    public ResultSet seleccionarClubPorId(int id_club) throws SQLException{
        String sql = "SELECT * FROM club WHERE id_club=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_club);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        
        return resultado;
    }
    
    public ResultSet seleccionarCategoriaPorId(int id_categoria) throws SQLException{
        String sql = "SELECT * FROM categoria WHERE id_categoria=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_categoria);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        
        return resultado;
    }
    
    public ResultSet seleccionarDisciplinaPorId(int id_disciplina) throws SQLException{
        String sql = "SELECT * FROM disciplina WHERE id_disciplina=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_disciplina);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        
        return resultado;
    }
    
    public ResultSet seleccionarEncuentroPorId(int id_encuentro) throws SQLException{
        String sql = "SELECT * FROM encuentro WHERE id_encuentro=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_encuentro);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        
        return resultado;
    }
    
    public ResultSet seleccionarEquipoPorId(int id_equipo) throws SQLException{
        String sql = "SELECT * FROM equipo WHERE id_equipo=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_equipo);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        
        return resultado;
    }
    
    public ResultSet seleccionarMunicipioPorId(int id_municipio) throws SQLException{
        String sql = "SELECT * FROM municipio WHERE id_municipio=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_municipio);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        
        return resultado;
    }
    
    public ResultSet seleccionarParticupacionPorId(int id_participacion) throws SQLException{
        String sql = "SELECT * FROM participacion WHERE id_participacion=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_participacion);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        
        return resultado;
    }
    
    public ResultSet seleccionarParticipantePorId(int id_participante) throws SQLException{
        String sql = "SELECT * FROM participante WHERE id_participante=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_participante);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        
        return resultado;
    }
    
    public ResultSet seleccionarPenalizacionPorId(int id_penalizacion) throws SQLException{
        String sql = "SELECT * FROM penalizacion WHERE id_penalizacion=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_penalizacion);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        
        return resultado;
    }
    
    public ResultSet seleccionarTorneoPorId(int id_torneo) throws SQLException{
        String sql = "SELECT * FROM torneo WHERE id_torneo=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_torneo);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        
        return resultado;
    }
    
    /************************************************************************/
    
    public void cerrarSentencia() throws SQLException{
        sentenciaPreparada.close();
    }
}
