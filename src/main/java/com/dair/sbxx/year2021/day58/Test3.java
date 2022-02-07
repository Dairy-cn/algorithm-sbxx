package com.dair.sbxx.year2021.day58;

import com.dair.sbxx.year2021.day50.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	
	/**
	 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
	 * <p>
	 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
	 * 如果不存在祖父节点值为偶数的节点，那么返回0 。
	 * <p>
	 * <p>
	 * <p>
	 * 示例：
	 * <p>
	 * <p>
	 * <p>
	 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
	 * 输出：18
	 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 树中节点的数目在1 到10^4之间。
	 * 每个节点的值在1 到100 之间。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	public int sumEvenGrandparent(TreeNode root) {
		int res = 0;
		List<TreeNode> list = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		while (root != null || !queue.isEmpty()) {
			if (root == null) {
				root = queue.poll();
			}
			if (root.val % 2 == 0) {
				list.add(root);
			}
			if (root.right != null) {
				queue.add(root.right);
			}
			root = root.left;
		}
		if (!CollectionUtils.isEmpty(list)) {
			for (TreeNode treeNode : list) {
				if (treeNode.left != null) {
					TreeNode left = treeNode.left;
					TreeNode left11 = left.left;
					if (left11 != null) {
						res += left11.val;
					}
					TreeNode left12 = left.right;
					if (left11 != null) {
						res += left12.val;
					}
				}
				if (treeNode.right != null) {
					TreeNode right = treeNode.right;
					TreeNode left21 = right.left;
					if (left21 != null) {
						res += left21.val;
					}
					TreeNode left22 = right.right;
					if (left22 != null) {
						res += left22.val;
					}
				}
				
			}
			
		}
		return res;
	}
	
	
}
