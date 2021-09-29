package com.dair.sbxx.day28;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	public static void main(String[] args) {
		System.out.println(new Test2().longestNiceSubstring("YazaAay"));
	}
	
	public String longestNiceSubstring(String s) {
		String res = "";
		if (s == null && s == "") {
			return res;
		}
		int length = s.length();
		//从最大字符开始
		// YazaAay 7 6
		
		for (int i = length - 1; i > 0; i--) {
			for (int j = 0; j + i < length; j++) {
				String subString = s.substring(j, j + i + 1);
				if (isNiceString(subString)) {
					return subString;
				}
			}
		}
		return "";
		
	}
	
	public boolean isNiceString(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int i1 = 0;
			
			if (c >= 'A' && c <= 'Z') {
				i1 = c + 32;
			} else {
				i1 = c - 32;
			}
			if (!(str.contains(String.valueOf((char) i1)))) {
				return false;
			}
		}
		return true;
		
	}
}
