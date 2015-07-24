package com.wlc.ds.sort;

import java.util.Arrays;
/**
 * 堆排序 
 * 时间复杂度 nlgn，非穩定性
 * 将数组转化成大根堆，每次取树根和最后一个叶子交换
 * 重复以上步骤
 * @author lanchun
 *
 */
public class HeapSort implements ISort {

	@Override
	public void sort(int[] array) {
		heapSort(array, array.length);
	}

	/**
	 * 调整数组a从下标i开始为大根堆
	 * @param a
	 * @param i
	 * @param size 数组长度
	 */
	public void heapAdjust(int[] a, int i, int size) {
		if (i < size / 2) {             //如果i不是叶子结点(如果是叶子结点可以认为它是合法的大根堆)
			int lChild = 2 * i + 1;         //i的左孩子下标
			int rChild = 2 * i + 2;         //i的右孩子下标
			int maxIndex = i;               //临时变量，存储i和其孩子中最大结点下标
			
			
			if (lChild < size && a[lChild] > a[maxIndex]) {
				maxIndex = lChild;
			}
			if (rChild < size && a[rChild] > a[maxIndex]) {
				maxIndex = rChild;
			}
			if (i != maxIndex) {
				swap(a, i, maxIndex);   //将左右孩子中最大的和i交换
				heapAdjust(a, maxIndex, size);   //交换后可能破坏孩子结点的子树堆性，因此递归调用调整
			}
		}
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * 建堆
	 * @param a
	 * @param size
	 */
	public void buildHeap(int[] a, int size) {
		//从倒数第一个非叶子结点开始
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapAdjust(a, i, size);
		}
	}

	public void heapSort(int[] a, int size) {
		//先建堆
		buildHeap(a, size);
		//System.out.println(Arrays.toString(a));

		for (int i = size - 1; i >= 0; i--) {
		//将第一个数和最后一个数交换
			swap(a, 0, i);
		//交换之后，只需要对树根进行一次调整就能保证整棵树为大根堆	
			heapAdjust(a, 0, i - 1);
		}
	}
}
