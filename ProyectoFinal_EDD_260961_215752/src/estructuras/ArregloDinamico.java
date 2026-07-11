/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;


import interfaces.IVector;
import excepciones.ArregloDinamicoException;
import java.lang.reflect.Array;

/**
 *
 * @author Kevin Mendoza 215752
 */
public class ArregloDinamico<T> implements IVector<T> {

    private T[] datos;
    private int capacidad;
    private int nElementos;
    private Class<T> tipo;

    
    public ArregloDinamico(Class<T> tipo) {
        this.tipo = tipo;
        this.capacidad = 5;
        this.datos = (T[]) Array.newInstance(this.tipo, this.capacidad);
        this.nElementos = 0;
    }

    @Override
    public void agregar(T elemento) {
        if (nElementos == capacidad) {
            expandirCapacidad();
        }
        datos[nElementos] = elemento;
        nElementos++;
    }

  
    private void expandirCapacidad() {
        capacidad = capacidad * 2;
        T[] nuevosDatos = (T[]) Array.newInstance(tipo, capacidad);

        for (int i = 0; i < nElementos; i++) {
            nuevosDatos[i] = datos[i];
        }

        datos = nuevosDatos;
    }

    @Override
    public T obtener(int indice) throws ArregloDinamicoException {
        if (indice < 0 || indice >= nElementos) {
            throw new ArregloDinamicoException("indice invalido " + indice);
        }
        return datos[indice];
    }

    @Override
    public int getNumeroElementos() {
        return nElementos;
    }
}
