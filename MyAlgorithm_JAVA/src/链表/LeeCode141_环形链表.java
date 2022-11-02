package 链表;

public class LeeCode141_环形链表 {
	/*
	 * 判断链表中是否有环
	 * 快慢指针，如果不含有环，快指针最终会遇到null，说明不含环
	 * 如果含有环，快指针最终会超慢指针一圈，和慢指针相遇。
	 */
	public class ListNode{
		int val;
		ListNode next;
	}
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slowNode = head;
	
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slowNode = slowNode.next;
		}
		if (slowNode == fast) {
			return true;
		}
		return false;
	}
}
