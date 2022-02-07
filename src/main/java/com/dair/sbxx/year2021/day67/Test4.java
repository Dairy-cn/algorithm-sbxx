package com.dair.sbxx.year2021.day67;

/**
 * @author Dair
 * @since
 */
public class Test4 {
	
	private static final long MOD = 1000000007;
	
	public int concatenatedBinary(int n) {
		StringBuilder binaryString = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			int a = i;
			StringBuilder sb = new StringBuilder();
			while (a > 0) {
				sb.append(a % 2);
				a /= 2;
			}
			binaryString.append(sb.reverse());
		}
		int length = binaryString.length();
		int m = 0;
		long res = 0;
		for (int i = length - 1; i >= 0; i--) {
			res += (binaryString.charAt(i) - '0') * pow(2, m++);
			res %= MOD;
		}
		return (int) res;
	}
	
	private long pow(long a, int b) {
		long res = 1;
		while (b != 0) {
			if (b % 2 != 0) {
				res = (res * a) % MOD;
			}
			a = (a * a) % MOD;
			b /= 2;
		}
		return res;
	}
	
	public static void main(String[] args) {
		
//		System.out.println(new Test4().concatenatedBinary2(4));
		System.out.println(new Test4().minDeletionSize(new String[]{"zyx","wvu","tsr"}));
		
	}
	
	
	public int concatenatedBinary2(int n) {
		int a = 0;
		long res = 0;
		for (int i = 1; i <= n; i++) {
			if ((i & (i - 1)) == 0) {
				a++;
			}
			res = ((res << a) + i) % MOD;
		}
		return (int) res;
	}
	
	public int leastMinutes(int n) {
		int res = 0;
		int a = 1;
		while (a < n) {
			a = 2 * a;
			res++;
		}
		return res;
	}
	
	public int minDeletionSize(String[] strs) {
		
		int n = strs[0].length();
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < strs.length; j++) {
				if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
					res++;
				}
			}
		}
		return res;
	}
	
	
}
