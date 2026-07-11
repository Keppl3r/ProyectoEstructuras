/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import estructuras.Pila;
import excepciones.PilaException;

/**
 *
 * @author keppler
 */
public class PruebaPila {

    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();

        pila.push(10);
        pila.push(20);
        pila.push(30);

        System.out.println(pila.peek());
        System.out.println(pila.pop());
        System.out.println(pila.pop());
        System.out.println(pila.pop());

        try {
            pila.pop();
        } catch (PilaException e) {
            System.out.println(e.getMessage());
        }
    }
}