package org.joaquinalvarez.argentinaprograma.ejercicios.integrador.controlador;

import org.joaquinalvarez.argentinaprograma.ejercicios.integrador.modelo.Alumno;
import org.joaquinalvarez.argentinaprograma.ejercicios.integrador.modelo.Inscripcion;
import org.joaquinalvarez.argentinaprograma.ejercicios.integrador.modelo.Materia;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GestorInscripcion {

    public List<Inscripcion> instanciarInscripciones(String lineasArchivo, List<Alumno> alumnosRegistrados, List<Materia> materiasRegistradas){
        //Convertimos el array en una lista
        String[] partesDeLinea = lineasArchivo.split(";");
        List<String> partesDeLineaList = Arrays.asList(partesDeLinea);

        //Recorremos el array para crear los objetos del tipo Inscripcion
        List<Inscripcion> inscripciones = new ArrayList<>();


        for(int i = 2; i < partesDeLineaList.size(); i = i + 2){
            boolean alumnoEncontrado = false;
            boolean materiaEncontrada = false;
            Inscripcion nuevaInscripcion = new Inscripcion();

            for(Alumno alumno : alumnosRegistrados){
                if(Objects.equals(alumno.getNombre(), partesDeLineaList.get(i))){
                    //System.out.println("ALUMNO ENCONTRADO " + partesDeLineaList.get(i));
                    nuevaInscripcion.setAlumno(alumno);
                    alumnoEncontrado = true;
                    break;
                }
            }
            for(Materia materia : materiasRegistradas){
                if(Objects.equals(materia.getNombre(), partesDeLineaList.get(i + 1))){
                    //System.out.println("MATERIA ENCONTRADA " + partesDeLineaList.get(i + 1));
                    nuevaInscripcion.setMateria(materia);
                    materiaEncontrada = true;
                    break;
                }
            }

            if(!alumnoEncontrado){
                System.out.println("ALUMNO NO ENCONTRADO: " + partesDeLineaList.get(i));
                Alumno alumno = new Alumno();
                alumno.setNombre(partesDeLineaList.get(i));
                nuevaInscripcion.setAlumno(alumno);
            }
            if(!materiaEncontrada){
                Materia materia = new Materia();
                materia.setNombre(partesDeLineaList.get(i + 1));
                nuevaInscripcion.setMateria(materia);
            }

            inscripciones.add(nuevaInscripcion);
        }

        //mostrarInscripciones(inscripciones);
        return inscripciones;
    }

    public void mostrarInscripciones(List<Inscripcion> inscripciones){
        for(Inscripcion inscripcion : inscripciones){
            System.out.println(inscripcion.getAlumno().getNombre());
            System.out.println(inscripcion.getMateria().getNombre());
        }
    }
}
