package org.joaquinalvarez.argentinaprograma.ejercicios.guia4;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        System.out.println("EJERCICIO 1-(A/B/C)");

        //Para que se ingresen valores por consola, descomente el siguiente codigo

        ordenarNumerosPorParametro(0,0,0,'a');
    }


    public static void ordenarNumerosPorParametro(Integer numero1, Integer numero2, Integer numero3, char orden){
        if(numero1 == 0 && numero2 == 0 && numero3 == 0){
            Scanner input = new Scanner(System.in);
            System.out.println("Escriba 3 numeros presionando enter al final de cada uno");
            numero1 = input.nextInt();
            numero2 = input.nextInt();
            numero3 = input.nextInt();
        }
        //Declaramos un vector de enteros para guardar los numeros ordenados
        int[] numerosOrdenadosDecrecientemente;

        //Lo primero que hay que validar es el orden pasado como parametro
        if(orden == 'd'){
            //Ordenamos ascendentemente
            numerosOrdenadosDecrecientemente = ordenarMenorAMayor(numero1, numero2, numero3);
            for (int numero : numerosOrdenadosDecrecientemente) {
                System.out.print(numero + " "); //imprimimos en pantalla
            }
        }else{
            numerosOrdenadosDecrecientemente = ordenarMenorAMayor(numero1, numero2, numero3);
            //Invertimos el orden de los numeros en el vector
            int variableAuxiliar = numerosOrdenadosDecrecientemente[2];
            numerosOrdenadosDecrecientemente[2] = numerosOrdenadosDecrecientemente[0]; //al ultimo lo ponemos primero
            numerosOrdenadosDecrecientemente[0] = variableAuxiliar;//al ultimo lo ponemos primero
            for (int numero : numerosOrdenadosDecrecientemente) {
                System.out.print(numero + " "); //imprimimos en pantalla
            }
        }
        System.out.println();//salto de linea
    }


    public static int[] ordenarMenorAMayor(int numero1, int numero2, int numero3){
        //declaramos un vector de enteros para almacenar los numeros ordenados
        int[] numerosOrdenados = new int[3];
        if(numero1 > numero2 && numero2 > numero3){
            numerosOrdenados[0] = numero1;
            numerosOrdenados[1] = numero2;
            numerosOrdenados[2] = numero3;
        }else if(numero2 < numero3 && numero3 < numero1){
            numerosOrdenados[0] = numero1;
            numerosOrdenados[1] = numero3;
            numerosOrdenados[2] = numero2;
        }else if(numero1 < numero2 && numero2 < numero3){
            numerosOrdenados[0] = numero3;
            numerosOrdenados[1] = numero2;
            numerosOrdenados[2] = numero1;
        }else if(numero1 > numero3 && numero2 > numero1){
            numerosOrdenados[0] = numero2;
            numerosOrdenados[1] = numero1;
            numerosOrdenados[2] = numero3;
        }else if(numero1 < numero2 && numero2 > numero3){
            numerosOrdenados[0] = numero2;
            numerosOrdenados[1] = numero3;
            numerosOrdenados[2] = numero1;
        }else if(numero2 < numero1 && numero1 < numero3){
            numerosOrdenados[0] = numero3;
            numerosOrdenados[1] = numero1;
            numerosOrdenados[2] = numero2;
        }
        //Retornamos un vector con los numeros ordenados de mayor a menor
        return numerosOrdenados;
    }
}
