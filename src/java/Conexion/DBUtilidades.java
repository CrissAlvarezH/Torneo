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
    private Connection conexion;
    private PreparedStatement sentenciaPreparada;
    
    public DBUtilidades(){
        conexion = Conector.getConexion();
        sentenciaPreparada = null;
    }
    
    // Retorna toda la informacion de los clubes del municipio pasado por parametros
    public ResultSet clubesDeUnMunicipio(int id_municipio) throws SQLException {
        String sql = "SELECT * FROM clubes WHERE id_municipio_club=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_municipio);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        sentenciaPreparada.close();
        
        return resultado;
    }
    
    // Retorna las disciplinas que estan en un club
    public ResultSet disciplinasDeUnClub(int id_club) throws SQLException{
        String sql = "SELECT * FROM disciplina, disciplina_club  "
                + "WHERE id_disciplina=id_disciplina_club AND id_club_disciplina=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_club);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        sentenciaPreparada.close();
        
        return resultado;
    }
    
    // Retorna los participantes que practican una disciplina
    public ResultSet participantesDeUnaDisciplina(int id_disciplina) 
            throws SQLException {
        
        String sql = "SELECT * FROM participante, participante_disciplina "
                + "WHERE id_participante=id_participante_disciplina "
                + "AND id_disciplina_participante=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_disciplina);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        sentenciaPreparada.close();
        
        return resultado;
    }
    
    // Retorna los participantes que estan en un equipo
    public ResultSet participantesDeUnEquipo(int id_equipo) throws SQLException{
        String sql = "SELECT * FROM participante, participante_equipo "
                + "WHERE id_participante=id_participante_equipo "
                + "AND id_equipo_participante=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_equipo);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        sentenciaPreparada.close();
        
        return resultado;
    }
    
    // Retorna los equipos de un club 
    public ResultSet equiposDeUnClub(int id_club) throws SQLException {
        String sql = "SELECT * FROM equipos, equipo_club "
                + "WHERE id_equipo=id_equipo_club "
                + "AND id_club_equipo=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_club);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        sentenciaPreparada.close();
        
        return resultado;
    }
    
    // Retorna las disciplinas de un municipio
    public ResultSet disciplinasDeUnMunicipio(int id_municipio) throws SQLException {
        String sql = "SELECT * FROM disciplina, disciplina_municipio "
                + "WHERE id_disciplina=id_disciplina_municipio "
                + "AND id_municipio_disciplina=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_municipio);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        sentenciaPreparada.close();
        
        return resultado;
    }
    
    // Retorna los equipos que estuvieron en un encuentro
    public ResultSet equiposEnEncuentro(int id_encuentro) throws SQLException {
        String sql = "SELECT * FROM equipo, equipo_encuentro "
                + "WHERE id_equipo=id_equipo_encuentro "
                + "AND id_encuentro_equipo=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_encuentro);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        sentenciaPreparada.close();
        
        return resultado;
    }
    
    // Retorna los participantes que estuvieron en un encuentro
    public ResultSet participantesEnEncuentro(int id_encuentro) 
            throws SQLException {
        
        String sql = "SELECT * FROM participante, participante_encuentro "
                + "WHERE id_participante=id_participante_encuentro "
                + "AND id_encuentro_participante=?;";
        
        sentenciaPreparada = conexion.prepareStatement(sql);
        sentenciaPreparada.setInt(1, id_encuentro);
        
        ResultSet resultado = sentenciaPreparada.executeQuery();
        sentenciaPreparada.close();
        
        return resultado;
    }
}
