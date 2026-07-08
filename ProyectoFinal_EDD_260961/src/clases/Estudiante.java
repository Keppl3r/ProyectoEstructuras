/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Juan Jose Meza Guarista 260961
 */
public class Estudiante implements Comparable<Estudiante>{
    
    private int matricula;
    private String nombre;
    private int numTelefono;
    private String Email;
    private String direccion;

    public Estudiante(int matricula, String nombre, int numTelefono, String Email, String direccion) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.numTelefono = numTelefono;
        this.Email = Email;
        this.direccion = direccion;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return " Matricula: " + matricula + " Nombre: " + nombre + " Telefono: " + numTelefono + " Correo electronico: " + Email + " Direccion: " + direccion;
    }

    @Override
    public int compareTo(Estudiante o) {
        return Integer.compare(this.matricula, o.matricula);
    }
    
    
    
}
