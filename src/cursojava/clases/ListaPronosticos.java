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
public class ListaPronosticos {

    private List<Pronostico> pronosticos;
    private String nombreArchivo;

    public ListaPronosticos() {
        this.pronosticos = new ArrayList<>();
        this.nombreArchivo = "pronosticos.csv";
    }

    public ListaPronosticos(List<Pronostico> pronosticos, String nombreArchivo) {
        this.pronosticos = pronosticos;
        this.nombreArchivo = nombreArchivo;
    }

    public void cargaDeArchivo() {

        //acceder a la lista de partidos para crear luego los pronósticos
        ListaPartidos partidos = new ListaPartidos();
        partidos.cargarDeArchivo();

        // para las lineas del archivo csv
        String datos;
        // para los datos individuales de cada linea
        String vector[];
        // para el objeto en memoria
        Pronostico pronostico;
        int fila = 0;

        Scanner sc = null;
        try {
            sc = new Scanner(new File(this.getNombreArchivo()));
            sc.useDelimiter("\n");   //setea el separador de los datos

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datos = sc.next();
                fila++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1) {
                    continue;
                }

                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vector = datos.split(",");

                // graba el equipo en memoria
                //convertir un string a un entero o char;
                int idParticipante = Integer.parseInt(vector[0]);
                int idPronostico = Integer.parseInt(vector[1]);
                int idPartido = Integer.parseInt(vector[2]);
                int equipoNro = Integer.parseInt(vector[3]);
                char resultado = vector[4].charAt(1);

                //instanciar partido por su ID
                Partido partido = partidos.getPartido(idPartido);

                //instanciar equipo DESDE el objeto partido
                Equipo equipo = null;
                if (equipoNro == 1) {
                    equipo = partido.getEquipo1();
                } else {
                    equipo = partido.getEquipo2();
                }

                // creo el objeto PRONOSTICO en memoria
                pronostico = new Pronostico(idPronostico, idParticipante, equipo, partido, resultado);

                // agregarlo a la lista en memoria
                this.addPronostico(pronostico);
            }
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            //cierro scanner
            sc.close();
        }
    }

    public String listar() {
        String data = "\n";
        for (Pronostico p : this.pronosticos) {
            data += "id:" + p.getIdPronostico()
                    + " idPartic:" + p.getIdParticipante()
                    + " equipo:" + p.getEquipo().getNombre()
                    + " partido:" + p.getPartido().getEquipo1().getNombre() + "/"
                    + p.getPartido().getEquipo2().getNombre()
                    + " pronóstico:" + p.getResultado() + "\n";
        }
        return data;
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void addPronostico(Pronostico p) {
        this.pronosticos.add(p);
    }

    public void removePronostico(Pronostico p) {
        this.pronosticos.remove(p);
    }

    public Pronostico getPronostico(int idPronostico) {
        Pronostico pronostico = null;
        for (Pronostico p : this.getPronosticos()) {
            if (p.getIdPronostico() == idPronostico) {
                pronostico = p;
                break;
            }
        }
        return pronostico;
    }

    @Override
    public String toString() {
        return "ListaPronosticos{" + "pronosticos=" + pronosticos + '}';
    }

}
