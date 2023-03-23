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
	/** 
	 * 思路：
	 * 1. 先通过双指针技巧找到链表中点
	 * 2. 从slow开始反转后面的链表
	 * 3. 比较
	 */
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 链表长度为奇数
		if (fast != null) {
			slow = slow.next;
		}
		
		ListNode left = head;
		ListNode right = reverse(slow);
		
		while (right != null) {
			if (left.val != right.val) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		return true;
	}	
	
	// 反转整个链表
	public ListNode reverse(ListNode head) {
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
	
}
