package com.wlc.ds.queue;

public interface IQueue<T> {
	void enqueue(T t);
	
	T dequeue();
	
	T peek();
	
	
}
