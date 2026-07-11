/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import interfaces.IPila;
import excepciones.PilaException;

/**
 *
 * @author keppler
 */
public class Pila<T> extends LinkedList<T> implements IPila<T> {

    @Override
    public void push(T elemento) throws PilaException {
        try {
            this.append(elemento);
        } catch (Exception e) {
            throw new PilaException("error al insertar en la pila");
        }
    }

    @Override
    public T pop() throws PilaException {
        if (this.empty()) {
            throw new PilaException("la pila esta vacia");
        }
        try {
            return this.remove(this.size() - 1);
        } catch (Exception e) {
            throw new PilaException("error al extraer");
        }
    }

    @Override
    public T peek() throws PilaException {
        if (this.empty()) {
            throw new PilaException("la pila esta vacia");
        }
        try {
            return this.get(this.size() - 1);
        } catch (Exception e) {
            throw new PilaException("error al inspeccionar");
        }
    }

    @Override
    public boolean vacia() {
        return this.empty();
    }
}
