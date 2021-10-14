package com.dair.sbxx.day39;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/11
 ************************************************************/
public class Test {
	
	
	
	
	public String[] findWords(String[] words){
		
		HashMap<Character,Integer> map=new HashMap<>();
		// 第一行由字符 "qwertyuiop" 组成。
        // 第二行由字符 "asdfghjkl" 组成。
        // 第三行由字符 "zxcvbnm" 组成。
		String str1="qwertyuiop";
		String str2="asdfghjkl";
		String str3="zxcvbnm";
		
		for (int i = 0; i <str1.length() ; i++) {
			map.put(str1.charAt(i),1);
		}
		for (int i = 0; i <str2.length() ; i++) {
			map.put(str2.charAt(i),2);
		}
		for (int i = 0; i <str3.length() ; i++) {
			map.put(str3.charAt(i),3);
		}
		List<String> res=new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int state=0;
			boolean flag=true;
			for (int j = 0; j <word.length() ; j++) {
				char c = word.charAt(j);
				if(c>='A'&& c<='Z'){
					c=(char)(c+32);
				}
				if(state!=0){
					if(state!=map.get(c)){
						flag=false;
						break;
					}
				}else {
					state=map.get(c);
				}
			}
			if(flag){
				res.add(word);
			}
		}
		
		return (String[]) res.toArray();
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().findWords(new String[]{"Hello","Alaska","Dad","Peace"}));;
	}
	
	
	
}
