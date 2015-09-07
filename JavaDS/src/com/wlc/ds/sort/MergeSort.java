package com.wlc.ds.sort;

/**
 * 归并排序
 * 将数组分成两组，如果这两组是有序的，则可以很快的进行归并排序，
 * 可以继续将数组划分，直到数组中只有一个元素的时候，我们认为它是有序的<br>
 * 
 * 时间复杂度: 平均情况与最差情况都是O(nlog(n))<br>
 * @author lanchun
 * 
 */
public class MergeSort implements ISort{

	/**
	 * 将一个数组array的[fist,mid]部分和[mid+1,last]部分合并,
	 * 其中array的这两个部分都是相对有序的，这里是增序列
	 * 
	 * @param array
	 * @param first
	 * @param mid
	 * @param last
	 * @param temp
	 */
	public void mergeArray(int[] array, int first, int mid, int last, int[] temp) {
		int i = first, j = mid + 1;
		int m = mid, n = last;
		int k = 0;
		while (i <= m && j <= n) {
			if (array[i] <= array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}
		while (i <= m) {
			temp[k++] = array[i++];
		}
		while (j <= n) {
			temp[k++] = array[j++];
		}

		for (int x = 0; x < k; x++) {
			//再把放回原数组 段 [first,last]
			array[first + x] = temp[x];
		}
	}

	public void mergeSort(int[] a,int first,int last,int[] temp){
		if(first < last){
			int mid = (first+last)/2;
			mergeSort(a, first, mid, temp);         //左半边有序
			mergeSort(a, mid+1, last, temp);		//右半边有序
			mergeArray(a, first, mid, last, temp);  //左右进行归并
		}
	}

	@Override
	public void sort(int[] array) {
		mergeSort(array, 0, array.length-1, new int[array.length]);
	}
}
