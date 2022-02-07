package com.dair.sbxx.year2021.day50;


/**
 * @author Dair
 * @since
 */
public class Test {
	
	public TreeNode invertTree(TreeNode root) {
		invert(root);
		return root;
	}
	
	
	private void invert(TreeNode node) {
		if (node == null) {
			return;
		}
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		invert(node.left);
		invert(node.right);
	}
}
