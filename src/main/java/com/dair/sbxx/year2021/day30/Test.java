package com.dair.sbxx.year2021.day30;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/9/30
 ************************************************************/
public class Test {
	
	
	public static void main(String[] args) {
		String str1="12321";
		String str2="921";
		int n1 = str1.length();
		int n2 = str2.length();
		int i = n1 - n2;
		if(i!=0){
			StringBuilder appendString=new StringBuilder("");
			for (int j = 0; j <Math.abs(i) ; j++) {
				appendString.append("0");
			}
			if(i>0){
				str2=appendString.toString()+str2;
			}else {
				str1=appendString.toString()+str1;
			}
		}
		int a=0;
		StringBuilder res=new StringBuilder("");
		for (int j = str1.length()-1; j>=0; j--) {
			char char1=str1.charAt(j);
			char char2=str2.charAt(j);
			int temp=(char1-'0')+(char2-'0')+a;
			if(temp>9){
				a=1;
				res.append(temp%10);
			}else {
				a=0;
				res.append(temp);
			}
			
		}
		if(a==1){
			res.append(a);
		}
		System.out.println(res.reverse());
		
	}
}
