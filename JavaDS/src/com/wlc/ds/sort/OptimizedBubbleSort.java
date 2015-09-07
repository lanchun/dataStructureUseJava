package com.wlc.ds.sort;

public class OptimizedBubbleSort implements ISort {

	@Override
	public void sort(int[] array) {
		boolean run = true;
		int len = array.length;
		while (run) {
			run = false;
			for (int i = 0; i < len - 1; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					
					run = true;
				}
			}
			len--;
		}
	}

}
