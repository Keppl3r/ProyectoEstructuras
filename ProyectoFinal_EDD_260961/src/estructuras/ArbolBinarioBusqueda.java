/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import excepciones.TreeException;
import interfaces.ITree;

/**
 *
 * @author keppler
 */
public class ArbolBinarioBusqueda<T extends Comparable<T>> implements ITree<T> {

    protected NodoArbolBinario<T> raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private NodoArbolBinario<T> insertarRecursivo(NodoArbolBinario<T> nodo, T dato) {
        if (nodo == null) {
            return new NodoArbolBinario<>(dato);
        }

        int comparacion = dato.compareTo(nodo.getDato());
        if (comparacion < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), dato));
        } else if (comparacion > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), dato));
        }
        return nodo;
    }

    public T buscar(T dato) {
        return buscarRecursivo(raiz, dato);
    }

    private T buscarRecursivo(NodoArbolBinario<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }

        int comparacion = dato.compareTo(nodo.getDato());
        if (comparacion == 0) {
            return nodo.getDato();
        } else if (comparacion < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), dato);
        } else {
            return buscarRecursivo(nodo.getDerecho(), dato);
        }
    }

    @Override
    public T getDatoRaiz() throws TreeException {
        if (vacio()) {
            throw new TreeException("arbol vacio");
        }
        return raiz.getDato();
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
