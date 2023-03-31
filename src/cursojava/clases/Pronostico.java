/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cursojava.clases;

/**
 *
 * @author fabia
 */
public class Pronostico {

    private int idPronostico;
    private int idParticipante; //propiedad agregada por mi, no estaba en modelo
    private Equipo equipo;
    private Partido partido;
    private char resultado;

    public Pronostico() {
        this.idPronostico = 0;
        this.idParticipante = 0;
        this.equipo = null;
        this.partido = null;
        this.resultado = 'E';
    }

    public Pronostico(int idPronostico, int idParticipante, Equipo equipo, Partido partido, char resultado) {
        this.idPronostico = idPronostico;
        this.idParticipante = idParticipante;
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }

    public int puntos() {
        return 1;
    }

    
    public int getIdPronostico() {
        return idPronostico;
    }

    public void setIdPronostico(int idPronostico) {
        this.idPronostico = idPronostico;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    @Override
    public String toString() {
        return "Pronostico{" + "idPronostico=" + idPronostico + ", idParticipante=" + idParticipante + ", equipo=" + equipo + ", partido=" + partido + ", resultado=" + resultado + '}';
    }

    
}
