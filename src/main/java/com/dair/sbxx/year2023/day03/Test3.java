package com.dair.sbxx.year2023.day03;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	public int reverseBits(int num) {
		//转变为二进制
		boolean numFlg = true;
		if (num < 0) {
			numFlg = false;
			num = -num;
		}
		int[] list = new int[32 + 1];
		int index = 0;
		while (num > 0) {
			if (num % 2 == 1) {
				list[index++] = 1;
			} else {
				list[index++] = 0;
				
			}
			num /= 2;
		}
		if (!numFlg) {
			for (int i = 0; i < list.length; i++) {
				if (list[i] == 1) {
					list[i] = 0;
				} else {
					list[i] = 1;
				}
			}
			int lastIndex = 1;
			for (int i = 0; i < list.length && lastIndex == 1; i++) {
				if (list[i] + lastIndex > 1) {
					list[i] = 0;
				} else {
					list[i] = 1;
					lastIndex = 0;
				}
			}
			
		}
		// 110100111
		int[] arr = new int[32 + 1];
		arr[0] = 0;
		boolean flg = true;
		int max = 0;
		int preNode = 0;
		for (int i = 1; i < list.length; i++) {
			if (list[i - 1] == 1) {
				arr[i] = arr[i - 1] + 1;
				max = Math.max(arr[i], max);
			} else if (flg) {
				arr[i] = arr[i - 1] + 1;
				max = Math.max(arr[i], max);
				flg = !flg;
				preNode = i;
			} else {
				i = preNode;
				arr[i] = 0;
				flg = !flg;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test3().reverseBits(-4));
	}
}
