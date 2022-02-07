package com.dair.sbxx.year2021.day16;


import java.util.*;

/**
 * 给出两个字符串 S和 T，要求在O(n)的时间复杂度内在 S中找出最短的包含 T 中所有字符的子串。
 * 例如：
 * S ="XDOYEZODEYXNZ"
 * T ="XYZ"
 * 找出的最短子串为"YXNZ"
 * 注意：
 * 如果 S 中没有包含 T 中所有字符的子串，返回空字符串 “”；
 * 满足条件的子串可能有很多，但是题目保证满足条件的最短的子串唯一。
 * 按如下方式写：
 * public class Solution {
 *     /**
 *      *
 *      * @param S string字符串
 *      * @param T string字符串
 *      * @return string字符串
 *      */

public class Solution {
	
	
	
	public String minWindow2(String S, String T) {
		int[] map = new int[128];
		//init map, 记录T中每个元素出现的次数
		for(int i = 0; i < T.length(); i++) {
			map[T.charAt(i)]++;
		}
		
		// begin end两个指针指向窗口的首位，d记录窗口的长度， counter记录T中还有几个字符没被窗口包含
		int begin = 0, end = 0, d = Integer.MAX_VALUE, counter = T.length(), head = 0;
		// end指针一直向后遍历
		while(end < S.length()) {
			// map[] > 0 说明该字符在T中出现，counter-- 表示对应的字符被包含在了窗口，counter--,
			//如果s中的字符没有在T中出现，则map[]中对应的字符-1后变为负值
			if(map[S.charAt(end++)]-- > 0) {
				counter--;
			}
			// 当counter==0时，说明窗口已经包含了T中的所有字符
			while (counter == 0) {
				if(end - begin < d) {
					d = end - (head = begin);
				}
				if(map[S.charAt(begin++)]++ == 0) {  // begin开始后移，继续向后寻找。如果begin后移后指向的字符在map中==0，表示是在T中出现的，如果没有出现，map[]中的值会是负值。
					counter++;                      // 在T中的某个字符从窗口中移除，所以counter++。
				}
			}
		}
		return d==Integer.MAX_VALUE ? "" :S.substring(head, head+d);
	}
	
	 public String minWindow(String s,String t){
	 	String res="";
		Set<String> subSet=new HashSet<>();
		 for (int i = 1; i < s.length(); i++) {
			 for (int j = 0; j+i<=s.length() ; j++) {
				 subSet.add(s.substring(j,j+i));
			 }
		 }
		 HashMap<String,Integer> map=new HashMap<>();
		 String temp="";
		 for (String e : subSet) {
			 if(e.length()>=t.length()){
			 	boolean flag=true;
				 for (int i = 0; i < t.length(); i++) {
					 if(!e.contains(String.valueOf(t.charAt(i)))){
						 flag=false;
						 break;
					 }
				 }
				 if(flag){
					 temp=e;
					 map.put(e,e.length());
				 }
			 }
		 }
		 Integer minSubCount=map.get(temp);
		 for(Map.Entry<String,Integer> e:map.entrySet()) {
			 if(e.getValue()<minSubCount){
				 minSubCount=e.getValue();
			 }
		 }
			 for(Map.Entry<String,Integer> e:map.entrySet()){
			   if(e.getValue().equals(minSubCount)){
				   res=e.getKey();
			   }
		   }
		   return res;
	 }
	
	public static void main(String[] args) {
		Solution solution=new Solution();
		
		System.out.println(solution.minWindow2("XDOYEZODEYXNZ","YXNZ"));
	}
	 
}
