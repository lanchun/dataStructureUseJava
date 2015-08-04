package com.wlc.ds.string;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testStrCom() {
		String s1 = "abcde";
		String s2 = "abcdf";
		String s3 = "dsdfd";
		Assert.assertEquals(-1, StringUtils.strCom(s1, s2));
		Assert.assertEquals(1, StringUtils.strCom(s3, s2));
		Assert.assertEquals(0, StringUtils.strCom(s3, s3));
	}

	@Test
	public void testStrCat() {
		String s1 = "Hello";
		String s2 = "world";
		StringUtils.strCat(s1, s2);
		System.out.println(s1);

		System.out.println(StringUtils.strCat2(s1, s2));
	}

	@Test
	public void testGetIndexByBF() {
		String main = "zdfdfzddfgdfdfdfddd";
		String model = "dfg";
		System.out.println(StringUtils.getIndexByBF(main, model));
	}

	@Test
	public void testLcs() {
		String s1 = "cnblogs";
		String s2 = "bealone";

		int[][] path = new int[s1.length() + 1][s2.length() + 1];

		Assert.assertEquals(3, StringUtils.lcs(s1, s2, path));

		for(int[] i : path){
			for(int j : i){
				System.out.print(j+" ");
			}
			System.out.println();
		}
		StringUtils utils = new StringUtils();
		utils.getLCS(s1, path, s1.length(), s2.length());

		
	}

}
