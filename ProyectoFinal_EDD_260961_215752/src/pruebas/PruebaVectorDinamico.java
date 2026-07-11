/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import entidades.Estudiante;
import excepciones.ArregloDinamicoException;

/**
 *
 * @author Kevin Mendoza
 */
public class PruebaVectorDinamico {

    public static void main(String[] args) {
        System.out.println("Prueba vector dinamico con estudiantes");

        System.out.println("agregando 1 estudiante");
        Estudiante estudiante1 = new Estudiante("AAA-001", "Kevin Mendoza", "6441666666", "kev@coo.com", "Monesi 666");
        estudiante1.imprimirDatos();
        System.out.println("**********************************************");

        System.out.println("agregando 6 calificaciones");
        estudiante1.getCalificaciones().agregar(90.5);
        estudiante1.getCalificaciones().agregar(85.0);
        estudiante1.getCalificaciones().agregar(100.0);
        estudiante1.getCalificaciones().agregar(78.5);
        estudiante1.getCalificaciones().agregar(92.0); //  lleno por la capacidad de 5
        estudiante1.getCalificaciones().agregar(88.0); // capacidad expandia

        System.out.println("calificaciones agregadas: " + estudiante1.getCalificaciones().getNumeroElementos());
        System.out.println("**********************************************");

        System.out.println("lista de calificaciones:");
        for (int i = 0; i < estudiante1.getCalificaciones().getNumeroElementos(); i++) {
            System.out.println("calificacion " + (i + 1) + ": " + estudiante1.getCalificaciones().obtener(i));
        }
        System.out.println("**********************************************");

        // excepcion personalizada
        System.out.println("Probando excepcion, pidiendo el indice 10 que no existe");
        try {
            estudiante1.getCalificaciones().obtener(10);
        } catch (ArregloDinamicoException ex) {
            System.out.println("excepcion vector dinamico activada: " + ex.getMessage());
        }
    }
}
