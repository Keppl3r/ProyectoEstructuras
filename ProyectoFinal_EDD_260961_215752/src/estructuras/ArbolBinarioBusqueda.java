/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import entidades.Estudiante;
import excepciones.TreeException;
import interfaces.ITree;

/**
 *
 * @author keppler
 */
public class ArbolBinarioBusqueda implements ITree<Estudiante> {

    protected NodoArbolBinario<Estudiante> raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public void insertar(Estudiante dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private NodoArbolBinario<Estudiante> insertarRecursivo(NodoArbolBinario<Estudiante> nodo, Estudiante dato) {
        if (nodo == null) {
            return new NodoArbolBinario<>(dato);
        }
        int comparacion = dato.getMatricula().compareTo(nodo.getDato().getMatricula());

        if (comparacion < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), dato));
        } else if (comparacion > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), dato));
        }
        return nodo;
    }

    public Estudiante buscar(String matriculaBuscar) {
        return buscarRecursivo(raiz, matriculaBuscar);
    }

    private Estudiante buscarRecursivo(NodoArbolBinario<Estudiante> nodo, String matriculaBuscar) {
        if (nodo == null) {
            return null;
        }

        int comparacion = matriculaBuscar.compareTo(nodo.getDato().getMatricula());

        if (comparacion == 0) {
            return nodo.getDato();
        } else if (comparacion < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), matriculaBuscar);
        } else {
            return buscarRecursivo(nodo.getDerecho(), matriculaBuscar);
        }
    }

    @Override
    public Estudiante getDatoRaiz() throws TreeException {
        if (vacio()) {
            throw new TreeException("arbol vacio");
        }
        return raiz.getDato();
    }

    public ArregloDinamico<Estudiante> obtenerElementosEnOrden(Class<Estudiante> tipo) {
        ArregloDinamico<Estudiante> vector = new ArregloDinamico<>(tipo);
        recorrer(raiz, vector);
        return vector;
    }

    private void recorrer(NodoArbolBinario<Estudiante> nodo, ArregloDinamico<Estudiante> vector) {
        if (nodo != null) {
            recorrer(nodo.getIzquierdo(), vector);
            vector.agregar(nodo.getDato());
            recorrer(nodo.getDerecho(), vector);
        }
    }

    @Override
    public boolean vacio() {
        return raiz == null;
    }

    @Override
    public void limpiar() {
        raiz = null;
    }
}
