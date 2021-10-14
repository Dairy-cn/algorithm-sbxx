package com.dair.sbxx.day39;

import java.util.Arrays;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/11
 ************************************************************/
public class Test3 {
	
	public int[] xorQueries(int[] arr, int[][] queries) {
		
		int[] resArr = new int[queries.length];
		
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			int left = query[0];
			int right = query[1];
			int temp = arr[left];
			for (int j = left + 1; j <= right; j++) {
				temp = temp ^ arr[j];
			}
			resArr[i] = temp;
			
		}
		return resArr;
		
	}
	
	//转换思路，异或==》a^a=0;a^0=a
	//如求4-6项的，不需要分别计算4，5，6的异或值
	//可以推倒出arr[4]^arr[5]^arr[6]=arr[1]^arr[2]^arr[3]^(arr[1]^arr[2]^arr[3]^arr[4]^arr[5]^arr[6])
	public int[] xorQueries2(int[] arr, int[][] queries) {
		
		int[] sum = new int[arr.length + 1];
		
		for (int i = 0; i < arr.length; i++) {
			sum[i + 1] = sum[i] ^ arr[i];
		}
		int[] res = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			int left = query[0] + 1;
			int right = query[1] + 1;
			res[i] = sum[left - 1] ^ sum[right];
		}
		return res;
		
	}
	
	
	public static void main(String[] args) {
		
		int[] ints = new Test3().xorQueries2(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 0}});
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
	}
	
	
}
