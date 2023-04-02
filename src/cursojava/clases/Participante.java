/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cursojava.clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabia
 */
public class Participante {

    private int idParticipante;
    private String nombre;
    private List<Pronostico> pronosticos;
    private int puntaje;

    public Participante() {
        this.idParticipante = 0;
        this.nombre = null;
        this.pronosticos = new ArrayList<>();
        this.puntaje = 0;
    }

    public Participante(int idParticipante, String nombre, List<Pronostico> pronosticos, int puntaje) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = pronosticos;
        this.puntaje = puntaje;
    }

    public void addPronostico(Pronostico p) {
        this.pronosticos.add(p);
    }

    public void cargarPronosticos(int idParticipante) {
        //cargar pronosticos del participante parámetro

        //cargo la lista completa de pronosticos en lp
        ListaPronosticos lp = new ListaPronosticos();
        lp.cargaDeArchivo();

        for (Pronostico p : lp.getPronosticos()) {
            if (p.getIdParticipante() == idParticipante) {
                this.addPronostico(p);
            }
        }
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        //return "Participante{" + "idParticipante=" + idParticipante + ", nombre=" + nombre + ", pronosticos=" + pronosticos + ", puntaje=" + puntaje + '}';
        return "idPartici:" + idParticipante + " nombre:" + nombre + ", pronosticos:" + pronosticos + " puntaje=" + puntaje;
    }

}
