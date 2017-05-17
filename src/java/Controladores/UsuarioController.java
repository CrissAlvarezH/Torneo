package Controladores;

import static Conexion.BDCrud.insertarUsuario;
import static Conexion.BDCrud.todosLosUsuarios;
import static Conexion.DBUtilidades.validarUsuario;
import Modelos.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Evy Andrades
 */
public class UsuarioController {
    
    public static boolean iniciarSesion(HttpServletRequest request) {
        int userid = Integer.parseInt(request.getParameter("id_usuario"));
        String password = encriptarPassword(request.getParameter("pass_usuario"));
        
        Boolean result = false;
        try {
            result = validarUsuario(userid, password);
        } catch (SQLException ex) {}
        
        if (result) {
            request.getSession().setAttribute("idusuario", userid);
            return true;
        }
        
        return false;
    }
    
    public static String encriptarPassword(String password) {
        String hash = "";
        try {
            MessageDigest sha256=MessageDigest.getInstance("SHA-256");
            sha256.update(password.getBytes("UTF-8"));
            byte[] digest = sha256.digest();
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<digest.length;i++){
                sb.append(String.format("%02x", digest[i]));
            }
            hash = sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {}
        
        return hash;
    }
    
    public static boolean registrarUsuario(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String sexo = request.getParameter("sexo");
        String password = encriptarPassword(request.getParameter("password"));
        
        Usuario user = new Usuario(id, nombre, apellidos, sexo, "usuario", password);
        
        Boolean result = false;
        
        try {
            result = insertarUsuario(user);
        } catch (SQLException e) {
            System.out.println(e.getClass()+": "+e.getMessage());
        }
        
        if (result) {
            request.getSession().setAttribute("idusuario", id);
            return true;
        }
        
        return false;
    }
    
    public static List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList();
        ResultSet result;
        try {
            result = todosLosUsuarios();
            if (result != null) {
                while (result.next()) {
                    int idusuario = Integer.parseInt(result.getString(1));
                    String nombre = result.getString(2);
                    String apellidos = result.getString(3);
                    String sexo = result.getString(4);
                    String rol = result.getString(5);
                    String pass = result.getString(6);
                    
                    Usuario user = new Usuario(idusuario, nombre, apellidos, sexo, rol, pass);
                    usuarios.add(user);
                }
            }
        } catch (SQLException ex) {}
        
        return usuarios;
    }
    
    
}
