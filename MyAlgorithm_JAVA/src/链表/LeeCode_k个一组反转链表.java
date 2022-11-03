package 链表;

public class LeeCode_k个一组反转链表 {

	/**
	 * 给定链表，1 -> 2 -> 3 -> 4 -> 5
	 * k = 2   2 -> 1 -> 3 -> 4 -> 5
	 *
	 */
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
}
