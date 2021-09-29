package com.dair.sbxx.day28;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public boolean isIsomorphic(String s, String t) {
		
		int[] sArr = new int[128];
		int[] tArr = new int[128];
		int n = s.length();
		
		for (int i = 0; i < n; i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			if (sArr[sChar] != tArr[tChar]) {
				return false;
			} else {
				sArr[sChar] = i + 1;
				tArr[tChar] = i + 1;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		String s = "";
		System.out.println(new Test().isIsomorphic("egg","add"));
	}
}
