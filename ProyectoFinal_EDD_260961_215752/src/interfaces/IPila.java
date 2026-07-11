/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.PilaException;

/**
 *
 * @author keppler
 */
public interface IPila<T> {

    public void push(T elemento) throws PilaException;

    public T pop() throws PilaException;

    public T peek() throws PilaException;

    public boolean vacia();
}
