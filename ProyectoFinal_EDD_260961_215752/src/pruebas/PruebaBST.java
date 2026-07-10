/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import entidades.Estudiante;
import estructuras.ArbolBinarioBusqueda;

/**
 *
 * @author Kevin Mendoza
 */
public class PruebaBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Prueba de arbol binario de busqueda con estudiantes");
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        System.out.println("agregando estudiantes");
        Estudiante e1 = new Estudiante("MAT-002", "Ana Guzman", "1111111111", "ana@o.com", "Urbi 1");
        Estudiante e2 = new Estudiante("MAT-001", "Carlos Carrillo", "2222222222", "carlos@o.com", "Urbi 2");
        Estudiante e3 = new Estudiante("MAT-003", "Fran Mora", "3333333333", "luis@o.com", "Sin vivienda");

        arbol.insertar(e1);
        arbol.insertar(e2);
        arbol.insertar(e3);
        System.out.println("3 estudiantes insertados en el arbol.");
        System.out.println("**********************************************");

        System.out.println("busqueda estudiante con matricula MAT-001:");
        Estudiante datoBusqueda = new Estudiante("MAT-001", "", "", "", "");
        Estudiante encontrado = arbol.buscar("MAT-001");

        if (encontrado != null) {
            System.out.println("Estudiante encontrado :");
            encontrado.imprimirDatos();
        } else {
            System.out.println("Estudiante no encontrado.");
        }
        System.out.println("**********************************************");

        System.out.println("busqueda estudiante inexistente:");
        Estudiante datoFallo = new Estudiante("MAT-999", "", "", "", "");
        Estudiante noEncontrado = arbol.buscar("MAT-999");

        if (noEncontrado == null) {
            System.out.println("Estudiante no encontrado (bien)");
        }
    }
}
