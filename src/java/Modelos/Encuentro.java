package Modelos;

/**
 *
 * @author CristianAlvarez
 */
public class Encuentro {
    private int id;
    private String ubicacion, fecha, hora;

    public Encuentro(int id, String ubicacion, String fecha, String hora) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
