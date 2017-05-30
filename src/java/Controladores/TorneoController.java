package Controladores;

import Conexion.BDCrud;
import Modelos.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author CristianAlvarez
 */
public class TorneoController {
    public static boolean registrarTorneo(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id_torneo"));
        String nombre = request.getParameter("nombre_torneo");
        String descripcion = request.getParameter("descripcion");
        String fecha_inicio = request.getParameter("fecha_inicio");
        String fecha_fin = request.getParameter("fecha_fin");
         
        Torneo torneo = new Torneo(id, nombre, fecha_inicio, fecha_fin, descripcion, 1, 1);
        
        boolean resultOK = false;
        try{
            resultOK = BDCrud.insertarTorneo(torneo);
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return resultOK;
    }
    
    public static List<Torneo> listarTorneos(){
        List<Torneo> lista = new ArrayList();
        ResultSet result;
        
        try {
            result = BDCrud.todosLosTorneos();
            
            if(result != null){
                while(result.next()){
     
                    Torneo torneo = new Torneo(result.getInt(1), result.getString(2),
                            "","", "", 1, 1);
                    
                    lista.add(torneo);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TorneoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
}
