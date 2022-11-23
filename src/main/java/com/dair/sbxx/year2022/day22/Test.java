package com.dair.sbxx.year2022.day22;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {
		}
		
		TreeNode(int val) {
			this.val = val;
		}
		
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root != null) {
			if (root.val > key) {
				root.left=deleteNode(root.left, key);
			} else if (root.val < key) {
				root.right= deleteNode(root.right, key);
			} else {
				if (root.left != null && root.right != null) {
					TreeNode left = root.left;
					TreeNode leftNode = root.right;
					while (leftNode.left != null) {
						leftNode = leftNode.left;
					}
					leftNode.left = left;
					root = root.right;
				} else if (root.left == null) {
					return root.right;
				} else if (root.right == null) {
					return root.left;
				}
			}
		}
		
		return root;
	}
	
}
