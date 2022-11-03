package 链表;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 
 * 输出：[5,4,3,2,1]
 *
 */
public class LeeCode206_反转链表 {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
		
		/**
		 * 迭代:指针右移
		 * 反转以head为头节点的链表
		 */
		public ListNode reverseList_normal(ListNode head) {
			if (head == null) {
				return head;
			}
			ListNode pre = null, cur = head, nxt = cur;
			while (cur != null) {
				nxt = cur.next;
				cur.next = pre;
				pre = cur;
				cur = nxt;
			}
			return pre;
		}
		
	    /**
	     * 迭代实现反转整个链表
	     */
		public ListNode reverse(ListNode head) {
			// base case, 如果链表只有一个节点的时候，反转也是它自己，直接返回即可。
			if (head.next == null) {
				return head;
			}
			// 当链表递归反转之后，新的头节点是last，而之前的head变成了最后一个节点，别忘了链表的末尾要指向null
			ListNode last = reverse(head.next);
			head.next.next = head;
			head.next = null;
			return last;
		}
	}
}
