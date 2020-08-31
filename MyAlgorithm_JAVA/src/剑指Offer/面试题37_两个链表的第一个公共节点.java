package 剑指Offer;

public class 面试题37_两个链表的第一个公共节点 {

	
	public class ListNode{
		int val;
		ListNode next;
	} 
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode node1 = headA;
		ListNode node2 = headB;
		while (node1 != node2) {
			node1 = node1.next == null ? headB : node1.next;
			node2 = node2.next == null ? headA : node2.next;
		}
		return node1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
