package com.dair.sbxx.day31;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/2
 ************************************************************/
public class Test {
	
	
	public String toHex(int num) {
		StringBuilder b = new StringBuilder("");
		boolean flag = true;
		if (num == 0) {
			return "0";
		} else if (num < 0) {
			flag = false;
		}
		num = num>0?num:-num;
		while (num > 0) {
			b.append(num % 2);
			num = num / 2;
		}
		for (int i = b.length(); i <= 32; i++) {
			b.append("0");
		}
		if (!flag) {
			for (int i = 0; i < b.length(); i++) {
				b.setCharAt(i, b.charAt(i) == '0' ? '1' : '0');
			}
			int a = 1;
			for (int i = 0; i < b.length(); i++) {
				int temp = b.charAt(i) - '0' + a;
				b.setCharAt(i, temp % 2 == 0 ? '0' : '1');
				if (temp == 2) {
					a = 1;
				} else {
					a = 0;
				}
			}
			b.setCharAt(31, flag ? '0' : '1');
			
		}
		StringBuilder res = new StringBuilder("");
		String str = b.toString();
		for (int i = 0; i < str.length() - 4; i = i + 4) {
			int int1 = (int) (str.charAt(i) - '0');
			int int2 = str.charAt(i + 1) - '0';
			int int3 = str.charAt(i + 2) - '0';
			int int4 = str.charAt(i + 3) - '0';
			int temp = (int) (int1 * Math.pow(2, 0) + int2 * Math.pow(2, 1) + int3 * Math.pow(2, 2) + int4 * Math.pow(2, 3));
			if (temp <= 9) {
				res.append(temp + "");
			} else {
				res.append((char) ('a' + (temp - 10)));
			}
		}
		
		StringBuilder temp = res.reverse();
		int index = 0;
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) != '0') {
				index = i;
				break;
			}
		}
		return temp.substring(index, temp.length());
		
	}
	
	
	public static void main(String[] args) {
		//-2147483648 取反还是该值
		System.out.println(new Test().toHex(-1));
	}
}
