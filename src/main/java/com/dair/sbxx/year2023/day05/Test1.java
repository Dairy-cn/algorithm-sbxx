package com.dair.sbxx.year2023.day05;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dair
 * @since
 */
public class Test1 {
	/**
	 * 给你一个字符串数组 words，每一个字符串长度都相同，令所有字符串的长度都为 n。
	 * <p>
	 * 每个字符串words[i]可以被转化为一个长度为n - 1的差值整数数组difference[i]，其中对于0 <= j <= n - 2有difference[i][j] = words[i][j+1] - words[i][j]。注意两个字母的差值定义为它们在字母表中位置之差，也就是说'a'的位置是0，'b'的位置是1，'z'的位置是25。
	 * difference[i][j] = words[i][j+1] - words[i][j]
	 * words = ["adc","wzy","abc"]
	 * [3,-1] [2,-1] [1,1]
	 * 比方说，字符串"acb"的差值整数数组是[2 - 0, 1 - 2] = [2, -1]。
	 * words中所有字符串 除了一个字符串以外，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
	 * <p>
	 * 请你返回words中差值整数数组不同的字符串。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/odd-string-difference
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public String oddString(String[] words) {
		String word = words[0];
		int[][] ints = new int[words.length][word.length() - 1];
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length() - 1; j++) {
				int i1 = words[i].charAt(j + 1) - 96 - (words[i].charAt(j) - 96);
				ints[i][j] = i1;
			}
			
		}
		for (int i = 2; i < ints.length; i++) {
			//a b c
			if (arrEquals(ints[i - 1],ints[i - 2]) && arrEquals(ints[i],ints[i - 1])) {
				continue;
			} else if (arrEquals(ints[i - 1],ints[i - 2])) {
				return words[i];
			} else if (arrEquals(ints[i],ints[i - 2])) {
				return words[i - 1];
			} else {
				return words[i - 2];
			}
		}
		return "";
	}
	
	
	private boolean arrEquals(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = new Test1().oddString(new String[]{"adc", "wzy", "abc"});
		System.out.println(s);
	}
}
