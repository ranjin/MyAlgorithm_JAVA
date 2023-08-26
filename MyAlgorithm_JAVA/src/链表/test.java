package 链表;

public class test {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * 删除链表中的环
	 * 
	 * 找到环的起点
	 */
	
	public ListNode hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode slow = head, fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		
		/// 没有环
		if (fast == null || fast.next == null) {
			return null;
		}
		
		slow = head;
		
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = null;
		
		return head;
	}
}