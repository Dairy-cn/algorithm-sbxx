package com.dair.sbxx.year2021.day5;


import org.junit.jupiter.api.Test;

/**
 * @author Dair
 * @since
 */
class DeleteDuplicatesTest {
	
	@Test
	void solution() {
		DeleteDuplicates.ListNode listNode1 = new DeleteDuplicates.ListNode();
		DeleteDuplicates.ListNode listNode2 = new DeleteDuplicates.ListNode();
		DeleteDuplicates.ListNode listNode3 = new DeleteDuplicates.ListNode();
		DeleteDuplicates.ListNode listNode4 = new DeleteDuplicates.ListNode();
		listNode4.setVal(4);
		listNode3.setVal(3);
		listNode2.setVal(3);
		listNode1.setVal(1);
		listNode3.setNext(listNode4);
		listNode2.setNext(listNode3);
		listNode1.setNext(listNode2);
		DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
		DeleteDuplicates.ListNode solution = deleteDuplicates.solution(listNode1);
		
		System.out.println(solution.toString());
	}
}