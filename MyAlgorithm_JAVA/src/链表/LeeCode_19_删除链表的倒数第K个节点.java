package 链表;

/**
 * 给你一个链表，删除链表的倒数第N个节点，并且返回链表的头节点
 * 考点：
 * 1、通过双指针技巧获取链表的倒数第N个节点
 * 2、通过虚拟头节点的技巧，要想删除倒数第N个节点，需要先获取到倒数第n+1个节点
 */

public class LeeCode_19_删除链表的倒数第K个节点 {

	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 虚拟头节点
		// 由于需要找倒数第n + 1个节点，所以有空指针的情况，这里需要用到虚拟节点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		// 要想删除倒数第N个，需要先找到倒数第N+1个节点
		ListNode kNode = getKthFromEnd(dummy, n+1);
		// 删除倒数第N个节点
		kNode.next = kNode.next.next;
		return dummy.next;
	}
	
	
	// 让p1先走k步，然后同时走,当p1走完，自然p2的位置就是倒数第k个位置
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode p1 = head;
		for (int i = 0; i < k; i++) {
			p1 = p1.next;
		}
		ListNode p2 = head;
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
}
