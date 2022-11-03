package 链表;

public class LeeCode_92_反转链表的一部分 {

	/**
	 * 给一个索引区间[m, n](索引从1开始)，仅仅反转区间中的链表元素
	 * 
	 */
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
		ListNode reverseBetween(ListNode head, int m, int n) {
			/**
			 * base case：如果m = 1， 则相当于反转链表开头的n个元素
			 */
			if (m == 1) {
				ListNode newHead = reverseN(head, n);
				return newHead;
			}
			// 前进到反转的起点触发base case
			head.next = reverseBetween(head.next, m - 1, n - 1);
			return head;
		}
		
		public ListNode reverseN(ListNode head, int n) {
			ListNode successor = null;
			// base case: 反转一个元素，就是它本身，同时要记录后驱节点。
			if (n == 1) {
				// 记录第n+1个节点
				successor = head.next;
				return head;
			}
			ListNode newHead = reverseN(head.next, n - 1);
			head.next.next = head;
			
			// 记录successor(第n+1个节点)，反转之后将head连接上。
			head.next =  successor;
			return newHead;
		}
	}
}
