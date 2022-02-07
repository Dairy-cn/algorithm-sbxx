package com.dair.sbxx.year2021.day6;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: year2021/4/30
 ************************************************************/
public class ArrMerge {
	
	
	public class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			int b=0;
			int a=0;
			boolean isEnd=false;
			while (a<m){
				if(isEnd){
				
				}
				for (int j=a;j<m; j++){
					//【1,2,4，0，0】,【2,3】
					if(nums1[j]>nums2[b]){
						//移动
						move(nums1,j);
						nums1[j]=nums2[b++];
						a=j+1;
						break;
						
					}
				}
			}
			
		}
		public void move(int[] arr,int index){
			for (int i = arr.length-1; i >=index; i--) {
				arr[i]=arr[i-1];
			}
		}
	}
	
	public static void main(String[] args) {
		ArrMerge.Solution solution=new ArrMerge().new Solution();
		int[] arr1={1,2,3,0,0,0};
		int[] arr2={2,5,6};
		
		solution.merge(arr1,6,arr2,3);
	}
	
	
//	public boolean isSymmetric(TreeNode root) {
//		return check(root, root);
//
//	}
//
//	public boolean check(TreeNode p, TreeNode q) {
//		if (p == null && q == null) {
//			return true;
//		}
//		if (p == null || q == null) {
//			return false;
//		}
//		return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
//	}
	
}
