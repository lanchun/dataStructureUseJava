package com.wlc.ds.sort;

import java.util.Arrays;

import org.junit.Test;

public class QuickSortTest {

	int[] a = { 3, 5, 6, 7, 2, 4, 8, 9 };

	@Test
	public void testSort() {
		long s = System.nanoTime();
		new QuickSort().sort(a);
		System.out.println(System.nanoTime() - s);
		System.out.println(Arrays.toString(a));
	}

}
