package Modelos;

/**
 *
 * @author CristianAlvarez
 */
public class Equipo {
    private int id;
    private String nombre, fecha_fundacion;

    public Equipo(int id, String nombre,  String fecha_fundacion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_fundacion = fecha_fundacion;
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

    public String getFecha_fundacion() {
        return fecha_fundacion;
    }

    public void setFecha_fundacion(String fecha_fundacion) {
        this.fecha_fundacion = fecha_fundacion;
    }
    
    
}
