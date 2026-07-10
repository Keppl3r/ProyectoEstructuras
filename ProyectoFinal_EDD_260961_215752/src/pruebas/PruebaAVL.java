/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import entidades.Estudiante;
import estructuras.ArbolAVL;

/**
 *
 * @author Kevin Mendoza
 */
public class PruebaAVL {
public static void main(String[] args) {
        System.out.println("prueba AVL");
        
        ArbolAVL arbolPromedios = new ArbolAVL();
        
        Estudiante e1 = new Estudiante("MAT-001", "Pedro", "111", "p@o.com", "Dir 1");
        Estudiante e2 = new Estudiante("MAT-002", "Ana", "222", "a@o.com", "Dir 2");
        Estudiante e3 = new Estudiante("MAT-003", "Luis", "333", "l@o.com", "Dir 3");
        Estudiante e4 = new Estudiante("MAT-004", "Maria", "444", "m@o.com", "Dir 4");
        
        System.out.println("insertando: Pedro 75.5, Ana 98.0, Luis 85.0, Maria 98.0");
        
        arbolPromedios.insertar(75.5, e1);
        arbolPromedios.insertar(98.0, e2);
        arbolPromedios.insertar(85.0, e3);
        arbolPromedios.insertar(98.0, e4); 
        
        System.out.println("**********************************************");
        System.out.println("promedios ");
        arbolPromedios.imprimir();
    }
}