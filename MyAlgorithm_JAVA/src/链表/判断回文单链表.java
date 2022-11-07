package 链表;

/**
 * 输入一个单链表的头节点，判断这个链表中的数字是不是回文
 *
 * 输入: 1->2->null
 * 输出: false
 * 
 * 输入: 1->2->2->1->null
 * 输出: true
 */
public class 判断回文单链表 {

	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		
		ListNode
		/**
		 * a: 1、1、2、1
		 * b: 1、2、1、1
		 */
		ListNode tmpNode = head;
		ListNode newHead = reverse(tmpNode);
		ListNode aNode = head, bNode = newHead;
		while (aNode != null && bNode != null) {
			if (aNode.val == bNode.val) {
				aNode = aNode.next;
				bNode = newHead.next;
			} else {
				return false;
			}
		}
		return true;
	}
	
	// 先反转单链表
	public ListNode reverse(ListNode head) {
		if (head.next == null) {
			return head;
		}
		ListNode last = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}
	

	
	
}
