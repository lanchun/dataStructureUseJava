package com.wlc.ds.sort;

import java.util.*;
/**
 * 基数排序
 * 从0到9分配10个桶，数字从个位数开始比较，分别放入10个桶中，这称为一趟比较
 * 趟数等于最大数的位数，注意用LinkedList模拟队列，链表的add方法是在尾部插入
 * 而不是头插法，在HashMap中是头插法
 * @author lanchun
 *
 */
public class RadixSort implements ISort{

	@Override
	public void sort(int[] a) {
		int times = getTimes(getMax(a));
		//使用链表来模拟队列
		LinkedList<Integer>[] arr = new LinkedList[10];
		for(int i = 0;i < 10;i++){
			arr[i] = new LinkedList<Integer>();
		}
		for(int i = 0;i <times;i++){
			for(int e:a){
				int index = (e/(int) Math.pow(10, i))%10;
				/*System.out.println(index);
				System.out.println(e);
				System.out.println(i);*/
				arr[index].add(e);
			}
			
			int c = 0;
			for(LinkedList<Integer> list : arr){
				while(list.size() > 0){
					a[c++] = list.poll();
				}
			}
		}
	}
	
	private int getMax(int[] a){
		int max = a[0];
		for(int e:a){
			if(e > max)
				max = e;
		}
		return max;
	}
	
	//确定排序趟数
	private int getTimes(int num){
		int times = 1;
		while(num/10 > 0){
			times ++;
			num/=10;
		}
		return times;
	}

}
