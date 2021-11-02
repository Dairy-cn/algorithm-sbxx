package com.dair.sbxx.day48;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test {
	/**
	 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
	 *
	 * 题目数据保证需要删除的节点 不是末尾节点 。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param node
	 */
	public void deleteNode(ListNode node) {
		node.val=node.next.val;
		node.next=node.next.next;
	}
	
	
	public List<Integer>  preorderTraversal(ListNode root){
		List<Integer> resList=new ArrayList<>();
		if(root==null){
			return resList;
		}
		Deque<ListNode> stack=new LinkedList<>();
		ListNode node=root;
		while (node!=null || !stack.isEmpty()){
			while (node!=null){
				resList.add(node.val);
				stack.push(node);
				node=node.left;
			}
			node=stack.pop();
			node=node.right;
			
		}
		return resList;
	}
	
	/**
	 *
	 * 方法三
	 * 有一种巧妙的方法可以在线性时间内，只占用常数空间来实现前序遍历。这种方法由 J. H. Morris 在 1979 年的论文「Traversing Binary Trees Simply and Cheaply」中首次提出，因此被称为 Morris 遍历。
	 *
	 * Morris 遍历的核心思想是利用树的大量空闲指针，实现空间开销的极限缩减。其前序遍历规则总结如下：
	 *
	 * 1.新建临时节点，令该节点为 root；
	 *
	 * 2.如果当前节点的左子节点为空，将当前节点加入答案，并遍历当前节点的右子节点；
	 *
	 * 3.如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点：
	 *
	 * 		如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点。然后将当前节点加入答案，并将前驱节点的右子节点更新为当前节点。当前节点更新为当前节点的左子节点。
	 *
	 * 		如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。当前节点更新为当前节点的右子节点。
	 *
	 * 重复步骤 2 和步骤 3，直到遍历结束。
	 *
	 * 这样我们利用 Morris 遍历的方法，前序遍历该二叉树，即可实现线性时间与常数空间的遍历。
	 *
	 * 作者：LeetCode-Solution
	 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode-solution/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		
		TreeNode p1 = root,
				p2 = null;
		
		while (p1 != null) {
			p2 = p1.left;
			if (p2 != null) {
				//寻找当前节点的前驱节点（中序便利后当前节点的前面一个节点）
				while (p2.right != null && p2.right != p1) {
					p2 = p2.right;
				}
				if (p2.right == null) {
					res.add(p1.val);
					p2.right = p1;
					p1 = p1.left;
					continue;
				} else {
					p2.right = null;
				}
			} else {
				res.add(p1.val);
			}
			p1 = p1.right;
		}
		return res;
	}
	
	
}
