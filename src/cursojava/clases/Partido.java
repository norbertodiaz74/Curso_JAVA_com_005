/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cursojava.clases;

/**
 *
 * @author fabia
 */
public class Partido {

    private int idPartido;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido() {
        this.idPartido = 0;
        this.equipo1 = null;
        this.equipo2 = null;
        this.golesEquipo1 = 0;
        this.golesEquipo2 = 0;
    }

    public Partido(int idPartido, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.idPartido = idPartido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public char resultado(Equipo equipo) {

        //verificar que equipo pertenezca a este partido
        if (equipo.getIdEquipo() != this.equipo1.getIdEquipo()
                && equipo.getIdEquipo() != this.equipo2.getIdEquipo()) {
            
            //SALIR del método con X, equipo no pertenece a este partido
            return 'X';
        }
        
        //Asigno resultado en empate
        char resultado = 'E';

        if (this.golesEquipo1 != this.golesEquipo2) {
            
            //No es empate, averiguar resultado por equipo solicitado
            if (this.equipo1.getIdEquipo() == equipo.getIdEquipo()) {
                // por equipo 1
                if (this.golesEquipo1 > this.golesEquipo2) {
                    //gana equipo1
                    resultado = 'G';
                } else {
                    resultado = 'P';
                }
            } else {
                // por equipo 2
                if (this.golesEquipo2 > this.golesEquipo1) {
                    //gana equipo2
                    resultado = 'G';
                } else {
                    resultado = 'P';
                }
            }
        } else {
            
            //es empate, resultado ya asignado al principio
        }

        return resultado;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    @Override
    public String toString() {
        return "Partido{" + "idPartido=" + idPartido + ", equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", golesEquipo1=" + golesEquipo1 + ", golesEquipo2=" + golesEquipo2 + '}';
    }

}
