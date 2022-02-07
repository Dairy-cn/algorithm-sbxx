package com.dair.sbxx.year2021.day49;

import java.util.*;

/*************************************************************
 * Description:
 * Author: Dair
 * Date: year2021/11/2
 ************************************************************/
public class Test {
	
	
	/**
	 * 后序遍历（非递归）
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		
		//后序遍历 左右中
		//先得到中右左后反转
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		TreeNode node = root;
		Deque<TreeNode> stack = new LinkedList<>();
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				res.add(node.val);
				stack.push(node);
				node = node.right;
			}
			node = stack.pop();
			node = node.left;
		}
		
		Collections.reverse(res);
		return res;
	}
	
	
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> res=new ArrayList<>();

		if(root==null){
			return res;
		}
		traversal(root,res);
		return  res;
	}
	private void traversal(TreeNode node,List<Integer>  list){
		if(node==null){
			return;
		}
		traversal(node.left,list);
		traversal(node.right,list);
		list.add(node.val);
	}
	
	
}
