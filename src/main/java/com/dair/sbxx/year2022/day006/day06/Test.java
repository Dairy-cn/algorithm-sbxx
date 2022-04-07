package com.dair.sbxx.year2022.day006.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test {
	public static void main(String[] args) {
		new Test().permuting(new String[]{"1", "2", "3"}, 0);
		for (String strings : list) {
			System.out.println(strings);
		}
	}
	
	private static List<String> list = new ArrayList<>();
	
	private void permuting(String[] arr, int index) {
		if (index == arr.length - 1) {
			StringBuilder sb = new StringBuilder();
			for (String s : arr) {
				sb.append(s);
			}
			list.add(sb.toString());
			return;
		}
		for (int i = index; i < arr.length; i++) {
			swap(arr, index, i);
			permuting(arr, index + 1);
			swap(arr, index, i);
		}
	}
	
	private void swap(String[] arr, int a, int b) {
		String temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}
}
