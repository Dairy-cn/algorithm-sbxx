package com.dair.sbxx.day24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	
	/**
	 * 输入如23 输出【ad,ae,af,bd,be,bf,cd,ce,cf】
	 *
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		List<String> resList = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return resList;
		}
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		findCombinations(resList, map, digits, 0, new StringBuilder(""));
		return resList;
	}
	
	public void findCombinations(List<String> resList, Map<Integer, String> map, String digits, int index, StringBuilder stringBuilder) {
		if (index == digits.length()) {
			resList.add(stringBuilder.toString());
		}else {
			String s = map.get(Integer.valueOf(String.valueOf(digits.charAt(index))));
			for (int i = 0; i < s.length(); i++) {
				stringBuilder.append(String.valueOf(s.charAt(i)));
				findCombinations(resList,map,digits,index+1,stringBuilder);
				stringBuilder.deleteCharAt(index);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().letterCombinations("23") );
	}
	
	
}
