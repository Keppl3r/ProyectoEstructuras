/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import entidades.Estudiante;

/**
 *
 * @author keppler
 */
public class NodoAVL {

    private double promedio;
    private Estudiante estudiante;
    private NodoAVL izquierdo;
    private NodoAVL derecho;

    public NodoAVL(double promedio, Estudiante estudiante) {
        this.promedio = promedio;
        this.estudiante = estudiante;
        this.izquierdo = null;
        this.derecho = null;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }
}
