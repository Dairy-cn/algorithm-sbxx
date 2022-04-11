package com.dair.sbxx.year2022.day09;

/**
 * @author Dair
 * @since
 */
public class Solution {
	
	/**
	 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
	 * <p>
	 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。 
	 * <p>
	 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
	 *  
	 *
	 * @param str
	 * @return
	 */
	public boolean rotateString(String str, String goal) {
		
		for (int i = 0; i < str.length(); i++) {
			String temp = str.substring(i, str.length()) + str.substring(0, i);
			if (temp.equals(goal)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().rotateString("abcde","bcdea"));
	}
	
	
	public boolean rotateString2(String str, String goal) {
		
		
		return (str.length()==goal.length()) && (str+str).contains(goal);
	}
}
