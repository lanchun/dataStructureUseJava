package com.wlc.ds.sort;

import java.util.Arrays;

import org.junit.Test;

public class OptimizedInsertSortTest {

	int[] array = {3,5,4,2,1,7,9,8,0,-5,20};
	
	@Test
	public void testSort() {
		new OptimizedInsertSort().sort(array);
		System.out.println(Arrays.toString(array));
		
		int[] a = {1,2,3,5,6,7,8};
		
		System.out.println(new OptimizedInsertSort().getIndexByBinarySearch(a, 7, 0));
	}

}
