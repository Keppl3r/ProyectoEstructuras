/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import estructuras.LinkedList;

/**
 * Clase que representa un curso con lista de estudiantes inscritos
 * @author Juan Jose Meza Guarista 260961
 */
public class Curso {
    private String nombre;
    private int claveCurso;
    private LinkedList<Estudiante> estudiantesInscritos;

    public Curso(String nombre, int claveCurso) {
        this.nombre = nombre;
        this.claveCurso = claveCurso;
        this.estudiantesInscritos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getClaveCurso() {
        return claveCurso;
    }

    public void setClaveCurso(int claveCurso) {
        this.claveCurso = claveCurso;
    }

    public LinkedList<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    /**
     * Inscribir un estudiante en el curso
     * @param estudiante Estudiante a inscribir
     * @return true si la inscripción fue exitosa, false si ya estaba inscrito
     */
    public boolean inscribirEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            return false;
        }
        // Verificar que no esté ya inscrito
        for (Estudiante est : estudiantesInscritos) {
            if (est.getMatricula().equals(estudiante.getMatricula())) {
                return false; // Ya está inscrito
            }
        }
        estudiantesInscritos.append(estudiante);
        return true;
    }

    /**
     * Desinscribir un estudiante del curso
     * @param matricula Matrícula del estudiante a desinscribir
     * @return true si la desinscripción fue exitosa, false si no estaba inscrito
     */
    public boolean desinscribirEstudiante(String matricula) {
        for (Estudiante est : estudiantesInscritos) {
            if (est.getMatricula().equals(matricula)) {
                estudiantesInscritos.remove(est);
                return true;
            }
        }
        return false;
    }

    /**
     * Obtener el número de estudiantes inscritos
     * @return Cantidad de estudiantes inscritos
     */
    public int getNumEstudiantes() {
        return estudiantesInscritos.size();
    }

    /**
     * Verificar si un estudiante está inscrito en el curso
     * @param matricula Matrícula del estudiante
     * @return true si está inscrito, false en caso contrario
     */
    public boolean estudianteInscrito(String matricula) {
        for (Estudiante est : estudiantesInscritos) {
            if (est.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Listar todos los estudiantes inscritos en el curso
     */
    public void listarEstudiantes() {
        System.out.println("\n=== Estudiantes inscritos en " + nombre + " (Clave: " + claveCurso + ") ===");
        if (estudiantesInscritos.size() == 0) {
            System.out.println("No hay estudiantes inscritos");
            return;
        }
        int contador = 1;
        for (Estudiante est : estudiantesInscritos) {
            System.out.println(contador + ". " + est.getMatricula() + " - " + est.getNombre());
            contador++;
        }
        System.out.println("Total: " + estudiantesInscritos.size() + " estudiantes");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Clave del curso: " + claveCurso + ", Estudiantes inscritos: " + estudiantesInscritos.size();
    }
}
