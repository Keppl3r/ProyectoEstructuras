/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Juan Jose Meza Guarista 260961
 */
public class Curso {
    private String nombre;
    private int claveCurso;

    public Curso(String nombre, int claveCurso) {
        this.nombre = nombre;
        this.claveCurso = claveCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getClaveCurso() {
        return claveCurso;
    }

    public void setClaveCurso(int claveCurso) {
        this.claveCurso = claveCurso;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "Clave del curso: " + claveCurso;
    }
    
    
}
