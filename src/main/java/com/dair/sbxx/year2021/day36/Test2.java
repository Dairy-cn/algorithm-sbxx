package com.dair.sbxx.year2021.day36;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/10/8
 ************************************************************/
public class Test2 {
	
	
	public int myAtoi(String s){
		if(s==null || s.length()==0){
			return 0;
		}
		int n=s.length();
		int index=0;
		while (index<n && s.charAt(index)==' '){
			++index;
		}
		if(index==n){
			return 0;
		}
		int flag=1;
		
		String substring = s.substring(index, n);
		if(substring.charAt(0)=='+') {
			++index;
		}else if(substring.charAt(0)=='-'){
			++index;
			flag=-1;
		}
		int res=0;
		while (index<n){
			char c = substring.charAt(index);
			if(c>'9' || c<'0'){
				break;
			}
			if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && c-'0'>Integer.MAX_VALUE%10)){
				return Integer.MAX_VALUE;
			}
			if(res<Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE/10 && c-'0'>-Integer.MIN_VALUE%10)){
				return Integer.MIN_VALUE;
			}
			 res = res * 10 + (c - '0') * flag;
			index++;
		}
		
		return res;
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test2().myAtoi("-42"));;
	}
}
