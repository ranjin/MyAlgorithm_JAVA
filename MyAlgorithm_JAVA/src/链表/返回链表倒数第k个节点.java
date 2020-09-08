package 链表;


public class 返回链表倒数第k个节点 {
	public class ListNode{
		int val;
		ListNode next;
	}
	
	public int kthToLast(ListNode head, int k) {
		if (head == null) {
			return -1;
		}
		ListNode fastNode = head;
		ListNode slowNode = head;
		for (int j = 0; j < k; j++) {
			fastNode = fastNode.next;
		}
		while (fastNode != null) {
			fastNode = fastNode.next;
			slowNode = slowNode.next;
		}
		return slowNode.val;
	}
}
