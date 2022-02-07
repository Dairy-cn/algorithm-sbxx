package com.dair.sbxx.year2021.day1;

/*************************************************************
 * Description: 一个数组，切分成两部分，保证两遍都有数，怎么切，保证Max左-Max右的绝对值最大？
 * Author: Dairy
 * CreateTime: year2021/4/23
 ************************************************************/
public class CalculateMaxAbsolute {
	public static void main(String[] args) {
		System.out.println(new CalculateMaxAbsolute().addBinary("1010","1011"));
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
	
	public int solution(int[] arr){
		//设定较大的数在左边
		//为了保证绝对值最大，则右边的数要最小，则划到第n-1的时候右边数最小
		
		//获取第一个到n-1个的最大值
		int rMax=arr[0];
		for (int i = 1; i < arr.length-1; i++) {
			if(arr[i]>rMax){
				rMax=arr[i];
			}
		}
		int rMaxAbsolute=rMax-arr[arr.length-1];
		
		//设定较大的数在右边
		//为保证绝对值最大，则左边的数要最小，则划到第一个的时候左边的数最小
		//获取第2个大n个的最大值
		int lMax=arr[1];
		for (int i = 2; i < arr.length; i++) {
			if(arr[i]>lMax){
				lMax=arr[i];
			}
		}
		int lMaxAbsolute=lMax-arr[0];
		
		return Math.max(lMaxAbsolute, rMaxAbsolute);
		
	}



}
