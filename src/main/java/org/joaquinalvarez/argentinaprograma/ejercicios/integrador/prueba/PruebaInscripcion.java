package org.joaquinalvarez.argentinaprograma.ejercicios.integrador.prueba;

import org.joaquinalvarez.argentinaprograma.ejercicios.integrador.controlador.GestorInscripcion;
import org.joaquinalvarez.argentinaprograma.ejercicios.integrador.modelo.Alumno;
import org.joaquinalvarez.argentinaprograma.ejercicios.integrador.modelo.Inscripcion;
import org.joaquinalvarez.argentinaprograma.ejercicios.integrador.modelo.ManipuladorCSV;
import org.joaquinalvarez.argentinaprograma.ejercicios.integrador.modelo.Materia;

import java.awt.image.IndexColorModel;
import java.util.ArrayList;
import java.util.List;

public class PruebaInscripcion {
    public static void main(String[] args) {

        //Creamos materias y alumnos de prueba
        Materia materia1 = new Materia();
        Materia materia2 = new Materia();
        Materia materia3 = new Materia();
        Materia materia4 = new Materia();
        //asignamos el nombre a la materias
        materia1.setNombre("Matematica");
        materia2.setNombre("Programacion I");
        materia3.setNombre("Analisis de Sistemas");
        materia4.setNombre("Fisica II");
        //asignamos las correlativas
        List<Materia> correlativas = new ArrayList<>();
        correlativas.add(materia1);
        materia2.setCorrelativas(correlativas);
        materia3.setCorrelativas(correlativas);
        materia4.setCorrelativas(correlativas);
        List<Materia> materiasRegistradas = new ArrayList<>();
        materiasRegistradas.add(materia1);
        materiasRegistradas.add(materia2);
        materiasRegistradas.add(materia3);
        materiasRegistradas.add(materia4);

        Alumno alumno1 = new Alumno();
        Alumno alumno2 = new Alumno();
        Alumno alumno3 = new Alumno();
        Alumno alumno4 = new Alumno();
        //Nombramos a los alumnos
        alumno1.setNombre("Javier Barrera");
        alumno2.setNombre("Joaquin Alvarez");
        alumno3.setNombre("Eder Zoy");
        alumno4.setNombre("Maria Becerra");
        //Cargamos sus materias aprobadas
        List<Materia> aprobadas = new ArrayList<>();
        aprobadas.add(materia1);
        alumno1.setMateriasAprobadas(aprobadas);
        alumno2.setMateriasAprobadas(aprobadas);

        List<Alumno> alumnosRegistrados = new ArrayList<>();
        alumnosRegistrados.add(alumno1);
        alumnosRegistrados.add(alumno2);
        alumnosRegistrados.add(alumno3);
        alumnosRegistrados.add(alumno4);


        //la del resto de los alumnnos no las cargamos, para aprovechar el caso de prueba

        ManipuladorCSV.leerArchivo();

        GestorInscripcion gestorInscripcion = new GestorInscripcion();
        System.out.println(ManipuladorCSV.getLineasConcatenadas());
        List<Inscripcion> inscripcionesRegistradas = gestorInscripcion.instanciarInscripciones(ManipuladorCSV.getLineasConcatenadas(), alumnosRegistrados, materiasRegistradas);


        for (Inscripcion inscripcion : inscripcionesRegistradas) {
            inscripcion.aprobada(alumnosRegistrados, materiasRegistradas);
        }
    }
}

