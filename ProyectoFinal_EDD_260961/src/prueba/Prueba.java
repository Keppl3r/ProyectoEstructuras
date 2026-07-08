/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

import clases.Estudiante;
import java.util.Scanner;
import sistema.ArbolBinarioBusqueda;

/**
 *
 * @author Juan Jose Meza Guarista 260961
 */
public class Prueba {
    private static ArbolBinarioBusqueda<Estudiante> arbol;
    private static Scanner scanner;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        arbol = new ArbolBinarioBusqueda<>();
        scanner = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("-----GESTIÓN ACADÉMICA-----");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Lista de estudiantes");
            System.out.println("5. Cantidad de estudiantes.");
            System.out.println("6. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
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
                    System.out.println("Lista de estudiantes: ");
                    arbol.listarInOrden();
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
        }while(opcion != 6);
        scanner.close();
    }
    
    private static void registrarEstudiante(){
        System.out.println("\n----REGISTRAR ESTUDIANTE----");
        System.out.println("Ingresa los siguentes datos: ");
   
        System.out.println("Matricula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Telefono: ");
        int numTelefono = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Email: ");
        String email = scanner.nextLine();
        
        System.out.println("Direccion: ");
        String direccion = scanner.nextLine();
        
        Estudiante estudiante = new Estudiante(matricula, nombre, numTelefono, email, direccion);
        arbol.registrarEstudiante(estudiante);
        System.out.println("Se ha registrado exitosamente");
    }
    
    private static void buscarEstudiante(){
        System.out.println("\n----BUSCAR ESTUDIANTE---");
        System.out.println("Ingresa la matricula a buscar: ");
        int matricula = scanner.nextInt();
        
        Estudiante temporal = new Estudiante(matricula,"",0,"","");
        Estudiante encontrado = arbol.buscar(temporal);
        
        if(encontrado != null){
            System.out.println("Estudiante encontrado: ");
            System.out.println(encontrado);
        }else{
            System.err.println("Estudiante no encontrado.");
        }
    }
    
    private static void eliminarEstudiante(){
        System.out.println("\n----ELIMINAR ESTUDIANTE----");
        System.out.println("Ingresa la matricula a eliminar: ");
        int matricula = scanner.nextInt();
        
        Estudiante temporal = new Estudiante(matricula,"",0,"","");
        arbol.eliminarEstudiante(temporal);
    }
    
    private static void mostrarCantidad(){
        System.out.println("Estudiantes registrados: " + arbol.contar());
    }
    
}
