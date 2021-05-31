package com.dair.sbxx.day10;

/**
 * @author Dair
 * @since
 */
public class LengthOfLastWord {
	public static int solution(String s) {
		
		int res = 0;
		if (s == null || s == "" || s == " ") {
			return res;
		}
		String[] s1 = s.split(" ");
		
		
		String s2 = s1[s1.length - 1];
		if (s2 != null) {
			res = s2.length();
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		int length = solution("hello world");
		System.out.println(length);
	}
}
