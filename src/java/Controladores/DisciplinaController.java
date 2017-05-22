package Controladores;

import Conexion.BDCrud;
import Conexion.DBUtilidades;
import Modelos.Disciplina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author CristianAlvarez
 */
public class DisciplinaController {
    
    public static boolean insertarDisciplina(HttpServletRequest  request){
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        
        Disciplina disciplina = new Disciplina(id, nombre, descripcion);
        
        boolean resultOK = false;
        try{
            resultOK = BDCrud.insertarDisciplina(disciplina);
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return resultOK;
    }
    
    public static List<Disciplina> obtenerDisciplinas(){
        List<Disciplina> disciplinas = new ArrayList();
        
        ResultSet result;
        try{
            result = DBUtilidades.todosLasDisciplinas();
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String descripcion = result.getString(3);
                    
                    disciplinas.add(new Disciplina(id, nombre, descripcion));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return disciplinas;
    }
    
    public static List<Disciplina> obtenerDisciplinas(int id_club){
        List<Disciplina> disciplinas = new ArrayList();
        
        ResultSet result;
        try{
            result = DBUtilidades.disciplinasDeUnClub(id_club);
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String descripcion = result.getString(3);
                    
                    disciplinas.add(new Disciplina(id, nombre, descripcion));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return disciplinas;
    }
    
    public static List<Disciplina> obtenerDisciplinasDeMunicipio(int id_municipio){
        List<Disciplina> disciplinas = new ArrayList();
        
        ResultSet result;
        try{
            result = DBUtilidades.disciplinasDeUnMunicipio(id_municipio);
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String descripcion = result.getString(3);
                    
                    disciplinas.add(new Disciplina(id, nombre, descripcion));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return disciplinas;
    }
}
