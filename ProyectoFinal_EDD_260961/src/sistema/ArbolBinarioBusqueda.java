/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import clases.Nodo;
import interfaces.IEstudiante;

/**
 *
 * @author Juan Jose Meza Guarista 260961
 */
public class ArbolBinarioBusqueda<T extends Comparable<T>> implements IEstudiante<T>{
    private Nodo<T> raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }
    
    @Override
    public void registrarEstudiante(T dato){
        if(raiz == null){
            raiz = new Nodo<>(dato);
        }else{
          registrarRecursivo(raiz, dato);  
        }
    }
    
    private void registrarRecursivo(Nodo<T> nodo, T dato){
        int comparacion = dato.compareTo(nodo.getDato());
        
        if(comparacion < 0){
            if(nodo.getDerecha() == null){
                nodo.setIzquierda(new Nodo<>(dato));
            }else{
                registrarRecursivo(nodo.getDerecha(),dato);
            }
        }else{
            System.out.println("El elemento ya existe.");
        }
    }
    
    @Override
    public T buscar(T dato){
        return buscarRecursivo(raiz, dato);
    }
    
    private T buscarRecursivo(Nodo<T> nodo, T dato){
        if(nodo == null){
            return null;
        }
        
        int comparacion = dato.compareTo(nodo.getDato());
        
        if(comparacion < 0){
            return buscarRecursivo(nodo.getIzquierda(), dato);
            
        }else if(comparacion > 0){
            return buscarRecursivo(nodo.getDerecha(), dato);
        }else{
            return nodo.getDato();
        }
    }
    
    @Override
    public void eliminarEstudiante(T dato){
        if(raiz == null){
            System.out.println("El arbol esta vacio.");
            return;
        }
        eliminarRecursivo(raiz, dato);
    }
    
    private Nodo<T> eliminarRecursivo(Nodo<T> nodo, T dato){
        if(nodo == null){
            return null;
        }
        
        int comparacion = dato.compareTo(nodo.getDato());
        
        if(comparacion < 0){
            nodo.setIzquierda(eliminarRecursivo(nodo.getIzquierda(), dato));
        }else if(comparacion > 0){
            nodo.setDerecha(eliminarRecursivo(nodo.getDerecha(), dato));
        }else{
            if(nodo.getIzquierda() == null && nodo.getDerecha() == null){
                return null;
            }
            else if(nodo.getIzquierda() == null){
                return nodo.getDerecha();
            }
            else if(nodo.getDerecha() == null){
                return nodo.getIzquierda();
            }else{
                Nodo<T> minimo = encontrarMinimo(nodo.getDerecha());
                nodo.setDato(minimo.getDato());
                nodo.setDerecha(eliminarRecursivo(nodo.getDerecha(), minimo.getDato()));
            }
        }
        return nodo;
    }
    
    private Nodo<T> encontrarMinimo(Nodo<T> nodo){
        while(nodo.getIzquierda() != null){
            nodo = nodo.getIzquierda();
        }
        return nodo;
    }
    
    @Override
    public void listarInOrden(){
        if(raiz == null){
            System.out.println("El arbol esta vacio.");
        }else{
            inOrdenRecursivo(raiz);
        }
    }
    
    private void inOrdenRecursivo(Nodo<T> nodo){
        if(nodo != null){
            inOrdenRecursivo(nodo.getIzquierda());
            System.out.println(nodo.getDato());
            inOrdenRecursivo(nodo.getDerecha());
        }
    }
    
    public int contar(){
        return contarRecursivo(raiz);
    }
    
    private int contarRecursivo(Nodo<T> nodo){
        if(nodo == null){
            return 0;
        }
        return 1 + contarRecursivo(nodo.getIzquierda()) + contarRecursivo(nodo.getDerecha());
    }
}
