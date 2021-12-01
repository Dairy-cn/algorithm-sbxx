package com.dair.sbxx.day59;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	/**
	 * 给你一个字符串s，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
	 * <p>
	 * 请你返回字符串的能量。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：s = "leetcode"
	 * 输出：2
	 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
	 * 示例 2：
	 * <p>
	 * 输入：s = "abbcccddddeeeeedcba"
	 * 输出：5
	 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
	 * 示例 3：
	 * <p>
	 * 输入：s = "triplepillooooow"
	 * 输出：5
	 * 示例 4：
	 * <p>
	 * 输入：s = "hooraaaaaaaaaaay"
	 * 输出：11
	 * 示例 5：
	 * <p>
	 * 输入：s = "tourist"
	 * 输出：1
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/consecutive-characters
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	
	public int maxPower(String s) {
		if (s == null || s == "") {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			int max = 1;
			while (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i) ) {
				max++;
				i++;
			}
			res = Math.max(res, max);
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().maxPower("abbcccddddeeeeedcba"));
	}
	
}
