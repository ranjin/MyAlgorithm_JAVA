package 反转链表系列;

public class _反转链表前N个节点 {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
		
		/**
		 * 思路：参考反转整个链表，多了一个后驱节
		 * 递归实现
		 * 与反转整个链表不同的是，head节点在递归完成之后不一定会指向null，所以要记录后驱节点head.next;
		 */
		public ListNode reverseN(ListNode head, int n) {
			if (head == null || head.next == null) {
				return head;
			}
			// 后驱节点 
			ListNode successor = null;
			if (n == 1) {
				successor = head.next;
				return head;
			}
			ListNode last = reverseN(head.next, n-1);
			head.next.next = head;
			head.next = successor;
			return last;
		}
	}
}
