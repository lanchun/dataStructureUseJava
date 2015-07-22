package com.wlc.ds.search;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

	int[] array = {1,2,3,4,5,6,7,8,9,10};
	
	@Test
	public void testBinarySearchWithOutRecursive() {
		Assert.assertEquals(8, BinarySearch.binarySearchWithOutRecursive(array, 8));
		Assert.assertEquals(-1,BinarySearch.binarySearchWithOutRecursive(array, 12));
	}

	@Test
	public void testBsWithRecursiveIntArrayInt() {
		Assert.assertEquals(8, BinarySearch.bsWithRecursive(array, 8));
		Assert.assertEquals(-1, BinarySearch.bsWithRecursive(array, 12));
	}

}
