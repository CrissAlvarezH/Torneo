package Modelos;

/**
 *
 * @author CristianAlvarez
 */
public class Categoria {
    private int id;
    private String tipo, descripcion, genero;

    public Categoria(int id, String tipo, String descripcion, String genero) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
