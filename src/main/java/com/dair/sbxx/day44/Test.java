package com.dair.sbxx.day44;

/*************************************************************
 * Description:
 * Author: Dair
 * Date: 2021/10/25
 ************************************************************/
public class Test {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == target) {
					return true;
				} else if (matrix[i][j] > target) {
					continue;
				}
			}
		}
		return false;
	}
	
	public boolean searchMatrix2(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		int x = 0;
		int y = n - 1;
		while (x < m && y >= 0) {
			if (matrix[x][y] == target) {
				return true;
			} else if (matrix[x][y] > target) {
				--y;
				
			} else {
				++x;
			}
		}
		return false;
	}
	
	public boolean searchMatrix3(int[][] matrix, int target) {
		int m = matrix.length;
		for (int i = 0; i < m; i++) {
			int[] temp = matrix[i];
			int left = 0;
			int right = temp.length - 1;
			//2,5,8,10,19
			while (left <= right) {
				//等同于int mid=(right+left)/2,但是可能会导致int 溢出
				int mid = (right - left) / 2+left;
				if (temp[mid] == target) {
					return true;
				} else if (temp[mid] > target) {
					right = mid-1;
				} else {
					left = mid + 1;
				}
				
			}
			
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		
		
		int[][] arr = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
		
		System.out.println(new Test().searchMatrix3(arr, 5));
	}
	
}
