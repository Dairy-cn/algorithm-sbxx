package com.dair.sbxx.year2021.day45;

import java.util.*;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	//new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}
	public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
		HashMap<Integer,Integer> map = new HashMap<>();
		Deque<Integer> stack = new LinkedList<>();
		for(int i=0;i<nums2.length;i++){
			while(!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]){
				int j = stack.pop();
				map.put(nums2[j],nums2[i]); // 此时nums2[j]<nums2[i]
			}
			stack.push(i); // 下标入栈
		}
		int[] ans = new int[nums1.length];
		for(int i=0;i<nums1.length;i++){
			ans[i] = map.getOrDefault(nums1[i],-1);
		}
		return ans;
	}
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = nums2.length - 1; i >= 0; i--) {
			int num = nums2[i];
			while (!stack.isEmpty() && num > stack.peek()) {
				stack.pop();
			}
			map.put(num, stack.isEmpty() ? -1 : stack.peek());
			stack.push(num);
		}
		
		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.get(nums1[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		for (int t :
				new Test2().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})) {
			System.out.println(t);
			
		}
	}
	
}
