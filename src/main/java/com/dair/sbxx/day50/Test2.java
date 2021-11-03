package com.dair.sbxx.day50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pPath = getPath(root, p);
		List<TreeNode> qPath = getPath(root, q);
		TreeNode res = null;
		for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
			if (pPath.get(i) == qPath.get(i)) {
				res = pPath.get(i);
			} else {
				break;
			}
		}
		return res;
		
		
	}
	
	
	private List<TreeNode> getPath(TreeNode node, TreeNode target) {
		List<TreeNode> path = new ArrayList<>();
		TreeNode root = node;
		while (root != target) {
			path.add(root);
			if (target.val > root.val) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
		path.add(root);
		return path;
	}
}
