package com.wlc.ds.sort;

/**
 * 选择排序<br>
 * 每次选择最小的元素
 * 时间复杂度: 平均情况与最差情况都是O(n^2)<br>
 * 空间复杂度: O(1)
 * 
 * @author lanchun
 * 
 */
public class SelectionSort implements ISort {

	public void sort(int[] array) {
		for(int i = 0;i < array.length-1;i++){
			int min = array[i];
			int indexOfMin=i;
			for(int j = i+1;j < array.length;j++){
				if(min > array[j]){
					min = array[j];
					indexOfMin=j;
				}
			}
			if(array[i] != min){
				array[indexOfMin] = array[i];
				array[i] = min;
			}
		}
	}
}
