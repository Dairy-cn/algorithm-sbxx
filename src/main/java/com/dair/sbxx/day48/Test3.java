package com.dair.sbxx.day48;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	
	/**
	 * 中序遍历
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode prev = null;
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (root.right == null || root.right == prev) {
				res.add(root.val);
				prev = root;
				root = null;
			} else {
				stack.push(root);
				root = root.right;
			}
			
			
		}
		
		return res;
		
	}
	
	
}
