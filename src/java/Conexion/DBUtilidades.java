/*
 * Clase creada para obtener datos de manera relacional  de la base de datos,
 * por ejemplo: los participantes de un equipo, los clubes de un municipio, etc.
 */
package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CristianAlvarez
 */
public class DBUtilidades {

    private static final Connection conexion = Conector.getConexion();
    private static PreparedStatement sentenciaPreparada = null;

    public static boolean validarUsuario(int id_usuario, String pass)
            throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id_usuario=? "
                + "AND pass_usuario=?;";
        ResultSet resultado;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_usuario);
            sentenciaPreparada.setString(2, pass);

            sentenciaPreparada.executeQuery();
            resultado = sentenciaPreparada.getResultSet();
            return resultado.next();
        }

        return false;// si hay por lo menos un resultado
    }
    
    public static boolean actualizarPuntos(int id_torneo, int id_equipo, int puntos)
            throws SQLException {
        // pedimos los puntos que tiene hasta el momento, le sumamos lo que se ganó
        // y le volvemos a insertar dichos puntos
        String sqlPuntos = "SELECT puntos FROM clasificacion "
                + "WHERE id_torneo_clasificacion=3 AND id_equipo_clasificacion=4;";
        
        ResultSet resultPuntos = BDCrud.ejecutarConsulta(sqlPuntos);
        int puntosAnteriores = 0;
        
        if(resultPuntos.next())
            puntosAnteriores = resultPuntos.getInt(1);
        
        puntosAnteriores += puntos;// sumamos los puntos ganados
        
        String sql = "UPDATE clasificacion SET puntos=? "
                + "WHERE id_torneo_clasificacion=? AND id_equipo_clasificacion=?;";
        
        if(conexion != null){
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_torneo);
            sentenciaPreparada.setInt(2, id_equipo);
            sentenciaPreparada.setInt(3, puntosAnteriores);
        }
        
        return sentenciaPreparada.executeUpdate() == 1;
    }
    
    // metodo para insertar la valoracion de un participante en una valoracion
    public static boolean insertarValoracion(int id_participante,
            int id_participacion, double valoracion) throws SQLException{
        String sql = "UPDATE participante_participacion "
                + "SET valoracion = ? "
                + "WHERE id_participante_participacion=? "
                + "AND id_participacion_participante=?;";
        
        if(conexion != null){
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setDouble(1, valoracion);
            sentenciaPreparada.setInt(2, id_participante);
            sentenciaPreparada.setInt(3, id_participacion);
        }
        
        return sentenciaPreparada.executeUpdate() == 1;
    }
    
    public static ResultSet todosLosClubes() throws SQLException {
        String sql = "SELECT * FROM clubes;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }
    
    public static ResultSet todosLosMunicipios() throws SQLException {
        String sql = "SELECT * FROM municipio;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }
    
    public static ResultSet municipioPorNombre(String nombre) throws SQLException {
        String sql = "SELECT * FROM municipio WHERE nombre_municipio LIKE '%"+nombre+"%';";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }
    
    public static ResultSet disciplinasPorNombreYMunicipio(String nombre, int id_municipio) throws SQLException {
        String sql = "SELECT * FROM disciplina, disciplina_municipio "
                + "WHERE id_disciplina=id_disciplina_municipio AND nombre_disciplina LIKE '%"+nombre+"%';";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }
    
    // Retorna toda la informacion de los clubes del municipio y deporte pasados por parametros
    public static ResultSet clubesDeUnMunicipio(int id_municipio) throws SQLException {
        String sql = "SELECT * FROM clubes WHERE id_municipio_club=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_municipio);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }

    // Retorna toda la informacion de los clubes del municipio y deporte pasados por parametros
    public static ResultSet clubesDeUnMunicipioYDeporte(int id_municipio, int id_disciplina) throws SQLException {
        String sql = "SELECT * FROM clubes, disciplina_club WHERE id_municipio_club=? AND id_disciplina_club=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_municipio);
            sentenciaPreparada.setInt(2, id_disciplina);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }

    // Retorna las disciplinas que estan en un club
    public static ResultSet disciplinasDeUnClub(int id_club) throws SQLException {
        String sql = "SELECT * FROM disciplina, disciplina_club  "
                + "WHERE id_disciplina=id_disciplina_club AND id_club_disciplina=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_club);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }
    
    
    public static ResultSet todosLasDisciplinas() throws SQLException {
        String sql = "SELECT * FROM disciplina;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }

    // Retorna los participantes que practican una disciplina
    public static ResultSet participantesDeUnaDisciplina(int id_disciplina)
            throws SQLException {

        String sql = "SELECT * FROM participante, participante_disciplina "
                + "WHERE id_participante=id_participante_disciplina "
                + "AND id_disciplina_participante=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_disciplina);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }

    // Retorna los participantes que estan en un equipo
    public static ResultSet participantesDeUnEquipo(int id_equipo) throws SQLException {
        String sql = "SELECT * FROM participante, participante_equipo "
                + "WHERE id_participante=id_participante_equipo "
                + "AND id_equipo_participante=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_equipo);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }
    
    // retorna las participaciones de un torneo
    public static ResultSet participacionesDeUnTorneo(int id_torneo) throws SQLException {
        String sql = "SELECT * FROM participacion, participacion_torneo "
                + "WHERE id_participacion=id_participacion_torneo "
                + "AND id_torneo_participacion=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_torneo);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }

    // Retorna los equipos de un club
    public static ResultSet equiposDeUnClub(int id_club) throws SQLException {
        String sql = "SELECT * FROM equipos, equipo_club "
                + "WHERE id_equipo=id_equipo_club "
                + "AND id_club_equipo=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_club);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }
    
    public static ResultSet todosLosEquipos() throws SQLException {
        String sql = "SELECT * FROM equipo;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }

    // Retorna las disciplinas de un municipio
    public static ResultSet disciplinasDeUnMunicipio(int id_municipio) throws SQLException {
        String sql = "SELECT * FROM disciplina, disciplina_municipio "
                + "WHERE id_disciplina=id_disciplina_municipio "
                + "AND id_municipio_disciplina=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_municipio);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }

    // Retorna los equipos que estuvieron en un encuentro
    public static ResultSet equiposEnEncuentro(int id_encuentro) throws SQLException {
        String sql = "SELECT * FROM equipo, equipo_encuentro "
                + "WHERE id_equipo=id_equipo_encuentro "
                + "AND id_encuentro_equipo=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_encuentro);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }

    // Retorna los participantes que estuvieron en un encuentro
    public static ResultSet participantesEnEncuentro(int id_encuentro)
            throws SQLException {

        String sql = "SELECT * FROM participante, participante_encuentro "
                + "WHERE id_participante=id_participante_encuentro "
                + "AND id_encuentro_participante=?;";
        ResultSet resultado = null;
        if (conexion != null) {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, id_encuentro);

            resultado = sentenciaPreparada.executeQuery();
        }

        return resultado;
    }
}
