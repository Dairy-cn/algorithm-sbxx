package com.dair.sbxx.day36;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/8
 ************************************************************/
public class Test {
	
	
	public final int L = 10;
	
	
	public List<String> findRepeatedDna(String str) {
		
		
		List<String> resList = new ArrayList<>();
		
		HashMap<String, Integer> map = new HashMap<>();
		int n = str.length();
		
		for (int i = 0; i <= n - L; i++) {
			
			String substring = str.substring(i, i + L);
			map.put(substring, map.getOrDefault(substring, 0) + 1);
			if (map.get(substring) == 2) {
				resList.add(substring);
			}
		}
		return resList;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new Test().findRepeatedDna("AAAAAAAAAAA"));
		
		
	}
}
