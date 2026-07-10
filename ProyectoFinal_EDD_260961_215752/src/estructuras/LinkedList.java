/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import interfaces.IList;
import excepciones.ListException;
import java.util.Iterator;

/**
 *
 * @author Asignación 5 260961
 */
public class LinkedList<T> implements IList<T>, Iterable<T>{
    protected NodoSimple<T> inicio;
    protected int nElementos;

    private class NodoSimple<T>{
        private T dato;
        private NodoSimple<T> sig;
        
        public NodoSimple(T dato){
            this.dato = dato;
        }
    }
    
    private class ListIterator<T> implements Iterator<T>{
        private NodoSimple<T> nodoActual;
        
        public ListIterator(NodoSimple<T> inicio){
            nodoActual = inicio;
        }
        
        @Override
        public boolean hasNext(){
            return nodoActual != null;
        }
        
        @Override
        public T next(){
            T dato = nodoActual.dato;
            nodoActual = nodoActual.sig;
            return dato;
        }
    }
    public LinkedList(){
        inicio = null;
        nElementos = 0;
    }
    
    
    @Override
    //metodo de reemplazar elemento
    public void set(T o,int i)throws ListException{
        if(i < 0 || i >= nElementos){
            throw new ListException("Indice fuera de rango");
        }
       
        NodoSimple<T> nodo = inicio;
        for(int j = 0; j < i; j++){
            nodo = nodo.sig;
        }
        nodo.dato = o;
    }
    
    @Override
    //metodo de eliminar elemento
    public boolean remove(T o){
        if(inicio == null){
            return false;
        }
     
        if(inicio.dato.equals(o)){
            inicio = inicio.sig;
            nElementos--;
            return true;
        }
   
        NodoSimple<T> nodo = inicio;
        while(nodo.sig != null){
            if(nodo.sig.dato.equals(o)){
                nodo.sig = nodo.sig.sig;
                nElementos--;
                System.out.println("la palabra pudo ser eliminada.");
                return true;
            }
            nodo = nodo.sig;
        }
         
        System.out.println("la palabra que buscas para eliminar no se encuentra en la lista.");
        return false;
    }
    
    @Override
    public void append(T o){
        NodoSimple<T> nodoNuevo = new NodoSimple<>(o);
        NodoSimple<T> nodo = inicio;
        
        if(inicio == null){
            inicio = nodoNuevo;      
        }else{
            while(nodo.sig != null){
                nodo = nodo.sig;
            }
            nodo.sig = nodoNuevo;
        }
        nElementos++;
    }
    
    @Override
    public void insert(T o, int i)throws ListException{
        NodoSimple<T> nodoNuevo = new NodoSimple<>(o);
        
        if (i < 0 || i > nElementos){
            throw new ListException("Indice fuera del limite.");
        }
        
        if (i == 0){
            if (inicio != null){
                nodoNuevo.sig = inicio;
            }
            inicio = nodoNuevo;
        }else{
            NodoSimple<T> nodo = inicio;
            for (int j = 0; j < i - 1; j++){
                nodo = nodo.sig;
            }
            nodoNuevo.sig = nodo.sig;
            nodo.sig = nodoNuevo;
        }
        nElementos++;
    }
    
    @Override
    public T get(int i)throws ListException{
        if (inicio == null){
            throw new ListException("Lista vacia.");
        }
        
        if(i < 0 || i >= nElementos){
            throw new ListException("indice fuera de rango");
        }
        
        NodoSimple<T> nodo = inicio;
        for (int j = 0; j < i ; j++){
            nodo = nodo.sig;
        }
        return nodo.dato;
    }
    
    @Override
    public T remove(int i) throws ListException {
        T o;
        if(empty()){
            throw new ListException("Lista vacia");
        }
        
        if(i < 0 || i > nElementos){
            throw new ListException("Indice fuera de limites.");
        }
        
        if(i == 0){
            o = inicio.dato;
            inicio = inicio.sig;
        } else{
            NodoSimple<T> nodo = inicio;
            for (int j = 0; j < i - 1; j++) {
                nodo = nodo.sig;
            }
            o = nodo.sig.dato;
            nodo.sig = nodo.sig.sig;
        }
        nElementos--;
        return o;
    }
    
     @Override
    //metodo que regresa el inidce del elemento
    public int indexOf(T o)throws ListException{
       
       NodoSimple<T> nodo = inicio;

       for (int i = 0; i < nElementos; i++){
           if(nodo.dato.equals(o)){
               return i;
           }
           nodo = nodo.sig;
       }
       throw new ListException("El elemento no se encuentra en la lista");
    }
    
    @Override
    //metodo que elimina todos los elementos de la lista
    public void clear(){
        inicio = null;
        nElementos = 0;
    }
    
    @Override
    public boolean empty(){
        return inicio == null;
    }
    
    @Override
    public int size(){
        return nElementos;
    }
    
    @Override
    public Iterator<T> iterator(){
        return new ListIterator(inicio);
    }
    
    @Override
    public String toString(){
        String s = "[";
        NodoSimple<T> nodo = inicio;
        
        while (nodo != null){
            s += nodo.dato;
            if (nodo.sig != null){
                s += ", ";
            }
            nodo = nodo.sig;
        }
        s += "]";
        return s;
    }
   
}
