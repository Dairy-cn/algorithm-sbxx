package com.dair.sbxx.year2021.day82;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	
	int res;
	int pre;
	
	public int getMinimumDifference(TreeNode root) {
		res = Integer.MAX_VALUE;
		pre = -1;
		dfs(root);
		return res;
	}
	
	private void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.left);
		if (pre == -1) {
			pre = root.val;
		} else {
			res = Math.min(res, Math.abs(pre - root.val));
		}
		dfs(root.right);
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
		TreeNode curr = root;
		List<Integer> list = new ArrayList<>();
		while (curr != null) {
			if (curr.left != null) {
				TreeNode leftNode = curr.left;
				while (leftNode.right != null && leftNode.right != curr) {
					leftNode = leftNode.right;
				}
				TreeNode mostRight = leftNode;
				if (mostRight.right == null) {
					mostRight.right = curr;
					curr = curr.left;
				} else if (mostRight.right == curr) {
					list.add(curr.val);
					curr = curr.right;
					mostRight.right = null;
				}
			} else {
				list.add(curr.val);
				curr = curr.right;
			}
			
			
		}
		return list;
	}
	
	public void morrisPre(TreeNode root) {
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left != null) {
				TreeNode leftNode = curr.left;
				while (leftNode.right != null) {
					leftNode = leftNode.right;
				}
				TreeNode mostRight = leftNode;
				if (mostRight.right == null) {
					mostRight.right = curr;
					curr = curr.left;
				} else if (mostRight.right == curr) {
					mostRight.right = null;
					curr = curr.right;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode left = new TreeNode(3);
		TreeNode right = new TreeNode(2, left, null);
		TreeNode root = new TreeNode(1, null, right);
		List<Integer> list = new Test2().inorderTraversal(root);
		System.out.println(list);
	}
}
