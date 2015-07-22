package com.wlc.ds;

public class Node<T> {
	public T item;
	public Node<T> next;
	
	
	public Node(T item) {
		this.item = item;
	}


	public Node(T item, Node<T> next) {
		super();
		this.item = item;
		this.next = next;
	}
	
}
