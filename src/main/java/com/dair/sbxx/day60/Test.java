package com.dair.sbxx.day60;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	/**
	 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
	 * <p>
	 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
	 * <p>
	 * 名次第 1 的运动员获金牌 "Gold Medal" 。
	 * 名次第 2 的运动员获银牌 "Silver Medal" 。
	 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
	 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
	 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：score = [5,4,3,2,1]
	 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
	 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
	 * 示例 2：
	 * <p>
	 * 输入：score = [10,3,8,9,4]
	 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
	 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * n == score.length
	 * 1 <= n <= 104
	 * 0 <= score[i] <= 106
	 * score 中的所有值 互不相同
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/relative-ranks
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	public String[] findRelativeRanks(int[] score) {
		HashMap<Integer, Integer> scoreMap = new HashMap<>();
		for (int i = 0; i < score.length; i++) {
			scoreMap.put(score[i], i);
		}
		String[] res = new String[score.length];
		Arrays.sort(score);
		for (int i = score.length - 1; i >= 0; i--) {
			String str = null;
			if (i == score.length - 1) {
				str = "Gold Medal";
			} else if (i == score.length - 2) {
				str = "Silver Medal";
			} else if (i == score.length - 3) {
				str = "Bronze Medal";
			} else {
				str = score.length - i + "";
			}
			Integer integer = scoreMap.get(score[i]);
			res[integer] = str;
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] relativeRanks = new Test().findRelativeRanks(new int[]{10, 3, 8, 9, 4});
		for (String relativeRank : relativeRanks) {
			System.out.println(relativeRank);
		}
	}
}
