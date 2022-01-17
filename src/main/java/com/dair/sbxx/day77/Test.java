package com.dair.sbxx.day77;

import java.util.PriorityQueue;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public int dominantIndex(int[] nums) {
		int b = 0;
		int a = -1;
		if (nums.length == 1) {
			return 0;
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[b]) {
				a = b;
				b = i;
			} else if (a == -1 || nums[i] > nums[a]) {
				a = i;
			}
		}
		return nums[b] >= nums[a] ? b : -1;
		
	}
	public int totalMoney(int n) {
		
		int res = 0;
		
		int a = n % 7;
		int index = n / 7;
		int m = 1;
		while (index-- > 0) {
			for (int i = 0; i < 7; i++) {
				res += (m + i);
			}
			m++;
		}
		for (int i = 0; i < a; i++) {
			res += (m + i);
		}
		return res;
	}
	
	
	public int kthSmallest(int[][] matrix, int k) {
		
		PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(k,(a, b)->{
			return matrix[a[0]][a[1]]-matrix[b[0]][b[1]];
		});
		int n=matrix.length;
		for (int i = 0; i < Math.min(n,k); i++) {
			priorityQueue.offer(new int[]{i,0});
		}
		int res=0;
		while (k-->0){
			int[] arr=priorityQueue.poll();
			res=matrix[arr[0]][arr[1]];
			if(arr[1]+1<n){
				priorityQueue.offer(new int[]{arr[0],arr[1]+1});
			}
		}
		return res;
	}
	public static void main(String[] args) {
//		System.out.println(new Test().totalMoney(10));
		System.out.println(new Test().kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8));

	}
}
