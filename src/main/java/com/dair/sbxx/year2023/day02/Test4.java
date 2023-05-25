package com.dair.sbxx.year2023.day02;

/**
 * @author Dair
 * @since
 */
public class Test4 {
	
	
	public int waysToStep(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else if (n == 3) {
			return 4;
		} else if (n == 0) {
			return 0;
		} else {
			return ((waysToStep(n - 1) + waysToStep(n - 2) )%1000000007+ waysToStep(n - 3))%1000000007;
		}
	}
	
	public int waysToStep2(int n) {
		int[] arr = new int[n + 1];
		arr[1] = 1;
		if(n>1){
			arr[2] = 2;
		}
		if(n>2){
			arr[3] = 4;
		}
		for (int i = 4; i <= n; i++) {
			arr[i] = ((arr[i - 1]  + arr[i - 2])%1000000007  + arr[i - 3]%1000000007 )%1000000007 ;
		}
		return arr[n];
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test4().waysToStep2(4));
	}
	
}
