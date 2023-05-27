package com.dair.sbxx.year2023.day33;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2023/5/26
 ************************************************************/
public class Test {
	
	/**
	 * 冒泡排序
	 *
	 * @param arr
	 */
	public void sort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp(arr, i, j);
				}
			}
		}
	}
	
	private void temp(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void sort2(int[] arr) {
		//3 2  1
		//2 3 1
		for (int i = 1; i < arr.length; i++) {
			int j = i-1;
			int temp=arr[i];
			for (;j>=0;j--) {
				if (temp >= arr[j]) {
					break;
				}
				arr[j+1]=arr[j];
				
			}
			arr[j+1]=temp;
			
		}
		
		
	}
	
	
	public void selectedSort(int[] arr){
		
		for (int i = 0; i < arr.length; i++) {
			
			int minIndex=i;
			for (int j = i+1; j <arr.length ; j++) {
				if(arr[j]<arr[i]){
					minIndex=j;
				}
			}
			temp(arr,i,minIndex);
		}
		
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{2, 3, 1, 6, 7, 4};
		new Test().sort2(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
}
