package com.wlc.ds.stack;

/**
 * 栈接口
 * @author lanchun
 *
 */
public interface IStack<T> {
	
	/*入栈*/
	boolean push(T t);
	
	/*出栈*/
	T pop();
	
	/*出栈但不删除栈顶*/
	T peek();
	
	/*栈内元素个数*/
	int size();
	
	/*栈是否为空*/
	boolean isEmpty();

	
}
