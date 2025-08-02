package com.dair.sbxx.year2023.day03;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public int[] countBits(int n) {
		int[] arr = new int[n + 1];
		int highBit = 0;
		for (int i = 1; i <= n; i++) {

//			arr[i] = arr[i >> 1] + (i & 1);
//			arr[i] = arr[i & (i - 1)] + 1;
			if ((i & (i - 1)) == 0) {
				highBit = i;
			}
			
			arr[i] = arr[i - highBit] + 1;
		
		}
		//11 10 10
		//101 100 100
		//111 100 110 +1
		//110 101 100 +1
		return arr;
	}
	
	//10>>1&1
	//11>>1&1
	public int countBits2(int n) {
		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 1; i <= n; i++) {
			int count = 0;
			while (i > 0) {
				if (i % 2 == 1) {
					count++;
				}
				i /= 2;
			}
			arr[i] = arr[i - 1] + count;
		}
		return arr[n];
	}
	
	public static void main(String[] args) {
		int[] ints = new Test().countBits(5);
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
	}
}
