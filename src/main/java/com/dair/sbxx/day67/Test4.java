package com.dair.sbxx.day67;

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
		
		System.out.println(new Test4().concatenatedBinary2(4));
	}
	
	
	public int concatenatedBinary2(int n) {
			int a = 0;
			long res = 0;
			for (int i = 1; i <=n; i++) {
				if((i & (i - 1))==0){
					a++;
				}
				res=((res<<a)+i)%MOD;
			}
			return (int) res;
	}
}
