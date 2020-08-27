package 剑指Offer;

public class 面试题16_反转链表 {

	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int i) {
			val = i;
		}
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode pre = head;
		ListNode cur = new ListNode(0);
		while (pre != null) {
			ListNode t = pre.next;
			pre.next = cur;
			cur = pre;
			pre = t;
		}
		return cur;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
