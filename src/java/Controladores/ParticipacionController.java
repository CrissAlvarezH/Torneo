package Controladores;

import Conexion.BDCrud;
import Conexion.DBUtilidades;
import Modelos.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author CristianAlvarez
 */
public class ParticipacionController {
    
    public static boolean registrarParticipacion(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String tipo = request.getParameter("tipo");
        String descripcion = request.getParameter("descripcion");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        
        Participacion participacion = new Participacion(id, tipo, descripcion,
                    fecha, hora);
        
        boolean resultOK = false;
        try{
            resultOK = BDCrud.insertarParticipacion(participacion);
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return resultOK;
    }
    
    public static List<Participacion> obtenerParticipacionesDeTorneo(int id_torneo){
        List<Participacion> participaciones = new ArrayList();
        
        ResultSet result;
        
        try{
            result = DBUtilidades.participacionesDeUnTorneo(id_torneo);
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String tipo = result.getString(2);
                    String descripcion = result.getString(3);
                    String fecha = result.getString(4);
                    String hora = result.getString(5);
                    
                    participaciones.add(new Participacion(id, tipo, descripcion,
                                fecha, hora));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return participaciones;
    }
    
        
}
