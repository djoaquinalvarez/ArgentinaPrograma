package org.joaquinalvarez.argentinaprograma.ejercicios.integrador.modelo;

import org.joaquinalvarez.argentinaprograma.ejercicios.integrador.controlador.GestorInscripcion;

import java.io.*;

public class ManipuladorCSV {

    private static BufferedReader lector; //lee el archivo
    private static String linea; //recibe la liena de cada fila

    private static String lineasConcatenadas = "";
    private static String partes[] = null; //almacena cada linea leida

    private static String rutaArchivoEntrada = "C:\\Users\\Usuario\\Desktop\\Escritorio\\UTN\\Curso Argentina Programa - Java\\Argentina Programa - Curso Java\\src\\main\\java\\org\\joaquinalvarez\\argentinaprograma\\ejercicios\\integrador\\inscripciones.csv";

    private static String rutaArchivoSalida = "C:\\Users\\Usuario\\Desktop\\Escritorio\\UTN\\Curso Argentina Programa - Java\\Argentina Programa - Curso Java\\src\\main\\java\\org\\joaquinalvarez\\argentinaprograma\\ejercicios\\integrador\\resultados.csv";


    public static void leerArchivo(){
        try{
            lector = new BufferedReader(new FileReader(rutaArchivoEntrada));
            while((linea = lector.readLine()) != null){
                lineasConcatenadas = lineasConcatenadas + linea + ";";
                //imprimirLinea();
                //System.out.println();
            }
            lector.close();
            linea = null;
            //partes = null;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void escribirArchivo(String alumno, String materia, String condicion){
        try{
            FileWriter fileWriter = new FileWriter(rutaArchivoSalida, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(alumno + ";" + materia + ";" + condicion);

            printWriter.flush();
            printWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void imprimirLinea(){
        for(int i = 0; i < partes.length; i++){
            System.out.print(partes[i] + " | ");
        }
    }

    public static String getLineasConcatenadas() {
        return lineasConcatenadas;
    }

    public static void setLineasConcatenadas(String lineasConcatenadas) {
        ManipuladorCSV.lineasConcatenadas = lineasConcatenadas;
    }
}
