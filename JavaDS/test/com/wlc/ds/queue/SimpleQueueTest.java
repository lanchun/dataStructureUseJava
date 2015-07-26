package com.wlc.ds.queue;

import org.junit.Test;

public class SimpleQueueTest {

	@Test
	public void test() {
		SimpleQueue<Integer> queue = new SimpleQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		System.out.println(queue);
		
		queue.dequeue();
		System.out.println(queue);

		queue.dequeue();
		System.out.println(queue);

		queue.dequeue();
		System.out.println(queue);

		queue.dequeue();
		System.out.println(queue);

		queue.dequeue();
		System.out.println(queue);

	}

}
