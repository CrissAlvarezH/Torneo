package Controladores;

import Conexion.BDCrud;
import Conexion.DBUtilidades;
import static Controladores.DisciplinaController.obtenerDisciplinas;
import Modelos.Club;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author CristianAlvarez
 */
public class ClubController {
    
    public static boolean registrarClub(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("codigo"));
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        int id_municipio = Integer.parseInt(request.getParameter("id_municipio"));
        
        Club club = new Club(id, nombre, direccion, id_municipio);
        
        boolean resultOK = false;
        try{
            resultOK = BDCrud.insertarClub(club);
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return resultOK;
    }
    
    public static boolean insertarClubConDisciplina(HttpServletRequest request,
                    int id_municipio, int id_disciplina){
        int id = Integer.parseInt(request.getParameter("codigo"));
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        
        Club club = new Club(id, nombre, direccion, id_municipio);
        
        boolean resultOK = false;
        try{
            resultOK = BDCrud.insertarClubConDisciplina(club, id_disciplina);
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return resultOK;
    }
    
    public static List<Club> obtenerClubes(){
        List<Club> clubes = new ArrayList();
        
        ResultSet result;
        
        try{
            result = DBUtilidades.todosLosClubes();
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String direccion = result.getString(3);
                    int id_municipio = result.getInt(4);
                    
                    clubes.add(new Club(id, nombre, direccion, id_municipio));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return clubes;
    }
    
    // Metodo sobrecargado para obtener list de clubes de un municipio
    public static List<Club> obtenerClubes(int id_municipio){
        List<Club> clubes = new ArrayList();
        
        ResultSet result;
        
        try{
            result = DBUtilidades.clubesDeUnMunicipio(id_municipio);
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String direccion = result.getString(3);
                    int id_municipio_c = result.getInt(4);
                    
                    clubes.add(new Club(id, nombre, direccion, id_municipio_c));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return clubes;
    }
    
    // Metodo sobrecargado para obtener list de clubes de un municipio
    public static List<Club> obtenerClubes(int id_municipio, int id_deporte){
        List<Club> clubes = new ArrayList();
        
        ResultSet result;
        
        try{
            result = DBUtilidades.clubesDeUnMunicipioYDeporte(id_municipio, id_deporte);
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String direccion = result.getString(3);
                    int id_municipio_c = result.getInt(4);
                    
                    clubes.add(new Club(id, nombre, direccion, id_municipio_c));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return clubes;
    }
    
    // Metodo sobrecargado para obtener list de clubes de un municipio
    public static List<Club> obtenerClubes(String nombre_club, int id_municipio, int id_deporte){
        List<Club> clubes = new ArrayList();
        
        ResultSet result;
        
        try{
            result = DBUtilidades.clubesDeUnMunicipioYDeporte(nombre_club, id_municipio, id_deporte);
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String direccion = result.getString(3);
                    int id_municipio_c = result.getInt(4);
                    
                    clubes.add(new Club(id, nombre, direccion, id_municipio_c));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return clubes;
    }
    
    public static List<Club> buscarClubesConDisciplinaYMunicipio(HttpServletRequest request, 
            int id_disciplina, int id_municipio){
            
        if(request.getParameter("nombre_buscar") != null){
            return obtenerClubes(request.getParameter("nombre_buscar"), id_municipio, id_disciplina);
        }else{
            return obtenerClubes(id_municipio, id_disciplina);
        }
    }
}
