package com.dair.sbxx.year2022.day16;


/**
 * @author Dair
 * @since
 */
public class Test {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("OR change_content_input_items LIKE '%");
		StringBuilder out = new StringBuilder();
		String a = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,39,40,41,42,43,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,201,202,203,204,205,206,207,208,209,210";
		String[] split = a.split(",");
		for (String s : split) {
			out.append(sb).append("\"id\":").append(s).append("%' ");
		}
		System.out.println(out);
	}
	
}
