package com.dair.sbxx.year2021.day5;


/**
 * @author Dair
 * @since
 */
public class DeleteDuplicates {
	
	
	public ListNode solution(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			}else {
				cur=cur.next;
			}
		}
		return head;
	}
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	static class ListNode {
		int val;
		
		ListNode next;
		
		public ListNode() {
		}
		
		public ListNode(int val) {
			this.val = val;
		}
		
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
		
		public int getVal() {
			return val;
		}
		
		public void setVal(int val) {
			this.val = val;
		}
		
		public ListNode getNext() {
			return next;
		}
		
		public void setNext(ListNode next) {
			this.next = next;
		}
	}
}
