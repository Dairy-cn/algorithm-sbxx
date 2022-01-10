package com.dair.sbxx.day74;

import org.springframework.util.StringUtils;

import java.util.Stack;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public String simplifyPath(String path) {
		Stack<String> stringStack = new Stack<>();
		
		// /D/c/../
		for (int i = 0; i < path.length(); i++) {
			while (i + 1 < path.length() && path.charAt(i + 1) == '/') {
				i++;
			}
			int left = i;
			while (i + 1 < path.length() && path.charAt(i + 1) != '/') {
				i++;
			}
			String str = path.substring(left + 1, i + 1);
			if (str.equals("..")) {
				if (!stringStack.isEmpty()) {
					stringStack.pop();
				}
			} else if (!str.equals(".") && !str.equals("")) {
				stringStack.push(str);
			}
			
		}
		StringBuilder sb = new StringBuilder("/");
		for (int i = 0; i < stringStack.size(); i++) {
			String pop = stringStack.get(i);
			sb.append(pop);
			if (i != stringStack.size() - 1) {
				sb.append("/");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().simplifyPath("/home//foo/"));
	}
}
