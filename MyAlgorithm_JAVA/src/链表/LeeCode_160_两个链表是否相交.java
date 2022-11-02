package 链表;

/**
 * 给定两个链表的头节点，这两个链表可能存在相交
 * 如果相交，返回相交的那个节点，如果没相交，返回null
 * 思路：
 * 让p1遍历完链表A之后开始遍历链表B。让p2遍历完链表A之后开始遍历链表A.
 * 将两条链表接在一起
 */
public class LeeCode_160_两个链表是否相交 {
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
	
	ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p1 = headA;
		ListNode p2 = headA;
		while (p1 != p2) {
			if (p1 == null) {
				p1 = headB;
			} else {
				p1 = p1.next;
			}
			
			if (p2 == null) {
				p2 = headA;
			} else {
				p2 = p2.next;
			}
		}
		return p1;
	}
}
