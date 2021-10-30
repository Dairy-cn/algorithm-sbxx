package com.dair.sbxx.day46;

import java.util.*;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/30
 ************************************************************/
public class Test {
	
	
	/**
	 * 返回数组中只出现一次的数字，顺序可任意
	 *
	 * @param nums
	 * @return
	 */
	public int[] singleNumber(int[] nums) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int length = 0;
		for (int i = 0; i < nums.length; i++) {
			Integer count = map.getOrDefault(nums[i], 0);
			if (count + 1 == 2) {
				++length;
			}
			map.put(nums[i], count + 1);
		}
		int[] res = new int[nums.length - 2 * length];
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				res[i++] = entry.getKey();
			}
		}
		return res;
		
	}
	
	/**
	 * 位运算
	 *
	 * @param nums 1,2,1,3,2,5
	 * @return
	 */
	
	public int[] singleNumber2(int[] nums) {
		// 7 =》0111
		// -7 =》 原码：10111 反码： 11000 补码：11001
		// 110011&00111=00011
		int x = 0;
		for (int i = 0; i < nums.length; i++) {
			x ^= nums[i];
		}
		int x1 = Integer.MIN_VALUE == x ? x : x ^ -x;
		
		int a = ~x1;//6=> 10110
		//反码 3 5
		++a; // 10111
		int b = a == Integer.MIN_VALUE ? a : x1 ^ a; //00110& 10111=>10110
		b = ~b; //01001
		++b; //001010
		//x1的二进制最低位为1
		int index = (int) (Math.log(b) / Math.log(2));
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & 1 << (index - 1)) >= 0) {
				list1.add(nums[i]);
			} else {
				list2.add(nums[i]);
			}
		}
		int[] res = new int[2];
		int count1 = 0;
		for (int i = 0; i < list1.size(); i++) {
			count1 ^= list1.get(i);
		}
		res[0] = count1;
		count1 = 0;
		for (int i = 0; i < list2.size(); i++) {
			count1 ^= list2.get(i);
		}
		res[1] = count1;
		return res;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test().singleNumber2(new int[]{-1638685546, -2084083624, -307525016, -930251592, -1638685546, 1354460680, 623522045, -1370026032, -307525016, -2084083624, -930251592, 472570145, -1370026032, 1063150409, 160988123, 1122167217, 1145305475, 472570145, 623522045, 1122167217, 1354460680, 1145305475}));
		;
	}
	
}
