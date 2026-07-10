/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;


import interfaces.IVector;
import excepciones.VectorDinamicoException;
import java.lang.reflect.Array;

/**
 *
 * @author Kevin Mendoza 215752
 */
public class VectorDinamico<T> implements IVector<T> {

    private T[] datos;
    private int capacidad;
    private int nElementos;
    private Class<T> tipo;

    
    public VectorDinamico(Class<T> tipo) {
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
    public T obtener(int indice) throws VectorDinamicoException {
        if (indice < 0 || indice >= nElementos) {
            throw new VectorDinamicoException("indice fuera de rango: " + indice);
        }
        return datos[indice];
    }

    @Override
    public int getNumeroElementos() {
        return nElementos;
    }
}
