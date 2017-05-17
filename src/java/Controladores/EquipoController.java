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
public class EquipoController {
    
    public static boolean insertarEquipo(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String fecha_fundacion = request.getParameter("fecha_fundacion");
        
        Equipo equipo = new Equipo(id, nombre, fecha_fundacion);
        
        boolean resultOK = false;
        try{
            resultOK = BDCrud.insertarEquipo(equipo);
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return resultOK;
    }
    
    public static List<Equipo> obtenerEquipos(){
        List<Equipo> equipos = new ArrayList();
        
        ResultSet result;
        try{
            result = DBUtilidades.todosLosEquipos();
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String fecha = result.getString(3);
                    
                    equipos.add(new Equipo(id, nombre, fecha));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return equipos;
    }
    
    public static List<Equipo> obtenerEquipos(int club){
        List<Equipo> equipos = new ArrayList();
        
        ResultSet result;
        try{
            result = DBUtilidades.equiposDeUnClub(club);
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String fecha = result.getString(3);
                    
                    equipos.add(new Equipo(id, nombre, fecha));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return equipos;
    }
}
