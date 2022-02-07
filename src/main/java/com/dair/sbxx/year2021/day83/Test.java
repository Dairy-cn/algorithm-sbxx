package com.dair.sbxx.year2021.day83;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		return dfs(matrix, 0, matrix[0].length - 1, target);
	}
	
	private boolean dfs(int[][] matrix, int r, int c, int target) {
		if (r < 0 || c < 0 || r == matrix.length || c == matrix[0].length) {
			return false;
		}
		if (matrix[r][c] == target) {
			return true;
		}
		return matrix[r][c] < target ? dfs(matrix, r + 1, c, target) : dfs(matrix, r, c - 1, target);
	}
	
	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int j = matrix.length - 1;
		int i = 0;
		while (j >= 0 && i <= matrix[0].length - 1) {
			if (matrix[j][i] == target) {
				return true;
			} else if (matrix[j][i] > target) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}
}
