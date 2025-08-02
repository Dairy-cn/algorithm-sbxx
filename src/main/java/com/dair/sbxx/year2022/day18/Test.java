package com.dair.sbxx.year2022.day18;

import java.util.TreeMap;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		
		if (root == null) {
			return null;
		}
		if (root.val <= p.val) {
			return inorderSuccessor(root.right, p);
		}
		TreeNode ans = inorderSuccessor(root.left, p);
		TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();
		return ans == null ? root : ans;
	}
}
