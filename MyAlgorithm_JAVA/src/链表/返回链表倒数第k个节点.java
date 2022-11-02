package 链表;

public class 返回链表倒数第k个节点 {
	public class ListNode{
		int val;
		ListNode next;
	}
	
	/**
	 * 两个for循环
	 */
	public ListNode getKthFromEnd(ListNode head, int k) {
		int i = 0;
		while (head != null) {
			head = head.next;
			i++;
		}
		
		for (int j = 0; j < i-k; j++) {
			head = head.next;
		}
		return head;
	}
	
	/**
	 * 单次遍历
	 * 倒数第k个结点：即第n-k个结点.如果让某一个结点先走k步，则当这个结点走到最后，p2刚好为倒数第k个
	 * 两个结点都指向头结点
	 * 第一个结点p1先走K步，剩下n-k步。
	 * 第二个结点p2，同时与第一个结点走，当第一个结点
	 */
	public ListNode kthToLast(ListNode head, int k) {
		if (head == null) {
			return head;
		}
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
