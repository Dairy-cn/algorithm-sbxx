package com.dair.sbxx.day6;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		Integer[] inputArr=new Integer[n];
		for(int i = 0; i < n; i++){
			inputArr[i] = sc.nextInt();
			
		}
		
		Set<List<Integer>> res=new HashSet<>();
		/** check(0,inputArr,res,new ArrayList<Integer>());**/
		for(int i=0;i<1<<inputArr.length;i++){
			List<Integer> temp=new ArrayList<>();
			for(int j=0;j<inputArr.length;j++){
				if(((1<<j) & i)!=0){
					temp.add(inputArr[j]);
				}
			}
			res.add(temp);
		}
		for(List<Integer> list:res){
			int listCount=0;
			for(int i=0;i<list.size();i++){
				listCount+=list.get(i);
			}
			if(listCount==24){
				++ans;
			}
			
		}
		System.out.print(ans);
	}
	
	
	/** public static void check(int i,Integer[] arr,List<List<Integer>> res,List<Integer> temp){
	 res.add(new ArrayList<>(temp));
	 for(int j=0;j<arr.length;j++){
	 temp.add(arr[j]);
	 check(j+1,arr,res,temp);
	 temp.remove(temp.size()-1);
	 }
		
	 }**/
}