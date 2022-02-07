package com.dair.sbxx.year2021.day57;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	//给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。
	// 按 升序 返回原始的数字。
	public String originalDigits(String s) {
		//zero, one, two, three, four, five, six, seven, eight, nine
		// 0    1     2     3      4     5    6     7      8     9
		//  z      0
		//  e      0,1,3,5,7,8,9
		// r       0,3,4
		//o        0,1,2,4
		// n       1 7 9
		// t       2 ,3,8
		//w        2
		//  h      3 8
		// f       4 5
		// u       4
		//i        5 6 8 9
		//s        6 7
		// x        6
		// v        5,7
		//g         8
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		List<Integer> list = new ArrayList<Integer>(){
			{
				for (int i = 0; i < 10; i++) {
					this.add(0);
				}
			}
		};
		list.set(0, map.getOrDefault('z', 0));
		list.set(2, map.getOrDefault('w', 0));
		list.set(4, map.getOrDefault('u', 0));
		list.set(6, map.getOrDefault('x', 0));
		list.set(8, map.getOrDefault('g', 0));
		list.set(5, map.getOrDefault('f', 0) - list.get(4));
		list.set(3, map.getOrDefault('h', 0) - list.get(8));
		list.set(7, map.getOrDefault('s', 0) - list.get(6));
		list.set(1, map.getOrDefault('o', 0) - list.get(0) - list.get(2) - list.get(4));
		list.set(9, map.getOrDefault('i', 0) - list.get(5) - list.get(6) - list.get(8));
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < list.get(i); j++) {
				sb.append(i + "");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().originalDigits("owoztneoer"));
	}
	
}
