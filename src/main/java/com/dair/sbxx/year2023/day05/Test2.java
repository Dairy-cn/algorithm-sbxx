package com.dair.sbxx.year2023.day05;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	
	public int smallestEvenMultiple(int n) {
		
		return n % 2 == 0 ? n : n * 2;
		
	}
	
	public int[] buildArray(int[] nums) {
		int[] ints = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			ints[i] = nums[nums[i]];
		}
		return ints;
	}
	
	/**
	 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
	 * <p>
	 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
	 * <p>
	 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
	 * <p>
	 * ruleKey == "type" 且 ruleValue == typei 。
	 * ruleKey == "color" 且 ruleValue == colori 。
	 * ruleKey == "name" 且 ruleValue == namei 。
	 * 统计并返回 匹配检索规则的物品数量 。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/count-items-matching-a-rule
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param items
	 * @param ruleKey
	 * @param ruleValue
	 * @return
	 */
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int index = ruleKey == "type" ? 0 : ruleKey == "color" ? 1 : 2;
		int count = 0;
		for (List<String> item : items) {
			if (item.get(index).equals(ruleValue)) {
				count++;
			}
		}
		return count;
	}
	
	public String interpret(String command) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < command.length(); i++) {
			if (i + 1 < command.length() && command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
				sb.append("o");
				i++;
			}
			if (!(command.charAt(i) == '(' || command.charAt(i) == ')')) {
				sb.append(command.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public int[] getConcatenation(int[] nums) {
		int[] ints = new int[2 * nums.length];
		System.arraycopy(nums, 0, ints, 0, nums.length);
		System.arraycopy(nums, 0, ints, nums.length, nums.length);
		return ints;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().getConcatenation(new int[]{1, 2, 1}));
		System.out.println(new Test2().smallestEvenMultiple(6));
	}
}
