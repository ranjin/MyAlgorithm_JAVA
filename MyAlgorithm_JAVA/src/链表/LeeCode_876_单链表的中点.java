package 链表;

/**
 * 返回链表的中间节点,如果有两个，则返回两个节点
 * 思路：快慢指针
 *
 * [1、2、3、4、5]
 */
public class LeeCode_876_单链表的中点 {
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
	
	public ListNode middleNode(ListNode head){
		if (head == null) {
			return head;
		}
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
