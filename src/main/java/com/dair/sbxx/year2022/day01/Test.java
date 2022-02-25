package com.dair.sbxx.year2022.day01;

import java.util.PriorityQueue;

/**
 * @author Dair
 * @since
 */
public class Test {
	/**
	 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
	 * <p>
	 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
	 * <p>
	 * s 是一个尽可能长的快乐字符串。
	 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
	 * s 中只含有 'a'、'b' 、'c' 三种字母。
	 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/longest-happy-string
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public String longestDiverseString(int a, int b, int c) {
		String res = "";
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
		if (a > 0) {
			priorityQueue.offer(new int[]{0, a});
		}
		if (b > 0) {
			priorityQueue.offer(new int[]{1, b});
		}
		if (c > 0) {
			priorityQueue.offer(new int[]{2, c});
		}
		while (!priorityQueue.isEmpty()) {
			int[] poll = priorityQueue.poll();
			if (res != "" && (char) ('a' + poll[0]) == res.charAt(res.length() - 1)) {
				if (!priorityQueue.isEmpty()) {
					int[] pollSecond = priorityQueue.poll();
					priorityQueue.offer(poll);
					int i = pollSecond[0];
					int j = pollSecond[1];
					res = res + String.valueOf((char) ('a' + i));
					j -= 1;
					if (j > 0) {
						priorityQueue.offer(new int[]{i, j});
					}
				} else {
					break;
				}
				
			}else {
				int i = poll[0];
				int j = poll[1];
				if (j >= 2) {
					res = res + String.valueOf((char) ('a' + i)) + String.valueOf((char) ('a' + i));
					j -= 2;
				} else {
					res = res + String.valueOf((char) ('a' + i));
					j -= 1;
				}
				if (j > 0) {
					priorityQueue.offer(new int[]{i, j});
				}
			}
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().longestDiverseString(0, 8, 11));
	}
}
