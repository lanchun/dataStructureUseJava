package com.wlc.ds.sort;

/**
 * 冒泡排序 相邻位依次比较 时间复杂度: 平均情况与最差情况都是O(n^2)<br>
 * 空间复杂度: O(1)
 * 
 * @author lanchun
 * 
 */
public class BubbleSort implements ISort {

	@Override
	public void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

}
