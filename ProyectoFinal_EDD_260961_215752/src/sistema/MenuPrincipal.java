package sistema;

import entidades.Estudiante;
import entidades.Curso;
import estructuras.ArbolAVL;
import estructuras.ArbolBinarioBusqueda;
import estructuras.ArregloDinamico;
import estructuras.HashDictionary;
import excepciones.ArregloDinamicoException;
import java.util.Scanner;

/**
 *
 * @authors Juan Jose Meza Guarista 260961, Kevin Mendoza 215752
 */
public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        // 11 baldes 
        HashDictionary<Integer, Curso> cursos = new HashDictionary<>(11);

        int opcion = 0;

        while (opcion != 10) {
            System.out.println("\nMenu principal");
            System.out.println("***************************************");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante por matricula");
            System.out.println("3. Listar estudiantes ordenados por promedio");
            System.out.println("4. Agregar curso");
            System.out.println("5. Eliminar curso");
            System.out.println("6. Inscribir estudiante en curso");
            System.out.println("7. Desinscribir estudiante de curso");
            System.out.println("8. Listar estudiantes de un curso");
            System.out.println("9. Insertar datos de prueba");
            System.out.println("10. Salir");
            System.out.print("Opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ingresa un numero valido");
                opcion = 0;
                continue;
            }

            if (opcion == 1) {
                System.out.print("matricula: ");
                String mat = scanner.nextLine();
                System.out.print("nombre: ");
                String nom = scanner.nextLine();
                System.out.print("telefono: ");
                String tel = scanner.nextLine();
                System.out.print("correo: ");
                String cor = scanner.nextLine();
                System.out.print("direccion: ");
                String dir = scanner.nextLine();

                Estudiante nuevo = new Estudiante(mat, nom, tel, cor, dir);
                arbol.insertar(nuevo);
                System.out.println("estudiante registrado");

            } else if (opcion == 2) {
                System.out.print("matricula a buscar: ");
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

            } else if (opcion == 4) {
                System.out.print("nombre del curso: ");
                String nombreCurso = scanner.nextLine();
                System.out.print("clave del curso: ");
                int clave = 0;
                try {
                    clave = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ex) {
                    System.out.println("clave invalida");
                    continue;
                }

                if (cursos.contains(clave)) {
                    System.out.println("ya existe un curso con esa clave");
                } else {
                    Curso nuevoCurso = new Curso(nombreCurso, clave);
                    cursos.put(clave, nuevoCurso);
                    System.out.println("curso agregado: " + nuevoCurso.getNombre());
                }

            } else if (opcion == 5) {
                System.out.print("clave del curso a eliminar: ");
                int claveEliminar = 0;
                try {
                    claveEliminar = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ex) {
                    System.out.println("clave invalida");
                    continue;
                }

                Curso eliminado = cursos.remove(claveEliminar);
                if (eliminado != null) {
                    System.out.println("curso eliminado: " + eliminado.getNombre());
                } else {
                    System.out.println("no se encontro un curso con esa clave");
                }

            } else if (opcion == 6) {
                System.out.print("matricula del estudiante: ");
                String matEstudiante = scanner.nextLine();
                Estudiante est = arbol.buscar(matEstudiante);

                if (est == null) {
                    System.out.println("estudiante no encontrado");
                } else {
                    System.out.print("clave del curso: ");
                    int claveCurso = 0;
                    try {
                        claveCurso = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException ex) {
                        System.out.println("clave invalida");
                        continue;
                    }

                    Curso curso = cursos.get(claveCurso);
                    if (curso == null) {
                        System.out.println("curso no encontrado");
                    } else {
                        if (curso.inscribirEstudiante(est)) {
                            System.out.println("estudiante inscrito en: " + curso.getNombre());
                        } else {
                            System.out.println("estudiante ya estaba inscrito o hay un error");
                        }
                    }
                }

            } else if (opcion == 7) {
                System.out.print("matricula del estudiante: ");
                String matEstudiante = scanner.nextLine();
                System.out.print("clave del curso: ");
                int claveCurso = 0;
                try {
                    claveCurso = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ex) {
                    System.out.println("clave invalida");
                    continue;
                }

                Curso curso = cursos.get(claveCurso);
                if (curso == null) {
                    System.out.println("curso no encontrado");
                } else {
                    if (curso.desinscribirEstudiante(matEstudiante)) {
                        System.out.println("estudiante desinscrito de: " + curso.getNombre());
                    } else {
                        System.out.println("estudiante no estaba inscrito en este curso");
                    }
                }

            } else if (opcion == 8) {
                System.out.print("clave del curso: ");
                int claveCurso = 0;
                try {
                    claveCurso = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ex) {
                    System.out.println("clave invalida");
                    continue;
                }

                Curso curso = cursos.get(claveCurso);
                if (curso != null) {
                    curso.listarEstudiantes();
                } else {
                    System.out.println("curso no encontrado");
                }

            } else if (opcion == 9) {
                pruebas.insertDatos.cargar(arbol, cursos);

            } else if (opcion != 10) {
                System.out.println("opcion invalida");
            }
        }
    }
}
