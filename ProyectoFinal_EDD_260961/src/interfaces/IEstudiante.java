/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author Juan Jose Meza Guarista 260961
 */
public interface IEstudiante<T>{
    
    public void registrarEstudiante(T dato);
    public void eliminarEstudiante(T dato);
    public T buscar(T dato);
    public void listarInOrden();
}
