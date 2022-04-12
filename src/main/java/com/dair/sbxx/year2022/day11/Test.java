package com.dair.sbxx.year2022.day11;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public int dp(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[] arr = new int[n];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			long temp = arr[i - 1] + arr[i - 2];
			arr[i] = (int) (temp % 1000000007);
		}
		return arr[n - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().fib(2));
	}
	
	public int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		long[][] mat = new long[][]{{1, 1}, {1, 0}};
		//f(n)/f(n-1)=mat^n-1*f1/f0
		long[][] res = new long[][]{{1}, {0}};
		int x = n - 1;
		while (x > 0) {
			if (x % 2 == 1) {
				res = mut(mat, res);
			}
			mat = mut(mat, mat);
			x /= 2;
		}
		return (int) (res[0][0]%(1e9 + 7));
	}
	
	public long[][] mut(long[][] mat, long[][] res) {
		long[][] ans = new long[mat.length][res[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				for (int k = 0; k < ans.length; k++) {
					ans[i][j] += mat[i][k] * res[k][j];
					ans[i][j] %= 1e9 + 7;
				}
			}
		}
		return ans;
	}
}
