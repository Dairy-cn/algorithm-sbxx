package com.dair.sbxx.year2021.day65;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/12/19
 ************************************************************/
public class Test2 {
	
	
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		
		int n = grid.length;
		int m = grid[0].length;
		int[] cRow=new int[m];
		int[] rRow=new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <m ; j++) {
				cRow[i]=Math.max(cRow[i],grid[i][j]);
				rRow[j]=Math.max(rRow[j],grid[i][j]);
			}
		}
		int res=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				res+=Math.min(cRow[i]-grid[i][j],rRow[j]-grid[i][j]);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new Test2().maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
	}
}
