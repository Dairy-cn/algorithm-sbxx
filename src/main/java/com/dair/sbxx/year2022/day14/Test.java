package com.dair.sbxx.year2022.day14;

import java.util.Arrays;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	/**
	 * 给你一个由若干单词组成的句子sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
	 * <p>
	 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文- Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
	 * <p>
	 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
	 * 例如，单词 "apple" 变为 "applema" 。
	 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
	 * 例如，单词 "goat" 变为 "oatgma" 。
	 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
	 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
	 * 返回将 sentence 转换为山羊拉丁文后的句子。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/goat-latin
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	public String toGoatLatin(String sentence) {
		String[] arr = sentence.split(" ");
		StringBuilder sb = new StringBuilder("");
		String appendStr = "";
		for (int i = 0; i < arr.length; i++) {
			appendStr += "a";
			if (arr[i].charAt(0)== 'a' || arr[i].charAt(0) == 'e' || arr[i].charAt(0) == 'i' || arr[i].charAt(0) == 'o' || arr[i].charAt(0) == 'u' || arr[i].charAt(0)== 'A' || arr[i].charAt(0) == 'E' || arr[i].charAt(0) == 'I' || arr[i].charAt(0) == 'O' || arr[i].charAt(0) == 'U') {
				sb.append(" ").append(arr[i]).append("ma").append(appendStr);
			} else {
				char c = arr[i].charAt(0);
				sb.append(" ").append(arr[i].substring(1, arr[i].length())).append(c).append("ma").append(appendStr);
			}
		}
		return sb.toString().trim();
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().toGoatLatin("I speak Goat Latin"));
	}
}
