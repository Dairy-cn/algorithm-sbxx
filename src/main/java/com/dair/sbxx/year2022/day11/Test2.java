package com.dair.sbxx.year2022.day11;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	/**
	 * 矩阵相乘
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int matrixA[][] ={
				{1, 1},
				{0, 1}
		};
		int matrixB[][] = {
				{1},
				{1}
		};
		int matrix[][] = new Test2().matrixMultiple(matrixA, matrixB);
		print(matrix);
	}
	private static void print(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] matrixMultiple(int[][] matrixA, int[][] matrixB) {
		int[][] res = new int[matrixA.length][matrixB[0].length];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				//A的每一行对应的数字乘以B的每一列对应的数字和
				int a = 0;
				for (int k = 0; k < res.length; k++) {
					a += matrixA[i][k] * matrixB[k][j];
				}
				res[i][j] = a;
			}
		}
		
		return res;
	}
}
