package com.dair.sbxx.year2021.day7;

import java.util.ArrayList;
import java.util.List;

/*************************************************************
 * @Desc:
 * @author: Dair
 * @Date: year2021/5/6
 ***********************************************************/
public class SubSets {
	
	
	
	public List<List<Integer>> solution(int[] nums) {
		
		List<Integer> tempArr=new ArrayList<>();
		List<List<Integer>> list=new ArrayList<>();
		int n=nums.length;

		for (int mark=0;mark<(1<<n);++mark){
			tempArr.clear();
			for (int i=0;i<n;++i){
				if((mark & (1<<i))!=0){
					tempArr.add(nums[i]);
				}
			}
			list.add(tempArr);
		}
		return list;
		
	}
	
	public static void main(String[] args) {
		SubSets subSets=new SubSets();
		int[] arr={1,3,9,2};
		List<List<Integer>> lists = subSets.solution(arr);
		
	}
}
