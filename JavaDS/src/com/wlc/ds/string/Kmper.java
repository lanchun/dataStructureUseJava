package com.wlc.ds.string;

/**
 * KMP算法
 * 
 * @author lanchun
 *
 */
public class Kmper {
	public static int getIndexKMP(char[] s, char[] t,int[] next) {
		int i = 0, j = 0;
		while (i <= s.length && j <= t.length) {
			if (j == 0 || s[i] == t[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}

		if (j > t.length) {
			return i - t.length;
		} else {
			return -1;
		}

	}

	public static void getNext(char[] t, int[] next) {
		int i = 0, j = 0;
		next[0] = 0;
		while (i < t.length) {
			if (j == 0 || t[i] == t[j]) {
				i++;
				j++;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
	}
}
