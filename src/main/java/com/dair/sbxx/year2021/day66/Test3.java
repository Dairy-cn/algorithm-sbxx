package com.dair.sbxx.year2021.day66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	public String toLowerCase(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				c |= 32;
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
	/**
	 * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
	 * <p>
	 * 补全词 是一个包含 licensePlate 中所有字母的单词。
	 * <p>
	 * 在匹配 licensePlate 中的字母时：
	 * <p>
	 * 忽略 licensePlate 中的 数字和空格 。
	 * 不区分大小写。
	 * 如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
	 * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
	 * <p>
	 * 请你找出并返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 第一个 出现的那个。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/shortest-completing-word
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param licensePlate
	 * @param words
	 * @return
	 */
	public String shortestCompletingWord(String licensePlate, String[] words) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < licensePlate.length(); i++) {
			if (licensePlate.charAt(i) == ' ' || (licensePlate.charAt(i) >= '0') && licensePlate.charAt(i) <= '9') {
				continue;
			} else {
				int c = licensePlate.charAt(i);
				if (c >= 'A' && c <= 'Z') {
					c |= 32;
				}
				map.put((char) c, map.getOrDefault((char) c, 0) + 1);
			}
		}
		List<String> stringList = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			HashMap<Integer, Integer> localMap = (HashMap<Integer, Integer>) map.clone();
			for (int j = 0; j < word.length(); j++) {
				Integer integer = localMap.get(Integer.valueOf(word.charAt(j)));
				if (integer == null) {
					continue;
				} else {
					if (--integer == 0) {
						localMap.remove(Integer.valueOf(word.charAt(j)));
					} else {
						localMap.put(Integer.valueOf(word.charAt(j)), integer);
					}
				}
			}
			if (localMap.isEmpty()) {
				stringList.add(word);
			}
		}
		Collections.sort(stringList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
				
			}
		});
		
		return stringList.get(0);
	}
	
	
	public String shortestCompletingWord2(String licensePlate, String[] words) {
		
		int[] cnt = new int[26];
		for (int i = 0; i < licensePlate.length(); i++) {
			char c = licensePlate.charAt(i);
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
				if ((c >= 'A' && c <= 'Z')) {
					c |= 32;
				}
				cnt[c - 'a']++;
			}
		}
		String ans = null;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			boolean flag = true;
			
			int[] c = new int[26];
			for (int j = 0; j < word.length(); j++) {
				c[word.charAt(j) - 'a']++;
			}
			for (int j = 0; j < cnt.length; j++) {
				if (cnt[j] > c[j]) {
					flag = false;
					continue;
				}
			}
			if (flag && (ans == null || ans.length() > word.length())) {
				ans = word;
			}
		}
		return ans;
		
	}
	
	
	public String truncateSentence(String s, int k) {
		StringBuilder stringBuilder = new StringBuilder();
		int a = 1;
		for (int i = 0; i < s.length() && a < k; i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				a++;
			}
			stringBuilder.append(c);
		}
		return stringBuilder.toString();
	}
	
	static final int MOD = 1337;
	
	public int superPow(int a, int[] b) {
		int n = b.length;
		int ans = 1;
		for (int i = n - 1; i >= 0; i--) {
			ans = ans * pow(a, b[i]) % MOD;
			a = pow(a, 10);
		}
		return ans;
	}
	
	private int pow(int a, int b) {
		int res = 1;
		while (b != 0) {
			if (b % 2 != 0) {
				res = (int) ((long) res * a % MOD);
			}
			a = (int) ((long) a * a % MOD);
			
			b /= 2;
		}
		return res;
	}
	
	public int dayOfYear(String date) {
		String[] split = date.split("-");
		int year = Integer.valueOf(split[0]);
		int month = Integer.valueOf(split[1]);
		int day = Integer.valueOf(split[2]);
		int[] arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			arr[1] = 29;
		}
		int res = 0;
		for (int i = 0; i < month - 1; i++) {
			res += arr[i];
		}
		return res + day;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test3().dayOfYear("2019-02-10"));
//		System.out.println(new Test3().superPow(2147483647, new int[]{2, 0, 0}));
//		System.out.println(new Test3().shortestCompletingWord2("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"
//		}));
	}
	
}
