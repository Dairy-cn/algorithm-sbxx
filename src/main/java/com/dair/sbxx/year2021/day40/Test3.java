package com.dair.sbxx.year2021.day40;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/10/13
 ************************************************************/
public class Test3 {
	
	
	public String intToRoman(int num) {
		int[] nums=new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] str=new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		//3231
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i <nums.length ; i++) {
			int temp=nums[i];
			
			if(num>temp){
				
				while (num>temp){
					num-=temp;
					sb.append(str[i]);
				}
				
			}else if(num==temp){
				sb.append(str[i]);
				num-=temp;
				break;
			}
			if(num==0){
				break;
			}
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Test3().intToRoman(3));
	}
	
	
}
