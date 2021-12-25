package com.dair.sbxx.day70;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Test2 {
	
	
	class TreeNode {
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
	
	public boolean isEvenOddTree(TreeNode root) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		boolean flag = true;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int prve = flag ? 0 : Integer.MAX_VALUE;
			
			int size = queue.size();
			while (size-- > 0) {
				TreeNode treeNode = queue.poll();
				if ((flag && (prve >= treeNode.val || treeNode.val % 2 == 0)) || (!flag && (prve <= treeNode.val || treeNode.val % 2 != 0))) {
					return false;
				} else {
					prve = treeNode.val;
				}
				if (treeNode.left != null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.add(treeNode.right);
				}
				
			}
			flag = !flag;
		}
		return true;
	}
	
	
}
