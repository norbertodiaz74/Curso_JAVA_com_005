/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cursojava.clases;

import java.io.IOException;

/**
 *
 * @author fabia
 */
public class PronosticoDeportivo {

    private ListaEquipos equipos;
    private ListaPartidos partidos;
    private ListaPronosticos pronosticos;
    private ListaParticipantes participantes;

    public PronosticoDeportivo() {
        equipos = new ListaEquipos();
        partidos = new ListaPartidos();
        pronosticos = new ListaPronosticos();
        participantes = new ListaParticipantes();
    }

    public void play() {
        // cargar y listar los equipos
        equipos.cargarDeArchivo();
        System.out.println("Los EQUIPOS cargados son: " + equipos.listar());

        
        // cargar y listar partidos
        partidos.cargarDeArchivo();
        System.out.println("\nLos PARTIDOS cargados son: " + partidos.listar());

        
        // cargar y listar pronosticos
        pronosticos.cargaDeArchivo(); 
        System.out.println("Los PRONÓSTICOS cargados son: " + pronosticos.listar());
        
        
        // cargar y listar participantes
        participantes.cargaDeArchivo();
        System.out.println("Los PARTICIPANTES cargados son: " + participantes.listar());
    
         
    }
}
