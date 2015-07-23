package com.wlc.ds.sort;
/**
 * 快速排序
 * 挖坑填数（引自网络）
 * 1.每次选择数组第一个数位基准数，挖一个坑，先从后往前找比它小的数，将其放入坑中，
 * 同时自身又成了一个坑，再从左往右找比它大的数，这就算一个回合
 * 2.循环以上步骤直到将数组划分为以基准数为临界的两部分，左边比它大，右边比它小
 * 
 * 3.对左右进行递归
 * @author lanchun
 *
 */
public class QuickSort implements ISort {

	/**
	 * 先从后往前，再从前往右，一次完整的过程
	 * @param array
	 * @param low 左指针
	 * @param high 右指针
	 * @return 基准数应该插入的位置，同时也是下一次划分的临界点
	 */
	public int quickSort(int[] array, int low, int high) {
		/*每次选择数组第一个元素为基准数*/
		int key = array[low];
		
		/*当左右指针相碰时结束循环*/
		while (low < high) {
			/*从右往左找*/
			while (high > low && array[high] >= key) {
				high--;
			}
			if (high > low) {
				/*填坑再挖坑*/
				array[low] = array[high];
				//low++;
			}
			while (low < high && array[low] <= key) {
				low++;
			}
			if (low < high) {
				array[high] = array[low];
				//high--;
			}
		}
		/*将基准数放在合适的位置上*/
		array[low] = key;
		return low;
	}

	public void quickSort2(int[] array, int low, int high) {
		if (low < high) {
			int i = quickSort(array, low, high);
			quickSort2(array, low, i - 1);       //左递归
			quickSort2(array, i + 1, high);		 //右递归
		}
	}

	@Override
	public void sort(int[] array) {
		quickSort2(array, 0, array.length - 1);
	}

}
