package com.dair.sbxx.year2021.day1;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: year2021/4/23
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/
public class SumBinary {
	
	
	public String addBinaryMethod2(String a,String b){
		
		return Integer.toBinaryString(Integer.valueOf(a,2)+Integer.valueOf(b,2));
	}
	
	public String addBinary(String a, String b) {
		String[] arrA = a.split("");
		String[] arrB =b.split("");
		int h=Math.max(arrA.length,arrB.length);
		int aLength=arrA.length-1;
		int bLength=arrB.length-1;
		int preInt=0;
		StringBuilder resultString=new StringBuilder();
		for (int i = 0; i < h && (aLength>=0 || bLength>=0); i++) {
			if(aLength>= 0 && bLength>=0){
				resultString.append((Integer.valueOf(arrA[aLength])+Integer.valueOf(arrB[bLength])+preInt)%2);
				
				preInt = (Integer.valueOf(arrA[aLength]) + Integer.valueOf(arrB[bLength]) + preInt) / 2;
				
			}else if(aLength>= 0){
				resultString.append((Integer.valueOf(arrA[aLength])+preInt)%2);
				preInt = (Integer.valueOf(arrA[aLength])  + preInt) / 2;
				
			}else {
				resultString.append((Integer.valueOf(arrB[bLength])+preInt)%2);
				
				preInt = (Integer.valueOf(arrB[bLength])  + preInt) / 2;
			}
			aLength--;
			bLength--;
			
		}
		if(preInt>0){
			resultString.append(preInt);
		}
		return resultString.reverse().toString();
		
	}
	
}
