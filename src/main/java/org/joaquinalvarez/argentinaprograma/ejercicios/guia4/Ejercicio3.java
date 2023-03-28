package org.joaquinalvarez.argentinaprograma.ejercicios.guia4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio3 {

    static final String[] ABECEDARIO = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public static void main(String[] args) throws IOException {

        //Definimos los archivos de entrada y salida
        String archivoEntrada = "C:\\Users\\Usuario\\Desktop\\Escritorio\\UTN\\Curso Argentina Programa - Java\\Argentina Programa - Curso Java\\src\\main\\java\\org\\joaquinalvarez\\argentinaprograma\\ejercicios\\guia4\\entrada.txt";
        String archivoSalida = "C:\\Users\\Usuario\\Desktop\\Escritorio\\UTN\\Curso Argentina Programa - Java\\Argentina Programa - Curso Java\\src\\main\\java\\org\\joaquinalvarez\\argentinaprograma\\ejercicios\\guia4\\salida.txt";


        //Recibimos los parametros por consola
        Scanner input = new Scanner(System.in);
        System.out.println("¿Qué operación desea realizar? \n (c) Codificación \n (d) Decodificación");
        String operacion = input.next();
        System.out.println("¿Qué desplazamiento desea aplicar? \n (1) Uno \n (2) Dos");
        int desplazamiento = input.nextInt();

        if(operacion.equalsIgnoreCase("c")){
            System.out.println("Ingrese a continuacion la frase que desea codificar seguida de un enter.");
            String frase = input.next();

            //Guardamos los datos de entrada en un archivo
            Files.writeString(Paths.get(archivoEntrada), frase + ";" + desplazamiento + ";" + operacion);
            codificar(frase, desplazamiento, archivoSalida);

        }else if(operacion.equalsIgnoreCase("d")){
            System.out.println("Ingrese a continuacion la frase que desea decodificar seguida de un enter.");
            String frase = input.next();

            //Guardamos los datos de entrada en un archivo
            Files.writeString(Paths.get(archivoEntrada), frase + ";" + desplazamiento + ";" + operacion);
            decodificar(frase, desplazamiento, archivoSalida);
        }

        /*
        System.out.println("EJERCICIO 2-A (CODIFICADOR)");
        codificar("Universidad Tecnologica Nacional", 1);

        System.out.println("EJERCICIO 2-B (DECODIFICADOR)");
        decodificar("vojwfstjebe*ufdopmphjdb*obdjpobm", 1);
         */
    }


    public static void codificar(String frase, int desplazamiento, String archivoSalida) throws IOException {
        //Declaración de variables a utilizar
        char letra; //contendrá individualmente cada una de las letras de la frase a codificar
        String fraseCodificada = ""; //almacenará el resultado de la codificación
        int indiceLetra; //almacenará el índice de las letras de la frase en el abecedario

        //recorremos cada letra de la frase para codificarla
        for(int i = 0; i < frase.length(); i++){
            //Obtenemos cada una de las letras de manera independiente
            letra = frase.charAt(i);
            String letraString = String.valueOf(letra);


            //Validamos algunos casos particulares sobre la letra seleccionada antes de recorrer el abecedario
            if(letraString.equalsIgnoreCase(" ")){
                fraseCodificada = fraseCodificada + "*";
            }else if(letraString.equalsIgnoreCase("z") && desplazamiento == 1){
                fraseCodificada = fraseCodificada + "a"; //si hay una z, y el desplazamiento es 1 ponemos una a
            }else if(letraString.equalsIgnoreCase("z") && desplazamiento == 2){
                fraseCodificada = fraseCodificada + "b"; //si hay una z, y el desplazamiento es 2 ponemos una b
            }else if(letraString.equalsIgnoreCase("y") && desplazamiento == 1){
                fraseCodificada = fraseCodificada + "z"; //si hay una w, y el desplazamiento es 1 ponemos una z
            } else if(letraString.equalsIgnoreCase("y") && desplazamiento == 2){
                fraseCodificada = fraseCodificada + "a"; //si hay una w, y el desplazamiento es 2 ponemos una a
            }

            //Obtenemos el índice de esa letra en el abecedario
            for(int j = 0; j < ABECEDARIO.length; j++){
                //Cambiamos la letra por su codificada
                if(ABECEDARIO[j].equalsIgnoreCase(letraString) && //si la letra coincide con alguna del abecedario
                        (!ABECEDARIO[j].equalsIgnoreCase("z") && !ABECEDARIO[j].equalsIgnoreCase("y")) && //y esa letra no es una z
                        !ABECEDARIO[j].equalsIgnoreCase(" ")){ //ni tampoco un espacio
                    fraseCodificada = fraseCodificada + ABECEDARIO[j + desplazamiento];
                    break;
                }
            }
        }
        //Imprimimos la frase codificada
        Files.writeString(Paths.get(archivoSalida), fraseCodificada + ";" + desplazamiento + ";" + "c");
        System.out.println("La frase ha sido codificada correctamente.");
    }

    public static void decodificar(String frase, int desplazamiento, String archivoSalida) throws IOException {
        //Declaración de variables a utilizar
        char letra; //contendrá individualmente cada una de las letras de la frase a codificar
        String fraseDecodificada = ""; //almacenará el resultado de la codificación

        //recorremos cada letra de la frase para codificarla
        for(int i = 0; i < frase.length(); i++){
            //Obtenemos cada una de las letras de manera independiente
            letra = frase.charAt(i);
            String letraString = String.valueOf(letra);

            //Validamos casos particulares sobre la letra extraida antes de recorrer el abecedario
            //Sobre todo para evitar un desbordamiento
            if(letraString.equals("*")){
                fraseDecodificada = fraseDecodificada + " ";
            }else if(letraString.equalsIgnoreCase("a") && desplazamiento == 1){
                fraseDecodificada = fraseDecodificada + "z"; //si hay una z, y el desplazamiento es 1 ponemos una a
            }else if(letraString.equalsIgnoreCase("a") && desplazamiento == 2){
                fraseDecodificada = fraseDecodificada + "y"; //si hay una z, y el desplazamiento es 2 ponemos una b
            }else if(letraString.equalsIgnoreCase("b") && desplazamiento == 1){
                fraseDecodificada = fraseDecodificada + "a"; //si hay una w, y el desplazamiento es 1 ponemos una z
            }else if(letraString.equalsIgnoreCase("b") && desplazamiento == 2){
                fraseDecodificada = fraseDecodificada + "z"; //si hay una w, y el desplazamiento es 2 ponemos una a
            }

            //Obtenemos el índice de esa letra en el abecedario
            for(int j = 0; j < ABECEDARIO.length; j++){
                //Cambiamos la letra por su codificada por su correspondiente
                if(ABECEDARIO[j].equalsIgnoreCase(letraString) && //si la letra coincide con alguna del abecedario
                        (!ABECEDARIO[j].equalsIgnoreCase("a") && !ABECEDARIO[j].equalsIgnoreCase("b")) && //y esa letra no es una z
                        !ABECEDARIO[j].equalsIgnoreCase("*")){ //ni tampoco un espacio
                    fraseDecodificada = fraseDecodificada + ABECEDARIO[j - desplazamiento];
                    break;
                }
            }
        }
        //Imprimimos la frase codificada
        Files.writeString(Paths.get(archivoSalida), fraseDecodificada + ";" + desplazamiento + ";" + "d");
        System.out.println("La frase ha sido decodificada correctamente.");
    }

}
