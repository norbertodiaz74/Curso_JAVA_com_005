/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cursojava.clases;

/**
 *
 * @author fabia
 */
public class Equipo {

    private int idEquipo;
    private String nombre;
    private String descripcion;

    public Equipo() {
        this.idEquipo = 0;
        this.nombre = null;
        this.descripcion = null;
    }

    public Equipo(int idEquipo, String nombre, String descripcion) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdEquipo() {
        return this.idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        //return "Equipo{" + "idEquipo=" + idEquipo + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
        return nombre;
    }

}
