package com.dair.sbxx.day56;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public boolean buddyStrings(String s, String goal) {
		if (s == null || goal == null || s == "" || goal == "") {
			return false;
		}
		
		if (s.length() != goal.length()) {
			return false;
		}
		if (s.equals(goal)) {
			for (int i = 0; i < s.length(); i++) {
				StringBuilder sb = new StringBuilder(s);
				sb.replace(i, i + 1, "");
				if (sb.toString().contains(s.charAt(i) + "")) {
					return true;
				}
			}
		}
		Integer index = null;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != goal.charAt(i)) {
				if (index == null) {
					index = i;
				} else {
					StringBuilder sb = new StringBuilder(s);
					sb.replace(i, i + 1, s.charAt(index) + "");
					sb.replace(index, index + 1, s.charAt(i) + "");
					s = sb.toString();
					if (s.equals(goal)) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().buddyStrings2("abab", "baba"));
	}
	
	
	public boolean buddyStrings2(String s, String goal) {
		//如果两个字符串长度不相等，则一定不是
		if (s == null || goal == null || goal == "" || s == "") {
			return false;
		}
		int m = s.length();
		int n = goal.length();
		if (m != n) {
			return false;
		}
		//如果s和goal的长度和词频不相同
		//如果不相同的个数为2
		//或者不相同的个数为0，且s中有出现次数超过2的字符
		int[] cnt1 = new int[26];
		int[] cnt2 = new int[26];
		int sum = 0;
		for (int i = 0; i < m; i++) {
			int a = s.charAt(i) - 'a';
			int b = goal.charAt(i) - 'a';
			cnt1[a]++;
			cnt2[b]++;
			if (a != b) {
				sum++;
			}
		}
		boolean isOk = false;
		for (int i = 0; i < 26; i++) {
			if (cnt1[i] != cnt2[i]) {
				//词频不一样，直接返回false
				return false;
			}
			if (cnt1[i] > 1) {
				isOk = true;
			}
		}
		return sum == 2 || (sum == 0 && isOk);
		
	}
	
}
