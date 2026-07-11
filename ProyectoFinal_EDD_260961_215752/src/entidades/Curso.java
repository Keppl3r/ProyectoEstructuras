/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import estructuras.LinkedList;

/**
 * Clase que representa un curso con lista de estudiantes inscritos y lista de espera
 * @author Juan Jose Meza Guarista 260961, Kevin Mendoza 215752
 */
public class Curso {
    private String nombre;
    private int claveCurso;
    private LinkedList<Estudiante> estudiantesInscritos;
    private LinkedList<Estudiante> listaEspera;
    private final int CAPACIDAD_MAXIMA = 20;

    public Curso(String nombre, int claveCurso) {
        this.nombre = nombre;
        this.claveCurso = claveCurso;
        this.estudiantesInscritos = new LinkedList<>();
        this.listaEspera = new LinkedList<>();
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

    public LinkedList<Estudiante> getListaEspera() {
        return listaEspera;
    }
    
    /**
     * Inscribir un estudiante en el curso
     * Si hay cupo, se agrega a la lista de inscritos
     * Si no hay cupo, se agrega a la lista de espera
     * @param estudiante Estudiante a inscribir
     * @return 1 si se inscribió, 2 si fue a lista de espera, 0 si hay error
     */
    public int inscribirEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            return 0;
        }
        
        // Verificar que no esté ya inscrito
        for (Estudiante est : estudiantesInscritos) {
            if (est.getMatricula().equals(estudiante.getMatricula())) {
                return 0; // Ya está inscrito
            }
        }
        
        // Verificar que no esté en lista de espera
        for (Estudiante est : listaEspera) {
            if (est.getMatricula().equals(estudiante.getMatricula())) {
                return 0; // Ya está en lista de espera
            }
        }
        
        // Si hay cupo, inscribir
        if (estudiantesInscritos.size() < CAPACIDAD_MAXIMA) {
            estudiantesInscritos.append(estudiante);
            return 1; // Inscrito exitosamente
        } else {
            // Si no hay cupo, agregar a lista de espera
            listaEspera.append(estudiante);
            return 2; // Agregado a lista de espera
        }
    }

    /**
     * Desinscribir un estudiante del curso
     * Si se desinscribe, el primer estudiante de lista de espera se mueve a inscritos
     * @param matricula Matrícula del estudiante a desinscribir
     * @return true si la desinscripción fue exitosa, false si no estaba inscrito
     */
    public boolean desinscribirEstudiante(String matricula) {
        for (Estudiante est : estudiantesInscritos) {
            if (est.getMatricula().equals(matricula)) {
                estudiantesInscritos.remove(est);
                
                // Si hay estudiantes en lista de espera, mover el primero a inscritos
                if (listaEspera.size() > 0) {
                    // Obtener el primer elemento de la lista de espera
                    LinkedList<Estudiante> temp = listaEspera;
                    Estudiante primerEnEspera = null;
                    int indice = 0;
                    for (Estudiante estEspera : temp) {
                        primerEnEspera = estEspera;
                        break;
                    }
                    
                    if (primerEnEspera != null) {
                        listaEspera.remove(primerEnEspera);
                        estudiantesInscritos.append(primerEnEspera);
                    }
                }
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
     * Obtener el número de estudiantes en lista de espera
     * @return Cantidad de estudiantes en lista de espera
     */
    public int getNumEnEspera() {
        return listaEspera.size();
    }

    /**
     * Obtener la capacidad máxima del curso
     * @return Capacidad máxima
     */
    public int getCapacidadMaxima() {
        return CAPACIDAD_MAXIMA;
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
     * Verificar si un estudiante está en lista de espera
     * @param matricula Matrícula del estudiante
     * @return true si está en lista de espera, false en caso contrario
     */
    public boolean estudianteEnEspera(String matricula) {
        for (Estudiante est : listaEspera) {
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
        System.out.println("\n=== Curso: " + nombre + " (Clave: " + claveCurso + ") ===");
        System.out.println("Capacidad: " + estudiantesInscritos.size() + "/" + CAPACIDAD_MAXIMA);
        
        System.out.println("\n--- Estudiantes Inscritos ---");
        if (estudiantesInscritos.size() == 0) {
            System.out.println("No hay estudiantes inscritos");
        } else {
            int contador = 1;
            for (Estudiante est : estudiantesInscritos) {
                System.out.println(contador + ". " + est.getMatricula() + " - " + est.getNombre());
                contador++;
            }
        }
        
        System.out.println("\n--- Lista de Espera ---");
        if (listaEspera.size() == 0) {
            System.out.println("No hay estudiantes en lista de espera");
        } else {
            int contador = 1;
            for (Estudiante est : listaEspera) {
                System.out.println(contador + ". " + est.getMatricula() + " - " + est.getNombre());
                contador++;
            }
        }
        System.out.println("Total en espera: " + listaEspera.size());
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Clave: " + claveCurso + 
               ", Inscritos: " + estudiantesInscritos.size() + "/" + CAPACIDAD_MAXIMA + 
               ", En espera: " + listaEspera.size();
    }
}
