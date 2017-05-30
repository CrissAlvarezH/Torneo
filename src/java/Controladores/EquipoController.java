package Controladores;

import Conexion.BDCrud;
import Conexion.DBUtilidades;
import Modelos.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author CristianAlvarez
 */
public class EquipoController {
    
    public static boolean insertarEquipo(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id_equipo"));
        String nombre = request.getParameter("nombre_equipo");
        String fecha_fundacion = request.getParameter("fecha");
        
        Equipo equipo = new Equipo(id, nombre, "2017-04-02");
        
        boolean resultOK = false;
        try{
            resultOK = BDCrud.insertarEquipo(equipo);
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(EquipoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultOK;
    }
    
    public static boolean formarEquipo(HttpServletRequest request,
            String idParticipantes, int idEquipo, int idClub) throws SQLException{
        
        if(insertarEquipo(request)){
            if(BDCrud.equipoClub(idEquipo, idClub)){
                return true;
            }
            /*
                String [] participantes = idParticipantes.split(",");

                for(String idParticipante : participantes){
                    System.out.println("id participante: "+idParticipante);
                    if(!BDCrud.participanteEquipo(Integer.parseInt(idParticipante), idEquipo, "", "")){
                        return false;
                    }
                }*/
        }
        
        return false;
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
    
    public static Equipo obtenerEquipo(int idEquipo){
        Equipo equipo = null;
        
        ResultSet result;
        try{
            result = BDCrud.seleccionarEquipoPorId(idEquipo);
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String fecha = result.getString(3);
                    
                    equipo = new Equipo(id, nombre, fecha);
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return equipo;
    }
}
