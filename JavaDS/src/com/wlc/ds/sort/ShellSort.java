package com.wlc.ds.sort;

/**
 * 希尔排序
 * 思想，根据选定步长，将数组划分成几个部分，然后对每个部分进行插入排序，
 * 之后将排序好的每个部分放回原数组对应位置
 * 步长减小，循环调用直到步长为1
 * @author lanchun
 *
 */
public class ShellSort implements ISort {

	@Override
	public void sort(int[] a) {
		for (int gap = a.length / 2; gap > 0; gap = gap - 2) {
			shellInsert2(a, gap);
		}
	}

	
	public void shellInsert2(int[] a,int gap){
		int j;
		for(int i = gap;i < a.length;i++){
			int temp = a[i];
			for(j = i-gap;j>=0;j-=gap){
				if(temp < a[j]){
					a[j+gap] = a[j];
				}else
					break;
			}
			a[j+gap] = temp;
		}
	}
}
