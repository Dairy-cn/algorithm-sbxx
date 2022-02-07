package com.dair.sbxx.year2021.day78;

import java.util.Random;

/**
 * @author Dair
 * @since
 */
public class Solution {
	
	
	ListNode node;
	
	Random random = new Random();
	
	public Solution(ListNode head) {
		this.node = head;
	}
	
	public int getRandom() {
		ListNode listNode = this.node;
		int i = 1;
		int res = 0;
		while (listNode != null) {
			if (random.nextInt(i) == 0) {
				res = listNode.val;
			}
			i++;
			listNode = listNode.next;
		}
		return res;
	}
	
	
	/**
	 * 方法一需要花费 O(n)O(n) 的空间存储链表中的所有元素，那么能否做到 O(1)O(1) 的空间复杂度呢？
	 * <p>
	 * 我们可以设计如下算法：
	 * <p>
	 * 从链表头开始，遍历整个链表，对遍历到的第 ii 个节点，随机选择区间 [0,i)[0,i) 内的一个整数，如果其等于 00，则将答案置为该节点值，否则答案不变。
	 * <p>
	 * 该算法会保证每个节点的值成为最后被返回的值的概率均为 \dfrac{1}{n}
	 * n
	 * 1
	 * ​
	 * ，证明如下：
	 * <p>
	 * \begin{aligned} &P(第\ i\ 个节点的值成为最后被返回的值)\\ =&P(第\ i\ 次随机选择的值= 0) \times P(第\ i+1\ 次随机选择的值\ne 0) \times \cdots \times P(第\ n\ 次随机选择的值\ne 0)\\ =&\dfrac{1}{i} \times (1-\dfrac{1}{i+1}) \times \cdots \times (1-\dfrac{1}{n})\\ =&\dfrac{1}{i} \times \dfrac{i}{i+1} \times \cdots \times \dfrac{n-1}{n}\\ =&\dfrac{1}{n} \end{aligned}
	 * =
	 * =
	 * =
	 * =
	 * ​
	 * <p>
	 * P(第 i 个节点的值成为最后被返回的值)
	 * P(第 i 次随机选择的值=0)×P(第 i+1 次随机选择的值
	 * 
	 * ​
	 * =0)×⋯×P(第 n 次随机选择的值
	 * 
	 * ​
	 * =0)
	 * i
	 * 1
	 * ​
	 * ×(1−
	 * i+1
	 * 1
	 * ​
	 * )×⋯×(1−
	 * n
	 * 1
	 * ​
	 * )
	 * i
	 * 1
	 * ​
	 * ×
	 * i+1
	 * i
	 * ​
	 * ×⋯×
	 * n
	 * n−1
	 * ​
	 * <p>
	 * n
	 * 1
	 * ​
	 * <p>
	 * ​
	 * <p>
	 * <p>
	 * Python3C++JavaC#GolangCJavaScript
	 * <p>
	 * <p>
	 * 作者：LeetCode-Solution
	 * 链接：https://leetcode-cn.com/problems/linked-list-random-node/solution/lian-biao-sui-ji-jie-dian-by-leetcode-so-x6it/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
	
	
	class ListNode {
		int val;
		ListNode next;
		
		ListNode() {
		}
		
		ListNode(int val) {
			this.val = val;
		}
		
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
}
