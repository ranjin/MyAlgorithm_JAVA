package 剑指Offer;

public class 面试题37_两个链表的第一个公共节点 {

	public class ListNode{
		int val;
		ListNode next;
	}
	
	public ListNode getIntersectioNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode aNode = headA;
		ListNode bNode = headB;
		
		if (aNode != bNode) {
			aNode = aNode.next == null ? headB : aNode.next;
			bNode = bNode.next == null ? headA : aNode.next;
		}
		return aNode;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
