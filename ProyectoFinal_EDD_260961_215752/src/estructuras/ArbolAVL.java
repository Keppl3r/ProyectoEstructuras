/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import entidades.Estudiante;

/**
 *
 * @author Kevin Mendoza
 */
public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public void insertar(double promedio, Estudiante estudiante) {

        raiz = insertarAVL(raiz, promedio, estudiante);
    }

    private NodoAVL insertarAVL(NodoAVL nodo, double promedio, Estudiante estudiante) {
        if (nodo == null) {
            return new NodoAVL(promedio, estudiante);
        }

        if (promedio < nodo.getPromedio()) {
            nodo.setIzquierdo(insertarAVL(nodo.getIzquierdo(), promedio, estudiante));
        } else if (promedio > nodo.getPromedio()) {
            nodo.setDerecho(insertarAVL(nodo.getDerecho(), promedio, estudiante));
        } else {
            nodo.setDerecho(insertarAVL(nodo.getDerecho(), promedio, estudiante));
        }

        int balance = obtenerBalance(nodo);

        // LL
        if (balance > 1 && promedio <= nodo.getIzquierdo().getPromedio()) {
            return rotacionDerecha(nodo);
        }
        // RR
        if (balance < -1 && promedio >= nodo.getDerecho().getPromedio()) {
            return rotacionIzquierda(nodo);
        }
        // LR
        if (balance > 1 && promedio > nodo.getIzquierdo().getPromedio()) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }
        // RL
        if (balance < -1 && promedio < nodo.getDerecho().getPromedio()) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private int obtenerAltura(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(obtenerAltura(nodo.getIzquierdo()), obtenerAltura(nodo.getDerecho()));
    }

    private int obtenerBalance(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return obtenerAltura(nodo.getIzquierdo()) - obtenerAltura(nodo.getDerecho());
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.getIzquierdo();
        NodoAVL T2 = x.getDerecho();
        x.setDerecho(y);
        y.setIzquierdo(T2);
        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.getDerecho();
        NodoAVL T2 = y.getIzquierdo();
        y.setIzquierdo(x);
        x.setDerecho(T2);
        return y;
    }

    public void imprimir() {
        if (raiz == null) {
            System.out.println("no hay datos en el AVL");
        } else {
            recorridoEnOrden(raiz);
        }
    }

    private void recorridoEnOrden(NodoAVL nodo) {
        if (nodo != null) {
            recorridoEnOrden(nodo.getIzquierdo());
            System.out.println("Promedio: " + nodo.getPromedio() + "  Estudiante: " + nodo.getEstudiante().getNombre());
            recorridoEnOrden(nodo.getDerecho());
        }
    }
}
