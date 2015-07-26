package com.wlc.ds.queue;

import com.wlc.ds.Node;

/**
 * 队列
 * @author lanchun
 *
 */

public class SimpleQueue<T> implements IQueue<T> {

	//队头指针
	Node<T> first = null;
	
	Node<T> last = null;
	
	//入队
	@Override
	public void enqueue(T t) {
		Node<T> node = new Node<T>(t);
		
		if(first ==  null){
			first = last = node;
		}else{
			last.next = node;
			last = node;
		}
	}

	@Override
	public T dequeue() {
		Node<T> f = first;
		if(f != null){
			first = f.next;
			return f.item;
		}
		return null;
	}

	@Override
	public T peek() {
		if(first != null)
			return first.item;
		return null;
	}
	
	@Override
	public String toString() {
		if(first == null)
			return "Empty Queue!";
		Node<T> temp = first;
		StringBuilder sb = new StringBuilder();
		while(temp != null){
			sb.append(temp.item);
			sb.append(" ");
			temp = temp.next;
		}
		return sb.toString();
	}

}
