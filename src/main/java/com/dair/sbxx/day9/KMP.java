package com.dair.sbxx.day9;

/**
 * @author Dair
 * @since
 */
public class KMP {
	
	//BBC ABCDAB ABCDABCDABDE
	//ABCDABD
	public int solution(char[] text, char[] part) {
		if (part.length == 0 || text.length == 0 || text.length < part.length) {
			return -1;
		}
		int res = -1;
		int index = 0;
		while (index < text.length) {
			
			if (index + part.length < text.length) {
				boolean flag = true;
				int i = 0;
				for (i = 0; i < part.length && flag; i++) {
					if (text[index + i] != part[i]) {
						flag = false;
					}
				}
				if (flag) {
					res = index;
				} else if (!flag && i == 0) {
					index++;
				} else if (!flag && i > 0) {
//					index+=i+1-
					//TODO 获取部门匹配值
				}
			}
			
			
		}
		
	}
}
