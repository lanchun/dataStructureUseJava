package com.wlc.ds.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class OptimizedBubbleSortTest {

	int[] array = {3,5,4,2,1,7,9,8,-100,123,0,-5,20};
	
	@Test
	public void testSort() {
		new OptimizedBubbleSort().sort(array);
		System.out.println(Arrays.toString(array));
	}

}
