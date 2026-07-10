/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.ListException;
import java.util.Iterator;

/**
 *
 * @author Asiganación 4 260961
 */
public interface IList<T> {
   public void append(T o) throws ListException;
   public void insert(T o, int i)throws ListException;
   public T get(int i)throws ListException;
   public T remove(int i)throws ListException;
   //que reemplaza el elemento que se encuentra en la posición i de la lista por el objeto del parámetro. El método lanza una excepción del
   //posición i de la lista por el objeto del parámetro. El método lanza una excepción del
   //tipo ListException si la lista está vacía o el indice i esta fuera de los límites de los
   //datos.
   public void set(T o, int i)throws ListException;
   //que elimina la primera ocurrencia del elemento del
   //parámetro si existe. El método regresa true si el elemento existe en la lista, false
   //en caso contrario. El método lanza una excepción del tipo ListException Si la lista
   //está vacía.
   public boolean remove(T o);
   //que regresa el índice de la primera ocurrencia del elemento del
   //parámetro en la lista, o -1 si el elemento no existe.
   public int indexOf(T o)throws ListException;
   //que elimina todos los elementos de la lista
   public void clear()throws ListException;
   public boolean empty();
   public int size();
   public Iterator<T> iterator();
}
