package org.joaquinalvarez.argentinaprograma.ejercicios.guia3;

import java.util.Objects;

public class Ejercicio2 {
    //Declaramos un array del tipo String con cada letra del abecedario
        //Dato de color: a las variables que almacenan valores que no pueden ser modificados (cosntantes) se las nombra
        //con todas las letras de su nombre en mayuscula.
    static final String[] ABECEDARIO = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public static void main(String[] args) {

        System.out.println("EJERCICIO 2-A (CODIFICADOR)");
        codificar("Universidad Tecnologica Nacional", 1);

        System.out.println("EJERCICIO 2-B (DECODIFICADOR)");
        decodificar("vojwfstjebe*ufdopmphjdb*obdjpobm", 1);
    }


    public static void codificar(String frase, int desplazamiento){
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
        System.out.println(frase + " ====> " + fraseCodificada);

    }

    public static void decodificar(String frase, int desplazamiento){
        //Declaración de variables a utilizar
        char letra; //contendrá individualmente cada una de las letras de la frase a codificar
        String fraseCodificada = ""; //almacenará el resultado de la codificación

        //recorremos cada letra de la frase para codificarla
        for(int i = 0; i < frase.length(); i++){
            //Obtenemos cada una de las letras de manera independiente
            letra = frase.charAt(i);
            String letraString = String.valueOf(letra);

            //Validamos casos particulares sobre la letra extraida antes de recorrer el abecedario
            //Sobre todo para evitar un desbordamiento
            if(letraString.equals("*")){
                fraseCodificada = fraseCodificada + " ";
            }else if(letraString.equalsIgnoreCase("a") && desplazamiento == 1){
                fraseCodificada = fraseCodificada + "z"; //si hay una z, y el desplazamiento es 1 ponemos una a
            }else if(letraString.equalsIgnoreCase("a") && desplazamiento == 2){
                fraseCodificada = fraseCodificada + "y"; //si hay una z, y el desplazamiento es 2 ponemos una b
            }else if(letraString.equalsIgnoreCase("b") && desplazamiento == 1){
                fraseCodificada = fraseCodificada + "a"; //si hay una w, y el desplazamiento es 1 ponemos una z
            }else if(letraString.equalsIgnoreCase("b") && desplazamiento == 2){
                fraseCodificada = fraseCodificada + "z"; //si hay una w, y el desplazamiento es 2 ponemos una a
            }

            //Obtenemos el índice de esa letra en el abecedario
            for(int j = 0; j < ABECEDARIO.length; j++){
                //Cambiamos la letra por su codificada por su correspondiente
                if(ABECEDARIO[j].equalsIgnoreCase(letraString) && //si la letra coincide con alguna del abecedario
                        (!ABECEDARIO[j].equalsIgnoreCase("a") && !ABECEDARIO[j].equalsIgnoreCase("b")) && //y esa letra no es una z
                        !ABECEDARIO[j].equalsIgnoreCase("*")){ //ni tampoco un espacio
                    fraseCodificada = fraseCodificada + ABECEDARIO[j - desplazamiento];
                    break;
                }
            }
        }
        //Imprimimos la frase codificada
        System.out.println(frase + " ====> " + fraseCodificada);

    }
}
