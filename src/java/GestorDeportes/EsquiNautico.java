package GestorDeportes;

import Conexion.BDCrud;
import Conexion.DBUtilidades;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CristianAlvarez
 */
public class EsquiNautico{
    // Vector que contiene el puntaje dependiendo de la posicion
    private static double [] puntos = {100, 80, 60, 50, 45, 40, 36, 32, 29, 26, 24, 
            22, 20, 18, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    
    // Metodo encargado de asignar puntos las participantes dependiendo 
    // de su tiempo en el decenso, el decenso se especifica en el parametro
    public static void asignarPuntos(int id_participacion){
        // Consulta encargada de retornar los id de los participantes que realizaron un decenso
        // ordenado descendentemente por tiempo.
        String resultadosDecenso = "SELECT id_participante_participacion " +
                "FROM participante_participacion" +
                "WHERE id_participacion_participante=" + id_participacion +// concatenamos a la consutla
                "ORDE BY tiempo;";
        
        try{
            ResultSet result = BDCrud.ejecutarConsulta(resultadosDecenso);
            
            if(result != null){
                int i = 0;
                
                while(result.next()){// recorremos el resultSet para obtener los id de los participantes
                    // A cada participante le asignamos una valoracion dependiendo de su posicion
                    DBUtilidades.insertarValoracion(result.getInt(1), id_participacion, puntos[i]);
                    i++;// aumentamos el indice del vector
                }
            }
        
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
    }
    
            
    
   /* 
      -> Esta consulta me retorna el id de los participantes que realizaron
        una participacion ordenador por tiempo, de tal forma que quien este de primero
        tuvo el menor tiempo en la participacion y asi sucesivamente.
    
      SELECT id_participante FROM participante, participante_participacion
      WHERE id_participante=id_participante_participacion AND id_participacion_participante=?
      ORDE BY tiempo;
    
      -> Con el id los participantes de manera ordenada procedemos a insertar
        en esa misma tabla su correspondiente puntaje en 'valoracion'
    
      
   */
}
