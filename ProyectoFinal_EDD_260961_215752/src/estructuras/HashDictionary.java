/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import interfaces.IDictionary;

/**
 *
 * @author USER
 * @param <K>
 * @param <V>
 */
public class HashDictionary<K, V> implements IDictionary<K, V>{
    private final LinkedList<Entrada<K, V>> tablaHash[];
    private int nEntradas;
    private final int tamTablaHash; 
    
    private class Entrada<K, V> {
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
   public HashDictionary(int tamTablaHash) {
        @SuppressWarnings("unchecked")
        LinkedList<Entrada<K, V>>[] tablaHashTemp  
                 = (LinkedList<Entrada<K, V>>[])
                        new LinkedList[tamTablaHash];
        tablaHash = tablaHashTemp;
        nEntradas = 0;
        this.tamTablaHash = tamTablaHash;
    }
   
   
   @Override
   public V put(K llave, V valor){
       int indiceTablaHash = getIndexHashTable(llave);
       
       if(tablaHash[indiceTablaHash] != null){
           LinkedList<Entrada<K, V>> balde = tablaHash[indiceTablaHash];
           for(Entrada<K, V> entrada : balde)
               if(llave.equals(entrada.llave)){
                   V valorActual = entrada.valor;
                   entrada.valor = valor;
                   return valorActual;
               }
            balde.append(new Entrada<>(llave, valor));
            nEntradas++;
            return null;
        }
        tablaHash[indiceTablaHash] = new LinkedList<Entrada<K, V>>();
        tablaHash[indiceTablaHash].append(new Entrada<K, V>(llave,valor));
        nEntradas++;
        return null;
   }
   
   
   private int getIndexHashTable(K llave){
       return Math.abs(llave.hashCode()) % tamTablaHash;
   }
   
   @Override
   public V remove(K llave){
       int indiceTablaHash = getIndexHashTable(llave);
       
       if(tablaHash[indiceTablaHash] != null){
           LinkedList<Entrada<K, V>> balde = tablaHash[indiceTablaHash];
           for(Entrada<K, V> entrada : balde)
               if(llave.equals(entrada.llave)){
                   balde.remove(entrada);
                   nEntradas--;
                   return entrada.valor;
                }
        }
        return null;
   }
   
   @Override
   public V get(K llave){
        int indiceTablaHash = getIndexHashTable(llave);
        
       if(tablaHash[indiceTablaHash] != null){
           LinkedList<Entrada <K, V>> balde = tablaHash[indiceTablaHash];
            for(Entrada<K, V> entrada : balde)
                if(llave.equals(entrada.llave)){
                    return entrada.valor;
                }
        }
       return null;
   }
   
   @Override
   public boolean contains(K llave){
       int indiceTablaHash = getIndexHashTable(llave);
       
       if(tablaHash[indiceTablaHash] != null){
           LinkedList<Entrada<K, V>> balde = tablaHash[indiceTablaHash];
           for(Entrada<K, V> entrada : balde)
               if(llave.equals(entrada.llave)){
                   return true;
               }
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
       for (int i = 0; i < tamTablaHash; i++) {
           tablaHash[i] = null;
       }
       this.nEntradas = 0;
   }
   
   
   @Override
   public LinkedList<K> keys(){
      LinkedList<K> keysList = new LinkedList<>();
      
      for(LinkedList<Entrada<K, V>> balde : tablaHash){
          if(balde != null){
              for(Entrada<K, V> entrada : balde){
                  keysList.append(entrada.llave);
              }
          }
      }
      return keysList;
   }
   
   @Override
   public LinkedList<V> values(){
       LinkedList<V> valuesList = new LinkedList<>();
       
       for(LinkedList<Entrada<K, V>> balde : tablaHash){
           if(balde != null){
               for(Entrada<K, V> entrada : balde){
                   valuesList.append(entrada.valor);
               }
           }
       }
       return valuesList;
   }
    
}
