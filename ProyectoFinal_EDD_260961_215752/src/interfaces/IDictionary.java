/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import estructuras.LinkedList;

/**
 *
 * @author USER
 * @param <K>
 * @param <V>
 */
public interface IDictionary<K, V> {
    public V put(K llave, V valor);
    public V remove(K llave);
    public V get(K llave);
    public boolean contains(K llave);
    public int size();
    public boolean empty();
    public void clear();
    public LinkedList<K> keys();
    public LinkedList<V> values();
}
