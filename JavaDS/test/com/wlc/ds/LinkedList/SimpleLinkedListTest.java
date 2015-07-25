package com.wlc.ds.linkedList;


import org.junit.Assert;
import org.junit.Test;

import com.wlc.ds.Node;
import com.wlc.ds.linkedList.SimpleLinkedList;

public class SimpleLinkedListTest {

	SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
	
	@Test
	public void testDeleteDups() {
		Node<Integer> n1 = new Node<Integer>(5);
		Node<Integer> n2 = new Node<Integer>(4);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(2);
		Node<Integer> n5 = new Node<Integer>(1);
		
		list.insert(n1);
		list.insert(n2);
		list.insert(n3);
		list.insert(n4);
		list.insert(n5);
		n1.next = n3;
		
		//list.deleteDups();
		//Assert.assertEquals(5, list.size);
		//System.out.println(list);
		//list.reverse();
		//System.out.println(list);
		
		Assert.assertTrue(list.existLoop());
	}

}
