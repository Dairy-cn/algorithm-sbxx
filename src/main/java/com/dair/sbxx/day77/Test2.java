package com.dair.sbxx.day77;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	public int[][] construct2DArray(int[] original, int m, int n) {
		int length = original.length;
		if (length != m * n) {
			return new int[][]{};
		}
		int[][] ints = new int[m][n];
		int index = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				ints[i][j] = original[index++];
			}
		}
		return ints;
	}
	
	public int lastRemaining(int n) {
		return 0;
	}
	
}
