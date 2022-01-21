package com.dair.sbxx.day82;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public boolean isLongPressedName(String name, String typed) {
		//alx //aallx
		int i = 0;
		int j = 0;
		for (; i < name.length() && j < typed.length(); i++, j++) {
			
			if (name.charAt(i) != typed.charAt(j)) {
				return false;
			}
			while (j + 1 < typed.length() && i + 1 < name.length() && typed.charAt(j + 1) == name.charAt(i + 1)) {
				j++;
				i++;
			}
			while (j + 1 < typed.length() && typed.charAt(j) == typed.charAt(j + 1)) {
				j++;
			}
		}
		if (j < typed.length()) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().isLongPressedName("alex","aaleexa"));
	}
}
