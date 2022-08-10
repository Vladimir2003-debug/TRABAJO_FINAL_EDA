package datastructures;
public interface TDAQueue<E> {
	
	/**
	 * Ingresa el elemento en la cola de acuedo a los limites
	 * de capacidad  
	 * @param e elemento a a�adir
	 * @return true cuando el elemento ha sido ingresado
	 * @throws IllegalStateException Si el elemento no se puede agregar debido a las restricciones de capacidad
     * @throws ClassCastException Si la clase impide que se agrege a la cola
     * @throws NullPointerException Si el elemento es nulo y la cola no permite elementos nulos
     * @throws IllegalArgumentException Si alguna propiedad del elemento impide que se agrege a la cola
	 */
    boolean add(E e);
    
    /**
     * Devuelve el elemento head(cabeza) de la cola
     * @return head La cabeza de la cola
     * @throws NoSuchElementException Si la cola esta vacia 
     */
    E element();
    
    /**
     * Inserta el elemento en la cola. Este metodo a diferencia de add
     * inserta elementos a pesar de la restriccion de capacidad
     * @param e Elemento a a�adir
     * @return true Si el elemento se a�adio a la cola
     * @return false Si el elemento no se a�adio a la cola
     * @throws ClassCastException Si la clase del elemento impide que se agrege a esta cola
     * @throws NullPointerException Si el elemento es nulo y la cola no permite elementos nulos
     * @throws IllegalArgumentException Si alguna propiedad de este elemento impide que se agrege a esta cola
     */
    boolean offer(E e);
    
    /**
     * Recupera sin eliminar el Head de la cola, si esta vacia retornara null 
     * @return head La cabeza de la cola
     * @return null Si la cola esta vacia
     */
    E peek();
    
    /**
     * Devuelve y elimina la cabeza de la cola, retornara null si la cola esta vacia
     * @return head La cabeza de la cola
     * @return null Si la cola esta vacia
     */
    E poll();
    
    /**
     * Recupera y elimina la cabeza de la cola. A diferencia de poll lanzara una
     *  exception si la cola esta vacia
     * @return head La cabeza de la cola
     * @throws NoSuchElementException Si la cola esta vacia
     */
    E remove();
}

