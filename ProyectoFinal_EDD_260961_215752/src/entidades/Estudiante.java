/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import estructuras.ArregloDinamico;

/**
 *
 * @authors Juan Jose Meza Guarista 260961, Kevin Mendoza 215752
 */
public class Estudiante {

    private String matricula;
    private String nombre;
    private String numTelefono;
    private String correo;
    private String direccion;
    private ArregloDinamico<Double> calificaciones;

    public Estudiante(String matricula, String nombre, String numTelefono, String correo, String direccion) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.numTelefono = numTelefono;
        this.correo = correo;
        this.direccion = direccion;
        this.calificaciones = new ArregloDinamico<>(Double.class);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public ArregloDinamico<Double> getCalificaciones() {
        return calificaciones;
    }

    public void imprimirDatos() {
        System.out.println(matricula + " - " + nombre + " - " + numTelefono + " - " + direccion);
    }
}
