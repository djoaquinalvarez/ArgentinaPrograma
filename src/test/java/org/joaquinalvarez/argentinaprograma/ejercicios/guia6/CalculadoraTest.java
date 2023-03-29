package org.joaquinalvarez.argentinaprograma.ejercicios.guia6;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private static Calculadora calc;

    @BeforeAll
    static void beforeInit(){
        calc = new Calculadora();
    }

    @Test
    void sumarDosNumerosYDividirlos() {
        double numeroUno = 150;
        double numeroDos = 180;
        double numeroTres = 3;
        double resultadoEsperado = (150 + 180) / 3;

        assertEquals(resultadoEsperado, calc.dividir(calc.sumar(numeroUno, numeroDos), numeroTres));
    }

    @Test
    void restarDosNumerosYMultiplicarlosConError() {
        double numeroUno = 90;
        double numeroDos = 50;
        double numeroTres = 15;
        double resultadoNoEsperado = 605;

        assertNotEquals(resultadoNoEsperado, calc.multiplicar(calc.restar(numeroUno, numeroDos), numeroTres));
    }

    @Test
    void multiplicarDosNumeros() {
        double numeroUno = 80;
        double numeroDos = 3;

        double resultadoEsperado = numeroUno * numeroDos;
        assertEquals(resultadoEsperado, calc.multiplicar(numeroUno, numeroDos));
    }

    @Test
    void sumarDosNumerosYMultiplicarlos() {
        double numeroUno = 70;
        double numeroDos = 40;
        double numeroTres = 25;
        double resultadoNoEsperado = 2700;

        assertNotEquals(resultadoNoEsperado, calc.multiplicar(calc.sumar(numeroUno, numeroDos), numeroTres));
    }
}