package GestorDeportes;

import Conexion.BDCrud;
import static Conexion.DBUtilidades.actualizarPuntos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CristianAlvarez
 */
public class Futbol {
        
    public static void definirResultado(int id_torneo, int id_encuentro){
        String sqlMarcador = "SELECT id_equipo, nombre_equipo, resultado" +
                    "FROM equipo, equipo_encuentro " +
                    "WHERE id_equipo=id_equipo_encuentro AND id_encuentro_equipo=1;";
        
        try {
            ResultSet resultMarcador = BDCrud.ejecutarConsulta(sqlMarcador);
           
            if(resultMarcador != null){
                int [] id_equipos = new int[2];
                int [] resultados = new int[2];
                int i = 0;
                
                while(resultMarcador.next()){
                    id_equipos[i] = resultMarcador.getInt(1);
                    resultados[i] = resultMarcador.getInt(3);
                    
                    i++;
                }
                
                int id_ganador = idDelGanador(id_equipos, resultados);
                
                if(id_ganador != -1){// no es empate
                    actualizarPuntos(id_torneo, id_ganador, 3);
                }else{
                    actualizarPuntos(id_torneo, id_equipos[0], 1);
                    actualizarPuntos(id_torneo, id_equipos[1], 1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Futbol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static int idDelGanador(int [] equipos, int [] resultados){
        if(resultados[0] > resultados[1]){
            return equipos[0];
        }else if(resultados[0] < resultados[1]){
            return equipos[1];
        }else{// empate
            return -1;
        }
    }
    
    public static int idGanadorTorneo(int id_torneo){
        String sql = "SELECT id_equipo_clasificacion FROM clasificacion "
                + "WHERE id_torneo_clasificacion="+id_torneo+" ORDER BY puntos DESC LIMIT 1;";
        
        try {
            ResultSet resultId = BDCrud.ejecutarConsulta(sql);
            
            if(resultId != null){
                if(resultId.next()){
                    return resultId.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Futbol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;// en caso de error
    }
}
