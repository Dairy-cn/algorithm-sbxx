package com.dair.sbxx.year2021.day38;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/10/10
 ************************************************************/
public class Test {
	
	
	public int arrangeCoins(int n) {
		
		if (n <= 0) {
			return 0;
		}
		int res = 1;
		int total = 0;
		while (total <= n) {
			total += res;
			if (total + res + 1 <= n) {
				++res;
			}
		}
		return res;
		
	}
	
	//通过二分法找到满足n<=k*(k+1)/2的最小数
	public int arrangeCoins3(int n) {
		int left = 1;
		int right = n;
		while (left < right) {
			int mid = left + right + 1 >> 1;
			int s = mid * (mid + 1) / 2;
			if (s > n) {
				right = mid - 1;
			} else if (s == n) {
				return mid;
			} else {
				left = mid;
			}
		}
		return left;
	}
	
	public int arrangeCoins2(int n) {
		return (int) (Math.sqrt(1 + 8.0 * n) - 1) / 2;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().arrangeCoins3(6));
	}
}
