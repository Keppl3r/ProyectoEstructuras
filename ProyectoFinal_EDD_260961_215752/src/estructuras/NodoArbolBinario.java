/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author keppler
 */
public class NodoArbolBinario<T> {

    private T dato;
    private NodoArbolBinario<T> izquierdo;
    private NodoArbolBinario<T> derecho;

    public NodoArbolBinario(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoArbolBinario<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbolBinario<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbolBinario<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbolBinario<T> derecho) {
        this.derecho = derecho;
    }
}
