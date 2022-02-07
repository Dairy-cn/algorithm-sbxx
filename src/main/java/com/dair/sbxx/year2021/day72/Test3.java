package com.dair.sbxx.year2021.day72;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] ints = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			ints[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			int index = ransomNote.charAt(i) - 'a';
			if (ints[index] > 0) {
				ints[index]--;
			} else {
				return false;
			}
		}
		return true;
		
	}
	
	
	public boolean isAnagram(String s, String t) {
		int n = s.length();
		int m = t.length();
		if (m > n) {
			String temp = s;
			s = t;
			t = temp;
		}
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			arr[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				return false;
			}
			
		}
		return true;
	}
}
