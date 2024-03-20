package 数组;

import java.util.PriorityQueue;

public class testDemo {
	
	public class ListNode {
		int val;
		ListNode next;
	}
	public ListNode mergeKLists(ListNode[] lists) {
		
		ListNode dummy = new ListNode();
		ListNode p = dummy;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>();
		
		for (ListNode head : lists) {
			if (head != null) {
				pq.add(head);
			}
		}
		
		
		while (!pq.isEmpty()) {
			ListNode node = pq.poll();
			p.next = node;
			if (node.next != null) {
				pq.add(node);
			}
			
			p = p.next;
		}
		
		return dummy.next;
		
		
	}
}
