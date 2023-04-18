package 链表;

public class 返回链表倒数第k个节点 {
	public class ListNode{
		int val;
		ListNode next;
	}
	/**
	 * 思路：
	 * 双指针：
	 * 第一个节点先走k步，那么剩下的为n - k步。
	 * 让两个节点同时走，直至第一个节点为null。那么第二个节点所走步数为 n - k;
	 */
	public ListNode kthToLast(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		ListNode p1 = head;
		for(int i = 0; i < k; i++) {
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
