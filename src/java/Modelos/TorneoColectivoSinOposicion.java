/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author CristianAlvarez
 */
public class TorneoColectivoSinOposicion extends Torneo {
    
    public TorneoColectivoSinOposicion(int id, String nombre, String fecha_inicio, String fecha_fin, String descripcion, int id_disciplina, int id_categoria) {
        super(id, nombre, fecha_inicio, fecha_fin, descripcion, id_disciplina, id_categoria);
    }
    
    
}
