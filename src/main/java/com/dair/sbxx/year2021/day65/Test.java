package com.dair.sbxx.year2021.day65;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/12/18
 ************************************************************/
public class Test {
	
	
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int n = grid.length;
		int[] south = new int[n];
		for (int i = 0; i < n; i++) {
			int[] ints = grid[i];
			int cMax = ints[0];
			for (int j = 1; j < ints.length; j++) {
				if (ints[j] > cMax) {
					cMax = ints[j];
				}
			}
			south[i] = cMax;
		}
		resetArr(grid);
		int[] west = new int[n];
		for (int i = n-1; i >=0; i--) {
			int[] ints = grid[i];
			int cMax = ints[0];
			for (int j = 1; j < ints.length; j++) {
				if (ints[j] > cMax) {
					cMax = ints[j];
				}
			}
			west[n-i-1] = cMax;
		}
			int[][] localMax = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				localMax[i][j] = Math.min(west[i], south[j]);
			}
		}
		int resMax = 0;
		resetArr(grid);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] < localMax[i][j]) {
					resMax += localMax[i][j] - grid[i][j];
				}
			}
		}
		
		return resMax;
	}
	
	
	private int[][] resetArr(int[][] grid) {
		int n = grid.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = grid[i][j];
				grid[i][j] = grid[j][i];
				grid[j][i] = temp;
			}
		}
		return grid;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
	}
}
