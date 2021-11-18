package com.dair.sbxx.day53;


import com.dair.sbxx.day50.TreeNode;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	/**
	 * 求数的坡度
	 *
	 * @param root
	 * @return
	 */
	
	public int findTilt(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return findTilt(root.left)+ findTilt(root.right)+ (returnRes(root.left) - returnRes(root.right) > 0 ? returnRes(root.left) - returnRes(root.right) : returnRes(root.right) - returnRes(root.left));
	}
	
	private int returnRes(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return node.val+ returnRes(node.left) + returnRes(node.right);
	}
	
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
		System.out.println(new Test().findTilt(treeNode));
	}
	
}
