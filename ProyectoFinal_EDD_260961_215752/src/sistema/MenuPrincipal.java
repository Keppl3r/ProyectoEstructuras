/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema;

import entidades.Estudiante;
import estructuras.ArbolAVL;
import estructuras.ArbolBinarioBusqueda;
import estructuras.ArregloDinamico;
import excepciones.ArregloDinamicoException;
import java.util.Scanner;

/**
 * @authors Juan Jose Meza Guarista 260961, Kevin Mendoza 215752
 */
public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

       //insert inicial
        Estudiante e1 = new Estudiante("A1", "Ana Guzman", "111", "a@a.com", "Dir 1");
        Estudiante e2 = new Estudiante("A2", "Carlos Carrillo", "222", "c@c.com", "Dir 2");
        Estudiante e3 = new Estudiante("A3", "Fran Mora", "333", "f@f.com", "Dir 3");

        e1.getCalificaciones().agregar(100.0);
        e1.getCalificaciones().agregar(90.0);
        e2.getCalificaciones().agregar(70.0);
        e2.getCalificaciones().agregar(80.0);
        e3.getCalificaciones().agregar(60.0);

        arbol.insertar(e1);
        arbol.insertar(e2);
        arbol.insertar(e3);

        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\nMenu principal");
            System.out.println("***************************************");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante por matricula");
            System.out.println("3. Listar estudiantes ordenados por promedio");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ingresa un numero valido");
                opcion = 0;
                continue;
            }

            if (opcion == 1) {
                System.out.print("matricula ");
                String mat = scanner.nextLine();
                System.out.print("nombre ");
                String nom = scanner.nextLine();
                System.out.print("telefono ");
                String tel = scanner.nextLine();
                System.out.print("correo ");
                String cor = scanner.nextLine();
                System.out.print("direccion ");
                String dir = scanner.nextLine();

                Estudiante nuevo = new Estudiante(mat, nom, tel, cor, dir);
                arbol.insertar(nuevo);
                System.out.println("estudiante registrado");

            } else if (opcion == 2) {
                System.out.print("matricula a buscar ");
                String mat = scanner.nextLine();
                Estudiante enc = arbol.buscar(mat);

                if (enc != null) {
                    enc.imprimirDatos();
                } else {
                    System.out.println("estudiante no encontrado");
                }

            } else if (opcion == 3) {
                ArbolAVL arbolAVL = new ArbolAVL();
                ArregloDinamico<Estudiante> todos = arbol.obtenerElementosEnOrden(Estudiante.class);

                for (int i = 0; i < todos.getNumeroElementos(); i++) {
                    try {
                        Estudiante est = todos.obtener(i);
                        double suma = 0;
                        int numCalifs = est.getCalificaciones().getNumeroElementos();

                        for (int j = 0; j < numCalifs; j++) {
                            suma += est.getCalificaciones().obtener(j);
                        }

                        double promedio = 0;
                        if (numCalifs > 0) {
                            promedio = suma / numCalifs;
                        }

                        arbolAVL.insertar(promedio, est);

                    } catch (ArregloDinamicoException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                System.out.println("\npromedios en orden ascendente");
                arbolAVL.imprimir();

            } else if (opcion != 4) {
                System.out.println("opcion invalida");
            }
        }
    }
}
