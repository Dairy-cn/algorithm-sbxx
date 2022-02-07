package com.dair.sbxx.year2021.day50;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		TreeNode res = root;
		
		while (true) {
			
			if (res.val > p.val && res.val > q.val) {
				res = res.right;
			} else if (res.val < p.val && res.val < q.val) {
				res = res.left;
			} else {
				break;
			}
		}
		return res;
	}
}
