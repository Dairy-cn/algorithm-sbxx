package com.dair.sbxx.day40;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/13
 ************************************************************/
public class Test2 {
	
	
	String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	String[] thousands = {"", "Thousand", "Million", "Billion"};
	
	public static void main(String[] args) {
		System.out.println(new Test2().numberToWords(1112223334));
	}
	
	public String numberToWords(int num) {
		//111 111 111 111
		if (num == 0) {
			return "Zero";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
			int currNum = num / unit;
			if (currNum != 0) {
				num -= currNum * unit;
				StringBuilder currSb = new StringBuilder();
				recursion(currSb, currNum);
				currSb.append(thousands[i]).append(" ");
				sb.append(currSb);
			}
			
		}
		return sb.toString();
		
		
	}
	
	
	public void recursion(StringBuilder currSb, int currNum) {
		if (currNum != 0) {
			
			if (currNum < 10) {
				currSb.append(singles[currNum]).append(" ");
			} else if (currNum < 20) {
				currSb.append(teens[currNum%10]).append(" ");
			} else if (currNum < 100) {
				currSb.append(tens[currNum / 10]).append(" ");
				recursion(currSb, currNum % 10);
			} else {
				currSb.append(singles[currNum / 100]).append(" ");
				currSb.append("Thousand").append(" ");
				recursion(currSb, currNum % 100);
			}
			
		}
	}
	
}
