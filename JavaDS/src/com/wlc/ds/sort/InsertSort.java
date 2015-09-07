package com.wlc.ds.sort;

/**
 * 简单插入排序
 * 数组前部保存已排序的元素，从前往后依次将元素插入到已排序的序列中
 * @author lanchun
 *
 */
public class InsertSort implements ISort {

	@Override
	public void sort(int[] array) {
		//从第二个元素开始
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			int temp = array[i];
			/**
			 * 将当前元素和已排序的元素从后向前比较，如果小于则将已排序序列向后移动一个位置，
			 * 直至找到合适的位置(边比较边腾出位置，等比较完了，位置也腾出来了)
			 */
			while (j >= 0 && temp < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			/**如果发生了移动，将当前元素插入到已排序序列的合适位置上
			 */
			if (j != i-1)
				array[j + 1] = temp;
		}
	}

}
