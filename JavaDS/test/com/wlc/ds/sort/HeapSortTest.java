package com.wlc.ds.sort;

import java.util.Arrays;

import org.junit.Test;

public class HeapSortTest {

	int[] a = { -10, 23, 43, 1, 2, 5, 3, 5, 7, 33, 21, 19 };

	@Test
	public void testSort() {
		new HeapSort().sort(a);
		System.out.println(Arrays.toString(a));
	}

}
