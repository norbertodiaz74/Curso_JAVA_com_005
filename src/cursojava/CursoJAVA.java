/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cursojava;

import cursojava.clases.PronosticoDeportivo;

/**
 *
 * @author fabian
 */
public class CursoJAVA {

    /**
     */
    public static PronosticoDeportivo PRODE;
    
    public static void main(String[] args) {
        // TODO code application logic here
        PRODE = new PronosticoDeportivo();
        PRODE.cargarEquipos();
        System.out.println("=== EQUIPOS ===");
        System.out.println(PRODE.listarEquipos());

        System.out.println("*".repeat(40));

        PRODE.cargarParticipantes();
        System.out.println("=== PARTICIPANTES ===");
        System.out.println(PRODE.listarParticipantes());

        System.out.println("*".repeat(40));

        PRODE.cargarPartidos();
        System.out.println("=== PARTIDOS ===");
        System.out.println(PRODE.listarPartidos());

        System.out.println("*".repeat(40));

        PRODE.cargarPronosticos();
        System.out.println("=== PRONOSTICO ===");
        System.out.println(PRODE.listarPronosticos());

    }
    
}
