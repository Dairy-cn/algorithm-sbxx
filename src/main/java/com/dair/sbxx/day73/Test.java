package com.dair.sbxx.day73;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2022/1/5
 ************************************************************/
public class Test {
	
	
	
	public String modifyString(String s) {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='?'){
				char a='a';
				while ((i>0 && sb.charAt(i-1)==a) || (i<s.length()-1 && s.charAt(i+1)==a)){
					a+=1;
				}
				sb.append(a);
			}else {
				sb.append(s.charAt(i));
			}
		
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().modifyString("uba?b"));
	}
}
