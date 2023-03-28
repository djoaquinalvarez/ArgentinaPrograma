package org.joaquinalvarez.argentinaprograma.ejercicios.integrador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private String nombre;
    private List<Materia> correlativas;


    public Materia() {
        correlativas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public boolean puedeCursar(Alumno alumno){
        //TODO: implementar
        return true;
    }
}
