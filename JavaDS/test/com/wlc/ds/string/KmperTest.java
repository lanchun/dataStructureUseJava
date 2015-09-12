package com.wlc.ds.string;

import java.util.Arrays;

import org.junit.Test;

public class KmperTest {

	@Test
	public void testGetIndexKMP() {
		String ss = "aabcbabcaabcaababc";
		String tt = "abcaabcabc";
		
		int[] next = new int[tt.length()+1];
		Kmper.getNext(tt.toCharArray(), next);
		System.out.println(Arrays.toString(next));
		//System.out.println(Kmper.getIndexKMP(ss.toCharArray(), tt.toCharArray(), next));
	}

}
