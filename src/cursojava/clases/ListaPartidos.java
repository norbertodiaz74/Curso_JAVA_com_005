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
public class ListaPartidos {

    private List<Partido> partidos;
    private String nombreArchivo;

    public ListaPartidos() {
        this.partidos = new ArrayList<>();
        this.nombreArchivo = "partidos.csv";
    }

    public ListaPartidos(List<Partido> partidos, String nombreArchivo) {
        this.partidos = partidos;
        this.nombreArchivo = nombreArchivo;
    }

    // add, remove and get elements
    public void addPartido(Partido p) {
        this.partidos.add(p);
    }

    public void removePartido(Partido p) {
        this.partidos.remove(p);
    }

    public Partido getPartido(int idPartido) {
        Partido partido = null;
        for (Partido p : this.partidos) {
            if (p.getIdPartido() == idPartido) {
                partido = p;
                break;
            }
        }

        return partido;
    }

    public void cargarDeArchivo() {

        //tomar lista de equipos para construír los partidos
        ListaEquipos equipos = new ListaEquipos();
        equipos.cargarDeArchivo();

        // para las lineas del archivo csv
        String datosPartido;
        // para los datos individuales de cada linea
        String vectorPartido[];
        // para el objeto en memoria
        Partido partido;
        int fila = 0;

        Scanner sc = null;
        try {
            sc = new Scanner(new File(this.getNombreArchivo()));
            sc.useDelimiter("\n");   //setea el separador de los datos

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPartido = sc.next();
                fila++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1) {
                    continue;
                }

                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPartido = datosPartido.split(",");

                // graba el equipo en memoria
                //convertir un string a un entero;
                int idPartido = Integer.parseInt(vectorPartido[0]);
                int idEquipo1 = Integer.parseInt(vectorPartido[1]);
                int idEquipo2 = Integer.parseInt(vectorPartido[2]);
                int golesEquipo1 = Integer.parseInt(vectorPartido[3]);
                int golesEquipo2 = Integer.parseInt(vectorPartido[4]);

                //instanciar equipos
                Equipo equipo1 = equipos.getEquipo(idEquipo1);
                Equipo equipo2 = equipos.getEquipo(idEquipo2);

                // creo el objeto PARTIDO en memoria
                partido = new Partido(idPartido, equipo1, equipo2, golesEquipo1, golesEquipo2);

                // agregarlo a la lista en memoria
                this.addPartido(partido);
            }
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            //cierro scanner
            sc.close();
        }
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String listar() {
        String par = "\n";
        for (Partido p : this.partidos) {
            par += "id:" + p.getIdPartido()
                    + " eq1:" + p.getEquipo1().getNombre()
                    + " eq2:" + p.getEquipo2().getNombre()
                    + " goles1:" + p.getGolesEquipo1()
                    + " goles2:" + p.getGolesEquipo2() + "\n";
        }
        return par;
    }

    @Override
    public String toString() {
        return "ListaPartidos{" + "partidos=" + partidos + '}';
    }

}
