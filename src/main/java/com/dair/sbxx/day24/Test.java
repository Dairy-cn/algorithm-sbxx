package com.dair.sbxx.day24;


import java.util.*;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		if (digits == null || digits == "") {
			return list;
		}
		Map<Integer, List<Character>> map = new HashMap<>();
		List<Character> stringList = new ArrayList<>();
		stringList.add('a');
		stringList.add('b');
		stringList.add('c');
		map.put(2, stringList);
		stringList = new ArrayList<>();
		stringList.add('d');
		stringList.add('e');
		stringList.add('f');
		map.put(3, stringList);
		stringList = new ArrayList<>();
		stringList.add('g');
		stringList.add('h');
		stringList.add('i');
		map.put(4, stringList);
		stringList = new ArrayList<>();
		stringList.add('j');
		stringList.add('k');
		stringList.add('l');
		map.put(5, stringList);
		stringList = new ArrayList<>();
		stringList.add('m');
		stringList.add('n');
		stringList.add('o');
		map.put(6, stringList);
		stringList = new ArrayList<>();
		stringList.add('p');
		stringList.add('q');
		stringList.add('r');
		stringList.add('s');
		map.put(7, stringList);
		stringList = new ArrayList<>();
		stringList.add('t');
		stringList.add('u');
		stringList.add('v');
		map.put(8, stringList);
		stringList = new ArrayList<>();
		stringList.add('w');
		stringList.add('x');
		stringList.add('y');
		stringList.add('z');
		map.put(9, stringList);
		
		int a = 0;
		int b = 0;
		ArrayList<String> returnList = new ArrayList<>();
		if (digits.length() == 0) {
			return returnList;
		} else if (digits.length() == 1) {
			int inputInt = Integer.valueOf(digits);
			a = inputInt % 10;
		}else {
			int inputInt = Integer.valueOf(digits);
			a = inputInt / 10;
			b = inputInt % 10;
		}
		List<Character> aList = map.get(a);
		List<Character> bList = map.get(b);
		for (int i = 0; i < aList.size(); i++) {
			StringBuilder stringBuilder = new StringBuilder(aList.get(i).toString());
			if (bList != null && bList.size() > 0) {
				ArrayList<String> subList = new ArrayList<>();
				for (int j = 0; j < bList.size(); j++) {
					StringBuilder subString = new StringBuilder(stringBuilder);
					subString.append(bList.get(j).toString());
					subList.add(subString.toString());
				}
				returnList.addAll(subList);
			} else {
				returnList.add(stringBuilder.toString());
			}
		}
		
		return returnList;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().letterCombinations("2"));
	}
}
