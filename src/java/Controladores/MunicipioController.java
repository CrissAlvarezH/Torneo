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
public class MunicipioController {
    
    public static boolean insertarMunicipio(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("codigo"));
        String nombre = request.getParameter("nombre");
        String departamento = request.getParameter("departamento");
        
        Municipio municipio = new Municipio(id, nombre, departamento);
        
        boolean resultOK = false;
        try{
            resultOK = BDCrud.insertarMunicipio(municipio);
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return resultOK;
    }
    
    public static List<Municipio> buscarMunicipioPorNombre(HttpServletRequest request){
        if(request.getParameter("nombre_buscar") != null){
            System.out.println(request.getParameter("nombre_buscar"));
            return obtenerMunicipios(request.getParameter("nombre_buscar"));
        }else{
            return obtenerMunicipios();
        }
    }
    
    public static List<Municipio> obtenerMunicipios(){
        List<Municipio> municipios = new ArrayList();
        
        ResultSet result;
        try{
            result = DBUtilidades.todosLosMunicipios();
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String departamento = result.getString(3);
                    
                    municipios.add(new Municipio(id, nombre, departamento));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return municipios;
    }
    
    public static List<Municipio> obtenerMunicipios(String nombre_municipio){
        List<Municipio> municipios = new ArrayList();
        
        ResultSet result;
        try{
            result = DBUtilidades.municipioPorNombre(nombre_municipio);
            
            if(result != null){
                while(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String departamento = result.getString(3);
                    
                    System.out.println("Municipio: " + nombre);
                    
                    municipios.add(new Municipio(id, nombre, departamento));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return municipios;
    }
    
    public static Municipio obtenerMunicipio(int id_municipio){
        Municipio municipio = null;
        
        ResultSet result;
        try{
            result = BDCrud.seleccionarMunicipioPorId(id_municipio);
            
            if(result != null){
                if(result.next()){
                    int id = result.getInt(1);
                    String nombre = result.getString(2);
                    String departamento = result.getString(3);
                    
                    municipio = new Municipio(id, nombre, departamento);
                }
            }
        }catch(SQLException e){
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        return municipio;
    }
}
