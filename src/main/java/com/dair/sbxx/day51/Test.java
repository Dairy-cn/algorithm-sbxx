package com.dair.sbxx.day51;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/11/15
 ************************************************************/
public class Test {
	
	public int bulbSwitch(int n) {
		
		if (n == 0) {
			return 0;
		}
		boolean[] arr=new boolean[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=false;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = i-1; j <n ; j+=i) {
				arr[j]=!arr[j];
			}
		}
		int resCount=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]){
				++resCount;
			}
		}
		return resCount;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().bulbSwitch(3));
	}
}
