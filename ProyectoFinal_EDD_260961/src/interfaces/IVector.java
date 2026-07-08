/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.VectorDinamicoException;

/**
 *
 * @author keppler
 */
public interface IVector<T> {

    public void agregar(T elemento);

    public T obtener(int indice) throws VectorDinamicoException;

    public int getNumeroElementos();
}
