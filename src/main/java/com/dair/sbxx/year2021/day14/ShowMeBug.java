//package com.dair.sbxx.day14;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
///*************************************************************
// * Description:
// * Author: Dair
// * Date: year2021/6/29
// ************************************************************/
//
//	public class ShowMeBug {
//
//	public List<Integer> inorderTraversal(TreeNode root) {
//		//中序遍历
//		Math.abs()
//		List<Integer> list=new ArrayList<>();
//		if(root==null){
//			return list;
//		}
//		List<TreeNode> linkedList=new LinkedList<>();
//		while(root!=null || linkedList.size()!=0){
//			while(root!=null){
//				linkedList.add(root);
//				root=root.left;
//			}
//			root= linkedList.removeFirst();
//			list.add(root.val);
//			root=root.right;
//		}
//
//
//
//		return list;
//
//	}
//
//
//
//		public static void main(String[] args) {
//			List<String> list=new ArrayList<String>();
//			list.add("cab");
//			list.add("ab");
//			list.add("dab");
//			String[] arr={"ab","ab","abbc"};
//			System.out.println(longestCommonPrefix(arr));
//
//		}
//
//		public static String bubbleSort(List<String> strList) {
//			String res="";
//			if (strList == null || strList.size() == 0) {
//				return res;
//			}
//			if(strList.size()==1){
//				return strList.get(0);
//			}
//			for(int i=1;i<res.length();i++){
//				while (!strList.get(i).startsWith(res)){
//					res=res.substring(0,res.length()-1);
//					if(res.length()==0){
//						return "";
//					}
//				}
//			}
//			return res;
//		}
//
//	public static String longestCommonPrefix(String[] strs) {
//		if (strs == null || strs.length == 0) {
//			return "";
//		}
//		int length = strs[0].length();
//		int count = strs.length;
//		for (int i = 0; i < length; i++) {
//			char c = strs[0].charAt(i);
//			for (int j = 1; j < count; j++) {
//				if (i == strs[j].length() || strs[j].charAt(i) != c) {
//					return strs[0].substring(0, i);
//				}
//			}
//		}
//		return strs[0];
//	}
//}
