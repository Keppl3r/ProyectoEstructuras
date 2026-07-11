/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import entidades.Curso;
import entidades.Estudiante;
import estructuras.ArbolBinarioBusqueda;
import estructuras.HashDictionary;

/**
 *
 * @author keppler
 */
public class insertDatos {

    public static void cargar(ArbolBinarioBusqueda arbol, HashDictionary<Integer, Curso> cursos) {
        Estudiante e1 = new Estudiante("A1", "Althay Guzman", "111", "a@a.com", "Dir 1");
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

        Curso c1 = new Curso("Estructura de Datos", 101);
        Curso c2 = new Curso("Matematicas Discretas", 102);
        Curso c3 = new Curso("Bases de Datos", 103);

        cursos.put(c1.getClaveCurso(), c1);
        cursos.put(c2.getClaveCurso(), c2);
        cursos.put(c3.getClaveCurso(), c3);

        System.out.println("insert datos terminado\n");
    }
}
