package com.dair.sbxx.year2022.day19;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	/**
	 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
	 * <p>
	 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
	 * <p>
	 *  
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/verifying-an-alien-dictionary
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param words
	 * @param order
	 * @return
	 */
	public boolean isAlienSorted(String[] words, String order) {
		int[] arr = new int[order.length()];
		for (int i = 0; i < order.length(); i++) {
			int index = order.charAt(i) - 'a';
			arr[index] = i;
		}
		//["hello","leetcode"] apple,app
		for (int i = 1; i < words.length; i++) {
			String first = words[i - 1];
			String second = words[i];
			String minStr = first.length() > second.length() ? second : first;
			boolean flag = true;
			for (int j = 0; j < minStr.length() && flag; j++) {
				if (arr[first.charAt(j) - 'a'] > arr[second.charAt(j) - 'a']) {
					return false;
				} else if (arr[first.charAt(j) - 'a'] == arr[second.charAt(j) - 'a']) {
					if (j + 1 == minStr.length() && first.length() > second.length()) {
						return false;
					}
				} else {
					flag = false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().isAlienSorted(new String[]{"apple","app"},"abcdefghijklmnopqrstuvwxyz"));
	}
}
