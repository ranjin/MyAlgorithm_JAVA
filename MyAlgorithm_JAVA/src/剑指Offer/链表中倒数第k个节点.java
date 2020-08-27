package 剑指Offer;

public class 链表中倒数第k个节点 {

	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode FindKthToTail(ListNode head, int k) {
		/*
		 * 鲁棒性:
		 * 1. head为空指针
		 * 2. 以head为头节点的链表的节点数少于k
		 * 3. k为0
		 */
		if (head == null || k == 0) {
			return null;
		}
		ListNode slowNode = head;
		ListNode fastNode = head;
		while (k > 0) {
			fastNode = fastNode.next;
			k--;
		}
		while (fastNode != null) {
			fastNode = fastNode.next;
			slowNode = slowNode.next;
		}
		return slowNode;
	}
	/*
	 * 快慢指针
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
