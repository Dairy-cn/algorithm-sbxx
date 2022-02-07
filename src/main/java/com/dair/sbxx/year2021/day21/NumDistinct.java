package com.dair.sbxx.year2021.day21;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class NumDistinct {
	
	
	public int numDistinct(String s, String t) {
		int m = s.length();
		int n = t.length();
		if (n > m) {
			return 0;
		}
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < n; i++) {
			dp[i][n] = 1;
		}
		for (int i = m - 1; i >= 0; i--) {
			char c = s.charAt(i);
			for (int j = n - 1; j >= 0; j--) {
				char d = t.charAt(j);
				if (c == d) {
					dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1];
				} else {
					dp[i][j] = dp[i + 1][j];
				}
			}
			
		}
		return dp[0][0];
	}
	
	
	public String method(String s, int numRows) {
		if (numRows < 2) {
			return s;
		}
		List<StringBuilder> list = new ArrayList<>();
		for (int i = 0; i < Math.min(s.length(), numRows); i++) {
			list.add(new StringBuilder());
		}
		int index = 0;
		int flag = -1;
		for (int i = 0; i < s.length(); i++) {
			list.get(index).append(s.charAt(i));
			if (index == 0 || index == numRows - 1) {
				flag = -flag;
			}
			index += flag;
		}
		StringBuilder outputString = new StringBuilder();
		list.forEach(e -> {
			outputString.append(e);
		});
		return outputString.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.valueOf("1"));
		System.out.println(new NumDistinct().numDistinct("rabbbit", "rabbit"));
	}
}
