package com.wlc.ds.stack;

import com.wlc.ds.Node;

/**
 * 栈的实现（在java中有写好的类Stack，但是一般使用Linkedlist来实现栈）
 * 
 * @author lanchun
 * 
 */
class SimpleStack<T> implements IStack<T> {

	/* 栈顶指针 */
	public Node<T> top = null;

	/* 实际元素个数 */
	public int size = 0;
	
	/*最大容量*/
	public int capacity;
	
	
	
	public SimpleStack() {
	}

	public SimpleStack(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	@Override
	public boolean push(T t) {
		if(capacity <= size)
			return false;
		Node<T> node = new Node<T>(t);
		node.next = top;
		top = node;
		size++;
		return true;
	}

	@Override
	public T pop() {
		if (top != null) {
			Node<T> oldTop = top;
			top = top.next;
			size--;
			return oldTop.item;
		}
		return null;
	}

	@Override
	public T peek() {
		if (top != null)
			return top.item;
		return null;
	}

	@Override
	public String toString() {
		if(top == null)
			return "Empty Stack!";
		Node<T> temp = top;
		StringBuilder sb = new StringBuilder();
		while(temp != null){
			sb.append(temp.item);
			sb.append(" ");
			temp = temp.next;
		}
		return sb.toString();
	}

	
}
