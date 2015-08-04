package com.wlc.ds.string;

/**
 * 字符串的相关算法
 * 
 * @author lanchun
 * 
 */
public class StringUtils {
	/* 字符串比较 */
	public static int strCom(String s1, String s2) {
		int i = 0;
		while (i < s1.length() && s1.charAt(i) == s2.charAt(i)) {
			i++;
		}
		if (i >= s1.length())
			return 0;
		else {
			if (s1.charAt(i) > s2.charAt(i))
				return 1;
			else
				return -1;
		}
	}

	/* 字符串连接,将s2连接到s1上 */
	public static void strCat(String s1, String s2) {
		s1 += s2;
	}

	public static String strCat2(String s1, String s2) {
		s1 += s2;
		return s1;
	}

	public static boolean stringIsEmpty(String s) {
		if (s == null || s.length() == 0)
			return true;
		return false;
	}

	/*
	 * 字符串匹配算法（Brute Force 蛮力破解方法） 这里我省略了KMP算法，KMP算法其实就是在每次匹配失败后，
	 * 不是直接在主串中的下一位继续匹配，而是在已经匹配的模式串子串中，找出最长的相同的前缀和后缀， 然后移动使它们重叠，再从主串后缀开始继续匹配
	 */
	public static int getIndexByBF(String main, String model) {
		if (stringIsEmpty(main) || stringIsEmpty(model)
				|| model.length() > main.length())
			return -1;
		for (int i = 0, j = 0; i < main.length();) {
			int k = i;
			while (k < main.length() && j < model.length()
					&& main.charAt(k) == model.charAt(j)) {
				k++;
				j++;
			}
			if (j < model.length()) {
				if (k < main.length()) {
					i++;
					j = 0;
					continue;
				} else {
					return -1;
				}
			} else {
				return i;
			}
		}
		return -1;
	}

	/***************************** 最长公共子序列 ***************************/

	// 计算最长公共子序列的长度
	// 使用二维数组来保存长度
	// 为了方便回朔找回lcs，使用另外一个数组保存路径
	public static int lcs(String s1, String s2, int[][] path) {
		if (stringIsEmpty(s1) || stringIsEmpty(s2)) {
			return 0;
		}
		int l1 = s1.length();
		int l2 = s2.length();
		int[][] matrix = new int[l1 + 1][l2 + 1];
		for (int i = 0; i <= l1; i++)
			matrix[i][0] = 0;
		for (int i = 0; i <= l2; i++)
			matrix[0][i] = 0;

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
					path[i][j] = 1;
				} else {
					if (matrix[i - 1][j] >= matrix[i][j - 1]) {
						matrix[i][j] = matrix[i - 1][j];
						path[i][j] = 2;
					} else {
						matrix[i][j] = matrix[i][j - 1];
						path[i][j] = 3;
					}

				}
			}
		}

		return matrix[l1][l2];
	}

	public void getLCS(String s, int[][] path, int i, int j) {
		if (i == 0 || j == 0)
			return;
		if (path[i][j] == 1) {
			System.out.print(s.charAt(i - 1));
		} else if (path[i][j] == 2) {
			getLCS(s, path, i - 1, j);
		} else if (path[i][j] == 3) {
			getLCS(s, path, i, j - 1);
		}
	}
}
