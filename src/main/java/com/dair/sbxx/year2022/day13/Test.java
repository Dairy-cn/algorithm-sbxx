package com.dair.sbxx.year2022.day13;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public int[] shortestToChar(String s, char c) {
		int[] arr = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				arr[i] = 0;
			} else {
				int j = 1;
				while (i + j < s.length() || i - j >= 0) {
					if ((i + j < s.length() && s.charAt(i + j) == c) || (i - j >= 0 && s.charAt(i - j) == c)) {
						break;
					}
					j++;
				}
				arr[i] = j;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] ints = new Test().shortestToChar("loveleetcode", 'e');
		for (int anInt : ints) {
			System.out.println(anInt);
		}
	}
}
