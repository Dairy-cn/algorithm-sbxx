package com.dair.sbxx.year2022.day12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	public List<Integer> returnList(int n) {
		//给定一个数字，按字典类型返回该字典类型的排序
		ArrayList<Integer> res = new ArrayList<>();
		if (n <= 0) {
			return res;
		}
		for (int i = 0, j = 1; i < n; i++) {
			res.add(j);
			
			//1,10,100,11,12,13,14
			if (j * 10 <= n) {
				j *= 10;
			} else {
				while (j % 10 == 9 || j + 1 > n) {
					j /= 10;
				}
				++j;
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		List<Integer> list = new Test3().returnList(10);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
	}
	
}
