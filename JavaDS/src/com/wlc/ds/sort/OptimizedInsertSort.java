package com.wlc.ds.sort;

/**
 * 优化的插入排序，采用二分查找
 * @author lanchun
 *
 */
public class OptimizedInsertSort implements ISort {

	@Override
	public void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int index = getIndexByBinarySearch(array, i, temp);
			if (index != i) {
				int j = i;
				while (j > index) {
					array[j] = array[j - 1];
					j--;
				}
				array[index] = temp;
			}
		}
	}

	public int getIndexByBinarySearch(int[] array, int length, int value) {
		int low = 0;
		int high = length - 1;
		int middle = 0;

		while (low <= high) {
			middle = (low + high) / 2;
			if (value < array[middle]) {
				high = middle - 1;
			} else if (value > array[middle]) {
				low = middle + 1;
			} else {
				return middle;
			}
		}
		if (array[middle] <= value) {
			middle++;
		}
		return middle;
	}

}
