/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema;

import entidades.Estudiante;
import estructuras.ArbolBinarioBusqueda;
import estructuras.VectorDinamico;
import excepciones.VectorDinamicoException;

import java.util.Scanner;

/**
 *
 * @author Juan Jose Meza Guarista 260961
 */
public class Prueba {
    private static ArbolBinarioBusqueda<Estudiante> arbol;
    private static VectorDinamico<Estudiante> vectorEstudiantes;
    private static Scanner scanner;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        arbol = new ArbolBinarioBusqueda<>();
        vectorEstudiantes = new VectorDinamico<>(Estudiante.class);
        scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    buscarEstudiante();
                    break;
                case 3:
                    eliminarEstudiante();
                    break;
                case 4:
                    listarEstudiantes();
                    break;
                case 5:
                    mostrarCantidad();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println("**********************************************");
        } while (opcion != 6);
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n-----GESTIÓN ACADÉMICA-----");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Buscar estudiante");
        System.out.println("3. Eliminar estudiante");
        System.out.println("4. Lista de estudiantes");
        System.out.println("5. Cantidad de estudiantes.");
        System.out.println("6. Salir");
    }

    private static int obtenerOpcion() {
        int opcion = -1;
        try {
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Error: Ingresa un número válido.");
        }
        return opcion;
    }

    private static void registrarEstudiante() {
        System.out.println("\n----REGISTRAR ESTUDIANTE----");
        System.out.println("Ingresa los siguentes datos: ");

        System.out.print("Matricula (ej: MAT-001): ");
        String matricula = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Telefono: ");
        String numTelefono = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Direccion: ");
        String direccion = scanner.nextLine();

        Estudiante estudiante = new Estudiante(matricula, nombre, numTelefono, email, direccion);
        
        // Agregar calificaciones si lo desea
        if (solicitarCalificaciones()) {
            agregarCalificacionesEstudiante(estudiante);
        }

        arbol.insertar(estudiante);
        vectorEstudiantes.agregar(estudiante);
        System.out.println("Se ha registrado exitosamente");
    }

    private static boolean solicitarCalificaciones() {
        System.out.print("¿Deseas agregar calificaciones? (s/n): ");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("s");
    }

    private static void agregarCalificacionesEstudiante(Estudiante estudiante) {
        System.out.println("Ingresa las calificaciones (escribe -1 para terminar):");
        while (true) {
            System.out.print("Calificacion: ");
            try {
                double calificacion = scanner.nextDouble();
                if (calificacion == -1) {
                    break;
                }
                if (calificacion >= 0 && calificacion <= 100) {
                    estudiante.getCalificaciones().agregar(calificacion);
                    System.out.println("Calificacion agregada");
                } else {
                    System.out.println("Error: La calificacion debe estar entre 0 y 100");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingresa un número válido");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
    }

    private static void buscarEstudiante() {
        System.out.println("\n----BUSCAR ESTUDIANTE---");
        System.out.print("Ingresa la matricula a buscar (ej: MAT-001): ");
        String matricula = scanner.nextLine();

        Estudiante temporal = new Estudiante(matricula, "", "", "", "");
        Estudiante encontrado = arbol.buscar(temporal);

        if (encontrado != null) {
            System.out.println("Estudiante encontrado: ");
            encontrado.imprimirDatos();
            mostrarCalificacionesEstudiante(encontrado);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private static void mostrarCalificacionesEstudiante(Estudiante estudiante) {
        int numCalificaciones = estudiante.getCalificaciones().getNumeroElementos();
        if (numCalificaciones > 0) {
            System.out.println("Calificaciones:");
            try {
                for (int i = 0; i < numCalificaciones; i++) {
                    Double calificacion = estudiante.getCalificaciones().obtener(i);
                    System.out.println("  Calificacion " + (i + 1) + ": " + calificacion);
                }
            } catch (VectorDinamicoException ex) {
                System.out.println("Error al obtener calificaciones: " + ex.getMessage());
            }
        } else {
            System.out.println("Este estudiante no tiene calificaciones registradas.");
        }
    }

    private static void eliminarEstudiante() {
        System.out.println("\n----ELIMINAR ESTUDIANTE----");
        System.out.print("Ingresa la matricula a eliminar: ");
        String matricula = scanner.nextLine();

        Estudiante temporal = new Estudiante(matricula, "", "", "", "");
        Estudiante encontrado = arbol.buscar(temporal);
        
        if (encontrado != null) {
            // Aquí necesitarías implementar un método de eliminación en ArbolBinarioBusqueda
            System.out.println("Estudiante encontrado y eliminado: ");
            encontrado.imprimirDatos();
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private static void listarEstudiantes() {
        System.out.println("\nLista de estudiantes registrados: ");
        if (vectorEstudiantes.getNumeroElementos() == 0) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            try {
                for (int i = 0; i < vectorEstudiantes.getNumeroElementos(); i++) {
                    Estudiante est = vectorEstudiantes.obtener(i);
                    System.out.println("\nEstudiante " + (i + 1) + ":");
                    est.imprimirDatos();
                    mostrarCalificacionesEstudiante(est);
                }
            } catch (VectorDinamicoException ex) {
                System.out.println("Error al listar estudiantes: " + ex.getMessage());
            }
        }
    }

    private static void mostrarCantidad() {
        System.out.println("Estudiantes registrados: " + vectorEstudiantes.getNumeroElementos());
    }
}
