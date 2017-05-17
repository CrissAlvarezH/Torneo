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
public class ParticipanteController {
    
    public static boolean insertarParticipante(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        double estatura = Double.parseDouble(request.getParameter("estatura"));
        double peso = Double.parseDouble(request.getParameter("peso"));
        
        Participante participante = new Participante(id, nombres, apellidos,
                edad, sexo,((float) estatura), ((float) peso));
        
        boolean resultOK = false;
        try{
            resultOK = BDCrud.insertarParticipante(participante);
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return resultOK;
    }
    
    public static List<Participante> obtenerParticipantes(){
        List<Participante> participantes = new ArrayList();
        
        ResultSet result;
        try{
            result = DBUtilidades.todosLosEquipos();
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String apellidos = result.getString(3);
                    int edad = result.getInt(4);
                    String sexo = result.getString(5);
                    float estatura = (float) result.getDouble(6);
                    float peso = (float) result.getDouble(7);
                    
                    participantes.add(new Participante(id, nombre, apellidos,
                                    edad, sexo, estatura, peso));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return participantes;
    }
    
    public static List<Participante> obtenerParticipantes(int id_disciplina){
        List<Participante> participantes = new ArrayList();
        
        ResultSet result;
        try{
            result = DBUtilidades.participantesDeUnaDisciplina(id_disciplina);
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String apellidos = result.getString(3);
                    int edad = result.getInt(4);
                    String sexo = result.getString(5);
                    float estatura = (float) result.getDouble(6);
                    float peso = (float) result.getDouble(7);
                    
                    participantes.add(new Participante(id, nombre, apellidos,
                                    edad, sexo, estatura, peso));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return participantes;
    }
    
    public static List<Participante> obtenerParticipantesDeEquipo(int id_equipo){
        List<Participante> participantes = new ArrayList();
        
        ResultSet result;
        try{
            result = DBUtilidades.participantesDeUnEquipo(id_equipo);
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String apellidos = result.getString(3);
                    int edad = result.getInt(4);
                    String sexo = result.getString(5);
                    float estatura = (float) result.getDouble(6);
                    float peso = (float) result.getDouble(7);
                    
                    participantes.add(new Participante(id, nombre, apellidos,
                                    edad, sexo, estatura, peso));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return participantes;
    }
    
}
