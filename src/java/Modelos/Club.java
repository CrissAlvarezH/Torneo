package Modelos;

/**
 *
 * @author CristianAlvarez
 */
public class Club {
    private int id, id_municipio;
    private String nombre, direccion;

    public Club(int id, String nombre, String direccion, int id_municipio) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.id_municipio = id_municipio;
    }
    
    public Club(){
        this(0, "", "", 0);
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
