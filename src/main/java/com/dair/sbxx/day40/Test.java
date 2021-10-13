package com.dair.sbxx.day40;

import java.util.Arrays;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/13
 ************************************************************/
public class Test {
	
	
	public int countPrimes(int n) {
		int res = 0;
		
		if (n <= 2) {
			return res;
		}
		for (int i = 2; i < n; i++) {
			if (isPrimes(i)) {
				++res;
			}
		}
		return res;
	}
	
	public boolean isPrimes(int i) {
		
		//为啥只需要判断到根号n,
		//因为如果一个数是合数，那必然:
		//1.其因子为x或x,x=根号n
		//2.一个小于根号x,一个大于根号x
		//所以只需要判断【2，根号n]
		for (int j = 2; j * j <= i; j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new Test().countPrimes2(499979));
	}
	
	
	public int countPrimes2(int n) {
		
		if (n <= 2) {
			return 0;
		}
		int res = 0;
		int[] arr = new int[n];
		Arrays.fill(arr, 1);
		for (int i = 2; i < n; i++) {
			if (arr[i] == 1) {
				++res;
				if(i*i<n){
					for (int j = i * i; j < n; j+=i) {
						arr[j] = 0;
					}
				}
				
			}
		}
		return res;
		
	}
}
