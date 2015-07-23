package com.wlc.ds.search;

/**
 * 二分查找
 * 
 * @author lanchun
 * 
 */
public class BinarySearch {
	/**
	 * 二分查找的非递归实现
	 * 
	 * @param array
	 *            目标数组
	 * @param value
	 *            目标值
	 * @return 存在返回目标值，不存在返回-1
	 */
	public static int binarySearchWithOutRecursive(int[] array, int value) {
		int low = 0;
		int high = array.length - 1;
		int middle;

		while (low < high) {
			middle = (low + high) / 2;
			if (value < array[middle]) {
				high = middle - 1;
			} else if (value > array[middle]) {
				low = middle + 1;
			} else {
				return array[middle];
			}
		}
		return -1;
	}

	/**
	 * 二分查找的递归实现
	 * 
	 * @param array
	 *            目标数组
	 * @param value
	 *            目标值
	 * @return 存在返回目标值，不存在返回-1
	 */
	public static int bsWithRecursive(int[] array, int value) {
		return bsWithRecursive(array, value, 0, array.length - 1);
	}

	public static int bsWithRecursive(int[] array, int value, int low, int high) {
		if (high < low)
			return -1;
		int middle = (low + high) / 2;
		if (value < array[middle]) {
			return bsWithRecursive(array, value, low, middle - 1);
		} else if (value > array[middle]) {
			return bsWithRecursive(array, value, middle + 1, high);
		} else {
			return array[middle];
		}
	}
}
