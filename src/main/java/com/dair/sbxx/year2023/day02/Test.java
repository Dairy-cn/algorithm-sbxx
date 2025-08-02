package com.dair.sbxx.year2023.day02;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public int numWays(int n, int[][] relation, int k) {
		//动态规划
		//1、确定初始状态
		// 2、确定结束状态
		//3、确定状态转移过程
		int[][] f = new int[k + 1][n];
		//初始状态
		f[0][0] = 1;
		//2 f[k][n-1] 即走了k步，到n-1位置的方案数
		//状态转移
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < relation.length; j++) {
				int a = relation[j][0];
				int b = relation[j][1];
				f[i][b] += f[i - 1][a];
			}
		}
		return f[k][n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
		
	}
}
