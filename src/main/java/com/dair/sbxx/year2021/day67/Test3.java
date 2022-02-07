package com.dair.sbxx.year2021.day67;


/**
 * @author Dair
 * @since
 */
public class Test3 {
	class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode t1 = headA;
		ListNode t2 = headB;
		
		int a = 0, b = 0;
		while (t1 != null) {
			a++;
			t1 = t1.next;
		}
		while (t2 != null) {
			b++;
			t2 = t2.next;
		}
		int c = Math.abs(a - b);
		if (a > b) {
			while (c-- > 0) {
				headA = headA.next;
			}
		} else {
			while (c-- > 0) {
				headB = headB.next;
			}
		}
		while (headA != null && headB != null) {
			if (headA.equals(headB)) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}
	
	
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		
		ListNode t1 = headA;
		ListNode t2 = headB;
		while (t1 != t2) {
			t1 = t1 == null ? headB : t1.next;
			t2 = t2 == null ? headA : t2.next;
		}
		return t1;
		
	}
}
