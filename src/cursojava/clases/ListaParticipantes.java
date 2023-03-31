/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cursojava.clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fabia
 */
public class ListaParticipantes {

    private List<Participante> participantes;
    private String nombreArchivo;

    public ListaParticipantes() {
        this.participantes = new ArrayList<>();
        this.nombreArchivo = "participantes.csv";
    }

    public ListaParticipantes(List<Participante> participantes, String nombreArchivo) {
        this.participantes = participantes;
        this.nombreArchivo = nombreArchivo;
    }

    public void addParticiante(Participante p) {
        this.participantes.add(p);
    }

    public void removeParticipante(Participante p) {
        this.participantes.remove(p);
    }

    public Participante getParticipante(int idParticipante) {
        Participante participante = null;
        for (Participante p : this.getParticipantes()) {
            if (p.getIdParticipante() == idParticipante) {
                participante = p;
                break;
            }
        }
        return participante;
    }

    public void cargaDeArchivo() {
        // para las lineas del archivo csv
        String datos;
        // para los datos individuales de cada linea
        String vector[];
        // para el objeto en memoria
        Participante participante;
        int fila = 0;

        Scanner sc = null;
        try {
            sc = new Scanner(new File(this.getNombreArchivo()));
            sc.useDelimiter("\n");   //setea el separador de los datos

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datos = sc.next();
                fila++;
                // si es la cabecera la descarto 
                if (fila == 1) {
                    continue;
                }

                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vector = datos.split(",");

                // graba el equipo en memoria
                //convertir un string a un entero;
                int idParticipante = Integer.parseInt(vector[0]);
                String nombre = vector[1];

                // crea el objeto en memoria
                Participante p = new Participante(idParticipante, nombre, new ArrayList<>(), 0);
                p.cargarPronosticos(idParticipante);

                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addParticiante(p);
            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            //cierro scanner
            sc.close();
        }
    }

    public void calcularPuntajes() {
        for (Participante p : this.getParticipantes()) {
            
        }
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String listar() {
        String data = "\n";
        for (Participante p : participantes) {
            data += "id:" + p.getIdParticipante() + " " + p.getNombre()
                    + " pronósticos:" + p.getPronosticos()
                    + " puntaje:" + p.getPuntaje() + "\n";
        }
        return data;
    }

    @Override
    public String toString() {
        return "ListaParticipantes{" + "participantes=" + participantes + ", nombreArchivo=" + nombreArchivo + '}';
    }

}
