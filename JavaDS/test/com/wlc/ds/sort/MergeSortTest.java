package com.wlc.ds.sort;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest {

	int[] a = { 3, 5, 6, 7, 2, 4, 8, 9 };

	@Test
	public void testMergeArray() {
		int[] temp = new int[8];
		new MergeSort().mergeArray(a, 0, 3, 7, temp);
		System.out.println(Arrays.toString(a));
	}
	
	@Test
	public void testMergeSort(){
		new MergeSort().sort(a);
		System.out.println(Arrays.toString(a));
	}

}
