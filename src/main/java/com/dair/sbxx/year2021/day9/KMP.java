package com.dair.sbxx.year2021.day9;


/**
 * @author Dair
 * @since
 */
public class KMP {
	

	public int solution(char[] text, char[] part) {
		if (part.length == 0 || text.length == 0 || text.length < part.length) {
			return -1;
		}
		int[] next = getNext(String.valueOf(part));
		
		for (int i = 0, j = 0; i < text.length; ) {
			if (text[i] != part[j]) {
				if (next[j] == -1) {
					i++;
				} else {
					i = i - next[j];
					j = 0;
				}
			} else {
				if (j == part.length - 1) {
					return i - part.length + 1;
				} else {
					i++;
					j++;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 获取最匹配子串
	 *
	 * @param b
	 * @return
	 */
	public int[] getNext(String b) {
		int len = b.length();
		int j = 0;
		//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
		int next[] = new int[len + 1];
		next[0] = -1;
		next[1] = 0;
		//i表示字符串的下标，从0开始
		for (int i = 1; i < len; i++) {
			//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
			while (j > 0 && b.charAt(i) != b.charAt(j)) {
				j = next[j];
			}
			if (b.charAt(i) == b.charAt(j)) {
				j++;
			}
			next[i + 1] = j;
		}
		
		return next;
	}
	
	
	public static void main(String[] args) {
		KMP kmp = new KMP();
		System.out.println(kmp.solution("BBC ABCDAB ABCDABCDABDE".toCharArray(), "ABCDABD".toCharArray()));
	}
}
