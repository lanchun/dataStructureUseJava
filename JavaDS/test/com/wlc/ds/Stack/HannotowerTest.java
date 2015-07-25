package com.wlc.ds.stack;

import org.junit.Test;

import com.wlc.ds.stack.Hannotower;
import com.wlc.ds.stack.SimpleStack;

public class HannotowerTest {

	@Test
	public void test() {
		SimpleStack<Integer> s1 = new SimpleStack<Integer>(3);
		SimpleStack<Integer> s2 = new SimpleStack<Integer>(3);
		SimpleStack<Integer> s3 = new SimpleStack<Integer>(3);
		
		Hannotower a = new Hannotower(s1,"A");
		Hannotower b = new Hannotower(s2,"B");
		Hannotower c = new Hannotower(s3,"C");

		for (int i = 3; i > 0; i--) {
			a.disks.push(i);
		}
		
		System.out.println(a.disks);
		
		a.moveDisksTo(3, c, b);
		
		System.out.println(c.disks);
	}

}
