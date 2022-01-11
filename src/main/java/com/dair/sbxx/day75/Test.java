package com.dair.sbxx.day75;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public boolean isAdditiveNumber(String num) {
		
		int n = num.length();
		//secondStart
		for (int i = 1; i < n - 1; i++) {
			if (num.charAt(0) == '0' && i != 1) {
				break;
			}
			for (int j = i; j < n - 1; j++) {
				if (num.charAt(i) == '0' && j != i) {
					break;
				}
				if (check(num, i, j)) {
					return true;
				}
				
			}
			
		}
		return false;
		
	}
	
	public boolean check(String num, int secondSart, int secondEnd) {
		
		int n = num.length();
		int firstStart = 0;
		int firstEnd = secondSart - 1;
		while (secondEnd <= n - 1) {
			String third = stringAdd(num, firstStart, firstEnd, secondSart, secondEnd);
			int thirdStart = secondEnd + 1;
			int thirdEnd = secondEnd + third.length();
			if (thirdEnd >= n || !num.substring(thirdStart, thirdEnd + 1).equals(third)) {
				break;
			}
			if (thirdEnd == n - 1) {
				return true;
			}
			firstStart = secondSart;
			firstEnd = secondEnd;
			secondSart = thirdStart;
			secondEnd = thirdEnd;
		}
		return false;
	}
	
	
	public String stringAdd(String num, int fristSart, int fristEnd, int secondStart, int secondEnd) {
		String first = num.substring(fristSart, fristEnd + 1);
		String second = num.substring(secondStart, secondEnd + 1);
		int n = first.length();
		int m = second.length();
		int length = Math.max(first.length(), second.length());
		int s = Math.abs(n - m);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < s; i++) {
			stringBuilder.append("0");
		}
		if (n < length) {
			first = stringBuilder+first ;
		}
		if (m < length) {
			second = stringBuilder+second ;
		}
		int i = length - 1;
		boolean flag = false;
		StringBuilder sb = new StringBuilder("");
		while (i >= 0) {
			int a = first.charAt(i) - '0';
			int b = second.charAt(i) - '0';
			int c = a + b;
			if (flag) {
				c += 1;
			}
			if (c >= 10) {
				flag = true;
			} else {
				flag = false;
			}
			sb.append(c % 10);
			--i;
		}
		if (flag) {
			sb.append("1");
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().isAdditiveNumber("199100199"));
	}
}
