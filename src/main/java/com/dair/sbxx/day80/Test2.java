package com.dair.sbxx.day80;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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
	
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> list = new ArrayList<>();
		
		if (n == 0) {
			list.add(null);
			return list;
		}
		return getAns(1, n);
		
	}
	
	private List<TreeNode> getAns(int s, int n) {
		List<TreeNode> list = new ArrayList<>();
		
		if (s > n) {
			list.add(null);
			
			return list;
		}
		if (s == n) {
			TreeNode treeNode = new TreeNode(s);
			list.add(treeNode);
			return list;
		}
		for (int i = s; i <= n; i++) {
			List<TreeNode> leftNode = getAns(s, i - 1);
			List<TreeNode> rightNode = getAns(i + 1, n);
			
			//左子树右子树两两组合
			for (TreeNode leftTree : leftNode) {
				for (TreeNode rightTree : rightNode) {
					TreeNode root = new TreeNode(i);
					root.left = leftTree;
					root.right = rightTree;
					//加入到最终结果中
					list.add(root);
				}
			}
			
		}
		return list;
	}
	
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		System.out.println(new Test2().binaryTreePaths(4));
	}

//	List<String> list = new ArrayList<>();
	
	public List<String> binaryTreePaths(TreeNode root) {
		binary(root, "");
		return list;
	}
	
	public void binary(TreeNode root, String s) {
		if (root != null) {
			s += root.val;
		} else {
			return;
		}
		if (root.left != null || root.right != null) {
			binary(root.left, s);
			binary(root.right, s);
		} else {
			list.add(s);
		}
	}
	
	
	public List<String> binaryTreePaths2(TreeNode root) {
		ArrayList<String> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
		Queue<String> pathQueue = new ArrayDeque<>();
		treeNodeQueue.offer(root);
		while (!treeNodeQueue.isEmpty()) {
			TreeNode poll = treeNodeQueue.poll();
			String s = "";
			if (!pathQueue.isEmpty()) {
				s = pathQueue.poll();
			}
			StringBuilder sb = new StringBuilder(s + poll.val);
			if (poll.right != null) {
				treeNodeQueue.offer(poll.right);
				pathQueue.offer(sb.toString());
			}
			if (poll.left != null) {
				treeNodeQueue.offer(poll.left);
				pathQueue.offer(sb.toString());
			}
			if (poll.right == null && poll.left == null) {
				list.add(sb.toString());
			}
		}
		return list;
	}
	
	public int sumOfLeftLeaves(TreeNode root) {
		int res = 0;
		if (root == null) {
			return res;
		}
		Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
		treeNodeQueue.offer(root);
		while (!treeNodeQueue.isEmpty()) {
			TreeNode poll = treeNodeQueue.poll();
			if (poll.left != null) {
				if (poll.left.left == null && poll.left.right == null) {
					res += poll.left.val;
				}
				treeNodeQueue.offer(poll.left);
			}
			if (poll.right != null) {
				treeNodeQueue.offer(poll.right);
			}
		}
		System.out.println();
		return res;
	}
	
	public int[] findMode(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return new int[1];
		}
		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
		treeNodeQueue.offer(root);
		while (!treeNodeQueue.isEmpty()) {
			TreeNode poll = treeNodeQueue.poll();
			Integer inter = map.getOrDefault(poll.val, 0);
			if (max < inter + 1) {
				list = new ArrayList<>();
				list.add(inter + 1);
				max = inter + 1;
			} else if (max == inter + 1) {
				list.add(inter + 1);
			}
			map.put(poll.val, inter + 1);
			if (poll.left != null) {
				treeNodeQueue.offer(poll.left);
			}
			if (poll.right != null) {
				treeNodeQueue.offer(poll.right);
			}
		}
		int[] arr=new int[list.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=list.get(i);
		}
		return arr;
	}
}
