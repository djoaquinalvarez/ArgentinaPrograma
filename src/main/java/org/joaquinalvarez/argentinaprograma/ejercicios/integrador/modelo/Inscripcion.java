package org.joaquinalvarez.argentinaprograma.ejercicios.integrador.modelo;

import java.time.LocalDate;
import java.util.List;

public class Inscripcion {

    private Alumno alumno;
    private Materia materia;
    private LocalDate fecha;


    public Inscripcion() {
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int aprobada(List<Alumno> alumnosRegistrados, List<Materia> materiasRegistradas) {
        //TODO: implementar
        List<Materia> materiasAprobadasDelAlumno = this.alumno.getMateriasAprobadas();
        List<Materia> materiasCorrelativas = this.materia.getCorrelativas();

        //Validamos que la materia y el alumno esten registrados
        boolean esAlumnoRegistrado = false;
        for (Alumno alumno : alumnosRegistrados) {
            if (alumno.getNombre().equalsIgnoreCase(this.alumno.getNombre())) {
                esAlumnoRegistrado = true;
                break;
            }
        }

        boolean esMateriaRegistrada = false;
        for (Materia materia : materiasRegistradas) {
            if (materia.getNombre().equalsIgnoreCase(this.materia.getNombre())) {
                esMateriaRegistrada = true;
                break;
            }
        }


        int contadorCorrelativasAprobadas = 0;
        for (int i = 0; i < materiasCorrelativas.size(); i++) {
            for (int j = 0; j < materiasAprobadasDelAlumno.size(); j++) {
                if (materiasCorrelativas.get(i).getNombre().equalsIgnoreCase(materiasAprobadasDelAlumno.get(j).getNombre())) {
                    contadorCorrelativasAprobadas++;
                }
            }
        }

        if (contadorCorrelativasAprobadas == materiasCorrelativas.size() && esMateriaRegistrada && esAlumnoRegistrado) {
            //System.out.println("El alumno " + this.alumno.getNombre() + " ha registrado correctamente la inscripcion para la materia " + this.materia.getNombre());
            ManipuladorCSV.escribirArchivo(this.alumno.getNombre(), this.materia.getNombre(), "APROBADA");
            System.out.println(this.alumno.getNombre() + " || " + this.materia.getNombre() + " || " + "APROBADA");
            return 1;
        } else if (contadorCorrelativasAprobadas == materiasCorrelativas.size() && !esMateriaRegistrada && esAlumnoRegistrado) {
            //System.out.println("El alumno " + this.alumno.getNombre() + " no tiene todas las materias requeridas para la inscripcion en la materia " + this.materia.getNombre());
            ManipuladorCSV.escribirArchivo(this.alumno.getNombre(), this.materia.getNombre(), "DESAPROBADA: La materia no ha sido encontrada");
            System.out.println(this.alumno.getNombre() + " || " + this.materia.getNombre() + " || " + "DESAPROBADA: La materia no ha sido encontrada");
            return 0;
        } else if (contadorCorrelativasAprobadas == materiasCorrelativas.size() && esMateriaRegistrada && !esAlumnoRegistrado) {
            ManipuladorCSV.escribirArchivo(this.alumno.getNombre(), this.materia.getNombre(), "DESAPROBADA: El alumno no ha sido encontrado");
            System.out.println(this.alumno.getNombre() + " || " + this.materia.getNombre() + " || " + "DESAPROBADA: El alumno no ha sido encontrado");
            return 0;
        } else if (contadorCorrelativasAprobadas == materiasCorrelativas.size() && !esMateriaRegistrada && !esAlumnoRegistrado) {
            ManipuladorCSV.escribirArchivo(this.alumno.getNombre(), this.materia.getNombre(), "DESAPROBADA: La materia y el alumno no ha sido encontrados");
            System.out.println(this.alumno.getNombre() + " || " + this.materia.getNombre() + " || " + "DESAPROBADA: La materia y el alumno no ha sido encontrados");
            return 0;
        } else {
            ManipuladorCSV.escribirArchivo(this.alumno.getNombre(), this.materia.getNombre(), "DESAPROBADA: faltan correlativas");
            System.out.println(this.alumno.getNombre() + " || " + this.materia.getNombre() + " || " + "DESAPROBADA: faltan correlativas");
            return 0;
        }
    }
}
