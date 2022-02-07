package com.dair.sbxx.year2021.day21;

/**
 * @author Dair
 * @since
 */
public class LongestCommonSub {
	
	
	public int solution(String text1, String text2) {
		
		int n = text1.length();
		int m = text2.length();
		
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i < n; i++) {
			char c1 = text1.charAt(i);
			for (int j = 0; j < m; j++) {
				char c2 = text2.charAt(j);
				if (c1 == c2) {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestCommonSub().isSubsequence("aec", "abcde"));
	}
	
	public boolean isSubsequence(String s, String t) {
		int n = s.length();
		int m = t.length();
		if (n > m) {
			return false;
		}
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][m] == n;
		
	}
}
