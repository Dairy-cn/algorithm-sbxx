package com.dair.sbxx.year2022.day32;

/**
 * @author Dair
 * @since
 */
public class Test {
	/**
	 * 给你一个字符串s，它仅包含字符'a' 和'b' 。
	 * <p>
	 * 你可以删除s中任意数目的字符，使得s 平衡。当不存在下标对(i,j)满足i < j ，且s[i] = 'b' 的同时s[j]= 'a' ，此时认为 s 是 平衡 的。
	 * <p>
	 * 请你返回使 s平衡的 最少删除次数
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public int minimumDeletions(String s) {
		boolean flg = true;
		int leftb = 0;
		int righta = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				++righta;
			}
		}
		//aababbab 4
		int res = righta;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				righta--;
			} else {
				leftb++;
			}
			res = Math.min(res, leftb + righta);
		}
		
		return res;
	}
}
