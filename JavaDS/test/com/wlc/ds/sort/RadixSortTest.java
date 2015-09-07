package com.wlc.ds.sort;

import java.util.Arrays;

import org.junit.Test;

public class RadixSortTest {

	int[] array = {3,5,4,2,1,7,9,8,0,20};
	
	@Test
	public void testSort() {
		new RadixSort().sort(array);
		System.out.println(Arrays.toString(array));
	}

}
