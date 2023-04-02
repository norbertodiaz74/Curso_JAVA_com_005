/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cursojava;

import cursojava.clases.PronosticoDeportivo;

/**
 * @author fabian
 */
public class CursoJAVA {

    public static PronosticoDeportivo PRODE;
    
    public static void main(String[] args) {
             
        System.out.println ("Sistema de simulación de pronósticos deportivos.\n");     
        PRODE = new PronosticoDeportivo();
        PRODE.play();
       
    }

}
