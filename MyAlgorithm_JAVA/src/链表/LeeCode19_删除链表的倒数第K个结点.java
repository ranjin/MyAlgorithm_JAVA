package 链表;

/**
 * 思路：
 * 删除第N个节点，那么得先获取到第n - 1个节点。
 * @author ranjin
 *
 */
public class LeeCode19_删除链表的倒数第K个结点 {
	public class ListNode{
		public ListNode(int val) {
			this.val = val;
		}
		
		int val;
		ListNode next;
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 虚拟头结点
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		// 删除倒数第n个，则需要先找到倒数第n+1个结点
		ListNode x = findFromEnd(dummy, n+1);
		// 删除倒数的第n个结点
		x.next = x.next.next;
		return dummy.next;
	}
	
	// 返回链表倒数第k个结点
	public ListNode findFromEnd(ListNode head, int k) {
		ListNode p1 = head;
		for (int i = 0; i < k; i++) {
			p1 = p1.next;
		}
		
		ListNode p2 = head;
		// 此时，p1和p2同时走，直到p1走到头
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
}
