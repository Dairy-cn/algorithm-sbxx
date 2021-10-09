package com.dair.sbxx.day37;

import java.util.Arrays;
import java.util.HashMap;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/9
 ************************************************************/
public class Test {
	
	
	public void outputByAgeDesc(int[] age, int[] weight) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		//32,37,40,1
		//1.高效的方法，调用native方法
		int[] tempArr = new int[age.length];
		System.arraycopy(age, 0, tempArr, 0, age.length);
		//2.int[] tempArr=Arrays.copyOf(age,age.length);
		
		//3.for循环赋值
		
		//4.int[] tempAr = age.clone();
		
		for (int i = 0; i < tempArr.length; i++) {
			map.put(i, i);
			for (int j = i + 1; j < tempArr.length; j++) {
				if (tempArr[j] > tempArr[i]) {
					int temp = tempArr[j];
					tempArr[j] = tempArr[i];
					tempArr[i] = temp;
					map.put(i, j);
				}
			}
		}
		for (int i = 0; i < age.length; i++) {
			Integer integer = map.get(i);
			System.out.println(age[integer] + " " + weight[integer]);
		}
	}
	
	
	public static void main(String[] args) {
		//output 37 22
		// 32 11
		//25 33
		//1 44
		//输入年龄和体重，根据年龄倒叙输出年龄和对应的体重
		new Test().outputByAgeDesc(new int[]{32, 37, 25, 1}, new int[]{11, 22, 33, 44});
	}
}
