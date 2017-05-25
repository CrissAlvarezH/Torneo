package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CristianAlvarez
 */
public class Conector {
    private static Connection conexion = null;
    
    // metodo para hacer la conexion con la base de datos, 
    //lazan las excepciones pertinentes a ese proceso
    public static void conectar() throws ClassNotFoundException, SQLException{
        if(conexion == null){
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://172.17.0.2:5432/torneos",// base de datos
                    "postgres", "eva123");// usuario, contraseña
        }
    }
    
    public static Connection getConexion(){
        try {
            conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("La carga del Driver falló -> " + ex.getMessage());
        } catch (SQLException e) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Conexion no se pudo hacer -> " + e.getMessage());
        }
        
        return conexion;
    }
}
