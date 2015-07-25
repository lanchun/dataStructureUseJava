package com.wlc.ds.stack;

import org.junit.Test;

import com.wlc.ds.stack.SimpleStack;

public class StackTest {

	@Test
	public void testSimpleStack() {
		SimpleStack<Integer> stack = new SimpleStack<>(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack);
		
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
	}

}
