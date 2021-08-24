package com.dair.sbxx.day17;

<<<<<<< HEAD

import com.dair.sbxx.day14.A;

import java.util.*;

//给定一个整数数组nums,你需要找出一个连续子数组，如果对这个子数组进行升序排序，那么整个数组都会变化为升序排序。
//		请你找出符合题意的最短子数组，并输出它的长度。
//		例子1：
//		输入:nums=[2,6,4,8,10,9,15]
//		输出：5
//		解释：你只需要对[6,4,8,10,9]进行升序排序，那么整个表都会是升序排序
//		例子2：
//		输入:nums=[1,3,4,5]
//		输出：0
//		例子3：
//		输入：Nums=[1]
//		输出:0
//		提示：
//		1<nums.length<=10^4
//		-10^5 <=nums[i] <=10^5
//		时间复杂度<=O(nlgn)，最优化解满足O(n)
public class Solution {
	
	  public int miniLength(int[] nums){
	  	if(isSort(nums)){
	  		return 0;
		}
	    int[] temp= Arrays.copyOf(nums,nums.length);
	    Arrays.sort(temp);
	    
	    int m=0;
	    int n=nums.length-1;
	    for (int i = 0; i <nums.length ; i++) {
			  if(temp[i]==nums[i]){
				 ++m;
			  }else {
				  break;
			  }
		  }
		  for (int i = nums.length-1; i>=0 ; i--) {
			  if(temp[i]==nums[i]){
				  --n;
			  }else {
			  	break;
			  }
		  }
			  return n-m+1;
	  }
	  
	  private boolean isSort(int[]  nums){
		  for (int i = 1; i <nums.length ; i++) {
			  if(nums[i]<nums[i-1]){
			  	return false;
			  }
		  }
		  return true;
	  }
	
	public static void main(String[] args) {
		Solution solution=new Solution();
		int i = solution.miniLength(new int[]{2,6,4,8,10,9,15});
		System.out.println(i);
		
	}
	  
=======
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Solution {
	
	List<List<Integer>> res;
	
	
	public static void main(String[] args) {
		Solution solution=new Solution();
		List<List<Integer>> subsets = solution.subsets(new int[]{3, 5, 9});
		System.out.println(subsets);
	}
	public List<List<Integer>> subsets(int[] nums) {
		res = new ArrayList<>();
		backtrack(0, new ArrayList<Integer>(), nums, nums.length);
		return res;
	}
	
	private void backtrack(int index, ArrayList<Integer> tmp, int[] nums, int n){
		res.add(new ArrayList<Integer>(tmp));
		for(int i = index; i < n; i++){
			tmp.add(nums[i]);
			backtrack(i + 1, tmp, nums, n);
			tmp.remove(tmp.size() - 1);
		}
	}
	

>>>>>>> 99548ba9f2b1345b7191c2eb27f0b8b9c018f62b
	
}
