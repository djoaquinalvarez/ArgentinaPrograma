package org.joaquinalvarez.argentinaprograma.ejercicios.guia1;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        /*
        *1. Vamos a practicar operaciones básicas con números
            a. Utilizando la sentencia while, imprima todos los números entre 2 variables “a”
                y “b”. Su código puede arrancar (por ejemplo):
                    int numeroInicio = 5;
                    int numeroFin = 14;
                // Se deberían mostrar los números:
                5,6,7,8,9,10,11,12,13,14
            b. A lo anterior, solo muestre los números pares
            c. A lo anterior, con una variable extra, elija si se deben mostrar los números
                pares o impares
            d. Utilizando la sentencia for, hacer lo mismo que en (b) pero invirtiendo el orden
        * */

//
//        System.out.println("EJERCICIO 1");
//        /*------------Punto A------------*/
//        System.out.println("Solucion del Punto A");
//        int numeroInicio, numeroFin;
//        numeroInicio = 5;
//        numeroFin = 14;
//
//        while(numeroInicio <= numeroFin) {
//            System.out.println(numeroInicio);
//            numeroInicio++;
//        }
//
//
//        /*------------Punto B------------*/
//        numeroInicio = 5;
//
//        System.out.println("Solucion del Punto B");
//        while(numeroInicio <= numeroFin) {
//            if(numeroInicio%2 == 0) {
//                System.out.println(numeroInicio);
//            }
//            numeroInicio++;
//        }
//
//        /*------------Punto C------------*/
//        numeroInicio = 5;
//        boolean mostrarNumerosPares = true;
//
//        System.out.println("Solucion del Punto C");
//        while(numeroInicio <= numeroFin) {
//            if(mostrarNumerosPares == true && numeroInicio%2 == 0) {
//                System.out.println(numeroInicio);
//            } else if (mostrarNumerosPares == false && numeroInicio%2 != 0) {
//                System.out.println(numeroInicio);
//            }
//            numeroInicio++;
//        }
//
//        /*------------Punto C------------*/
//        numeroInicio = 5;
//
//        System.out.println("Solucion del Punto D");
//
//        for(int i = numeroFin; i >= numeroInicio; i--) {
//            if(i%2 == 0) {
//                System.out.println(i);
//            }
//        }
//
//
//        System.out.println("EJERCICIO 2");
//        /*
//        * 2. Dado el siguiente texto, vamos a atacar el siguiente problema: “determinar si una
//            persona pertenece al segmento de ingresos altos”. Del i al iii, la idea es hacerlo en
//            papel y lápiz y sólo implementar el cuarto.
//                “Son hogares que declaran reunir alguna de las siguientes condiciones, considerando a
//                 todas y todos los convivientes:
//                    ● Ingresos mensuales totales del hogar equivalentes o superiores a $489.083
//                        (3,5 canastas básicas para un hogar tipo 2 según el INDEC).
//                    ● Tener 3 o más vehículos con una antigüedad menor a 5 años.
//                    ● Tener 3 o más inmuebles.
//                    ● Poseer una embarcación, una aeronave de lujo o ser titular de activos
//                        societarios que demuestren capacidad económica plena.”
//            Tomado de https://www.argentina.gob.ar/subsidios el 07/12/2022
//                a. Lea atentamente el texto, primero que nada piense cuáles son las variables de
//                    entrada.
//                b. Ordene las entradas y salidas como vimos en la tabla del ejemplo Monotributo
//                    en clase, también puede consultar este link
//                c. Piense en un arbol de decision, tambien como se vio en clase si puede resolver
//                    el problema, dadas las entradas
//        * */
//        /*
//        * SOLUCION PUNTO A
//        * Variables de entrada:
//        *   - Ingreso
//        *   - Cantidad de autos
//        *   - Antiguedad de autos
//        *   - Cantidad de inmuebles
//        *   - poseeEmbarcacion
//        *   - poseeAeronave
//        *   - esTitularActivo
//        *
//        * SOLUCION PUNTO B
//        * Ver en imagen
//        * */
//
//        System.out.println("Solucion del Punto D");
//        float ingresos;
//        int cantidadAutos;
//        int antiguedadAutos;
//        int cantidadInmuebles;
//        boolean poseeEmbarcacion;
//        boolean poseeAeronave;
//        boolean esTitularActivo;
//
//        //Validamos condiciones de categoria alta
//        if(ingresos >= 572385.50) {
//            if(cantidadAutos >= 3 && antiguedadAutos < 5) {
//                if (cantidadInmuebles >= 3) {
//                    if (poseeEmbarcacion == true || poseeAeronave == true || esTitularActivo == true) {
//                        System.out.println("Es categoria alta");
//                    }
//                }
//            }
//
//        //Validamos condiciones de categoria media
//        }else if(ingresos < 572385.50 && ingresos > 163539) {
//            if (cantidadAutos == 1 && antiguedadAutos < 3) {
//                if (cantidadInmuebles <= 2) {
//                    if (poseeEmbarcacion == false && poseeAeronave == false && esTitularActivo == false {
//                        System.out.println("Es categoria media");
//                    }
//                }
//            }
//
//        //Validamos condiciones de categoria baja
//        } else if (ingresos <= 163539) {
//            if (cantidadAutos == 0 && antiguedadAutos < 3) {
//                if (cantidadInmuebles <= 1) {
//                    if (poseeEmbarcacion == false && poseeAeronave == false && esTitularActivo == false) {
//                        System.out.println("Es categoria baja");
//                    }
//                }
//            }
//        }

    }
}
