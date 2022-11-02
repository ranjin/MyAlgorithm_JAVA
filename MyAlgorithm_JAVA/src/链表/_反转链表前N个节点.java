package 链表;

import 链表.LeeCode206_反转链表.ListNode;

public class _反转链表前N个节点 {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
		
		/**
		 * 递归实现
		 */
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
