/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import implementaciones.LinkedList;
import interfaces.IDictionary;

/**
 *
 * @author Juan Jose Meza Guarista 260961
 */
public class LinkedListDictionary<K, V> implements IDictionary<K, V> {
    private final LinkedList<Entrada<K, V>> entradas;
    private int nEntradas;

    public LinkedListDictionary() {
        entradas = new LinkedList<>();
        nEntradas = 0;
    }
    
    private class Entrada<K, V>{
        private final K llave;
        private V valor;

        public Entrada(K llave, V valor) {
            this.llave = llave;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return llave + ": " + valor;
        }
    }
    
    @Override
    public V put(K llave, V valor){
        for(Entrada<K, V> entrada : entradas)
            if(llave.equals(entrada.llave)){
                V valorActual = entrada.valor;
                entrada.valor = valor;
                return valorActual;
            }
        entradas.append(new Entrada<>(llave, valor));
        nEntradas++;
        return null;
    }
    
    @Override
    public V remove(K llave){
        for(Entrada<K, V> entrada : entradas)
            if(llave.equals(entrada.llave)){
                entradas.remove(entrada);
                nEntradas--;
                return entrada.valor;
            }
        return null;
    }
    
    @Override
    public V get(K llave){
        for (Entrada<K, V> entrada : entradas) 
            if(llave.equals(entrada.llave)){
                return entrada.valor;
            }
        return null;
    }
    
    @Override
    public boolean contains(K llave){
        for (Entrada<K, V> entrada : entradas) 
            if(llave.equals(entrada.llave)){
                return true;
            }
        return false;
    }
    
    @Override
    public int size(){
        return nEntradas;
    }
    
    @Override
    public boolean empty(){
        return nEntradas == 0;
    }
    
    @Override
    public void clear(){
        entradas.clear();
        nEntradas = 0;
    }
    
    @Override
    public LinkedList<K> keys(){
        LinkedList<K> llaves = new LinkedList<>();
        for(Entrada<K, V> entrada : entradas) 
           llaves.append(entrada.llave);
        return llaves;
    }

    @Override
    public LinkedList<V> values(){
        LinkedList<V> valores = new LinkedList<>();
        for(Entrada<K, V> entrada : entradas) 
           valores.append(entrada.valor);
        return valores;
    }
    
    @Override
    public String toString(){
        String s = "(";
        
        for (Entrada<K, V> entrada : entradas) 
            s += entrada + ", ";
        s+= ")";
        
        return s;
    }
}
