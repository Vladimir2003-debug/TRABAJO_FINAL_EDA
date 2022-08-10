package datastructures;

import java.util.NoSuchElementException;


public class QueueLink<E> implements TDAQueue<E>{
	private Node<E> head;
	private Node<E> tail;

	/** 
	 * Constructors
	 *
	 */ 
	public QueueLink() {
		this.head = null;
		this.tail = null;
	}
	public QueueLink(E head) {
		offer(head);
	}

	public boolean add(E e) {
		return offer(e);
	}

	public E element() {
		if(head == null)
			throw new NoSuchElementException();
		return head.getData();
	}


	public boolean offer(E e) {
		if(e == null)
			throw new NullPointerException();
		if(this.head == null) {
			this.head = new Node<E>(e);
			this.tail = this.head;
			return true;
		}
		this.tail.setNext(new Node<E>(e));
	 	this.tail = this.tail.getNext();
		return true;
	}

	public E peek() {
		return this.head.getData();
	}

	public E poll() {
		if(head == null)
			return null;
		E item = this.head.getData();
		this.head = this.head.getNext();
		return item;
	}

	public E remove() {
		if(head == null)
			throw new NoSuchElementException();
		return poll();
	}

	/**
	 * Este metodo imprime todos los elementos de la cola
	 * @return txt la lista de elementos
	 */

	public String toString() {
		String txt = "";
		for(Node<E> tmp = this.head; tmp != null; tmp = tmp.getNext())
			txt += tmp.getData() + " ";
		
		return txt;
	}
	
}
