/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.TreeException;

/**
 *
 * @author keppler
 */
public interface ITree<T> {

    public T getDatoRaiz() throws TreeException;

    public boolean vacio();

    public void limpiar();
}
