package org.joaquinalvarez.argentinaprograma.ejercicios.guia4;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Ejercicio2 {

    public static void main(String[] args) throws IOException {

        //Leemos el archivo
        //leerArchivo();

        //Definimos el archivo que vamos a leer
        String archivo = "C:\\Users\\Usuario\\Desktop\\Escritorio\\UTN\\Curso Argentina Programa - Java\\Argentina Programa - Curso Java\\src\\main\\java\\org\\joaquinalvarez\\argentinaprograma\\ejercicios\\guia4\\archivo.txt";

        //Obtenemos los parametros por consola
        Scanner input = new Scanner(System.in);
        System.out.println("¿Qué operación desea realizar? \n (s) Suma \n (m) Multiplicación");
        String operacion = input.next();
        if(operacion.equalsIgnoreCase("s")){
            sumar(archivo);
        }else if(operacion.equalsIgnoreCase("m")){
            multiplicar(archivo);
        }
        
    }

    public static void sumar(String archivo) throws IOException {
        int resultadoSuma = 0;
        String numerosSumados = "";
        for (String linea : Files.readAllLines(Paths.get(archivo))){
            numerosSumados = numerosSumados + linea + " + ";
            int numero = Integer.parseInt(linea);
            resultadoSuma += numero;
        }
        System.out.println(numerosSumados + "= " + resultadoSuma);
    }

    public static void multiplicar(String archivo) throws IOException {
        int resultadoMultiplicacion = 1;
        String numerosMultiplicados = "";
        for (String linea : Files.readAllLines(Paths.get(archivo))){
            numerosMultiplicados = numerosMultiplicados + linea + " * ";
            int numero = Integer.parseInt(linea);
            resultadoMultiplicacion *= numero;
        }
        System.out.println(numerosMultiplicados + "= " + resultadoMultiplicacion);
    }

    public static void leerArchivo() throws IOException {
        String archivo = "C:\\Users\\Usuario\\Desktop\\Escritorio\\UTN\\Curso Argentina Programa - Java\\Argentina Programa - Curso Java\\src\\main\\java\\org\\joaquinalvarez\\argentinaprograma\\ejercicios\\guia4\\archivo.txt";
        for (String linea : Files.readAllLines(Paths.get(archivo))){
            System.out.println(linea);
        }
    }
}
