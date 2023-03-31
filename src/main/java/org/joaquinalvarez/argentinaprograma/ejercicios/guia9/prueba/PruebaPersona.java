package org.joaquinalvarez.argentinaprograma.ejercicios.guia9.prueba;

import org.joaquinalvarez.argentinaprograma.ejercicios.guia9.modelo.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PruebaPersona {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();

        while(true){
            System.out.println("Ingrese a continuacion el nombre de una persona:");
            String nombre = scanner.next();

            System.out.println("Ahora ingrese el apellido de esa persona: ");
            String apellido = scanner.next();

            System.out.println("Ingrese la fecha de nacimiento de la persona, en el formato YYYY-MM-DD");
            String fechaNacimientoString = scanner.next();
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString);

            Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setFechaNacimiento(fechaNacimiento);

            personas.add(persona);

            System.out.println("Desea cargar a otra persona? y/n");
            String cargarOtraPersona = scanner.next();
            if(cargarOtraPersona.equalsIgnoreCase("n")){
                break;
            }
        }
        System.out.println("Desea imprimir por consola los datos de todas las personas registradas? y/n");
        String imprimir = scanner.next();

        if(imprimir.equalsIgnoreCase("y")){
            System.out.println("NOMBRE || APELLIDO || FECHA DE NACIMIENTO");
            for(Persona persona : personas){
                System.out.println(persona.getNombre() + " || " + persona.getApellido() + " || " + persona.getFechaNacimiento());
            }
        }
    }
}
