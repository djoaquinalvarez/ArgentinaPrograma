package org.joaquinalvarez.argentinaprograma.ejercicios.guia9.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Persona {

    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String apellido;
    @Getter
    @Setter
    private LocalDate fechaNacimiento;

}
