package com.wlc.ds.sort;

/**
 * 冒泡排序
 * 相邻位依次比较
 * 时间复杂度: 平均情况与最差情况都是O(n^2)<br>
 * 空间复杂度: O(1)
 * @author lanchun
 * 
 */
public class BubbleSort implements ISort {

	@Override
	public void sort(int[] array) {
		int num;
		for (int i = 0; i < array.length; i++) {
			num = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (num > array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
	}

}
