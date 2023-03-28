package org.joaquinalvarez.argentinaprograma.ejercicios.guia3;

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("EJERCICIO 1-A");
        contarCantidadApariciones("Argentina salió campeón",'a');


        System.out.println("EJERCICIO 1-B");
        ordenarNumerosPorParametro(22,3,45,'a');


        System.out.println("EJERCICIO 1-C");
        int[] nums = {1,2,3};
        sumarNumerosMayoresA(nums, 2);

    }


    public static void contarCantidadApariciones(String frase, char caracter){
        //Recibimos por parametro una frase y un caracter para contar sus apariciones en dicha frase

        //Definimos una variable para obtener cada letra de la frase y un contador
        char letraDeFrase;
        int contador = 0;

        //Recorremos cada uno de los caracteres de la frase
        for(int i = 0; i < frase.length(); i++){
            letraDeFrase = frase.charAt(i); //Obtenemos individualmente cada caracter
            if (letraDeFrase == caracter){
                contador++; //Si se cumple la condicion, incrementamos el contador en 1
            }
        }

        //Imprimimos el contador
        System.out.println("La cantidad de apariciones del caracter \"" + caracter + "\" en la frase \"" + frase + "\" es: " + contador);
    }


    /*
    * Decidí separar la lógica del ordenamiento en dos métodos para poder reutilizar el codigo tanto para ordenar
    * crecientemente, como para ordenar decrecientemente utilizando el mismo bloque de codigo.
    * */
    public static void ordenarNumerosPorParametro(Integer numero1, Integer numero2, Integer numero3, char orden){
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


    public static void sumarNumerosMayoresA(int[] numeros, Integer numeroReferencia){
        //Declaramos una variable para almacenar el resultado de la suma
        int resultado = 0;

        //recorremos el vector y comprobamos la condicion de suma con un IF
        for(int numero : numeros){
            if (numero > numeroReferencia) {
                resultado = resultado + numero;
            }
        }

        //Imprimimos el resultado en pantalla
        System.out.println("El resultado de la suma es: " + resultado);
    }
}
