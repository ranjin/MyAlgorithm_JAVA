package 剑指Offer;

public class 在O1时间内删除链表节点 {
	
	public class ListNode{
		int val;
		ListNode next;
	}
	public ListNode DeleteNode(ListNode head, ListNode deleteNode) {
		if (deleteNode.next != null) {
			//要删除的节点不是尾节点
			ListNode nextNode = deleteNode.next;
			deleteNode.val = nextNode.val;
			deleteNode.next = nextNode.next;
		}else {
			if (head.next == null) {
				//要删除的节点是唯一的一个节点
				return null;
			}else {
				/*
				 * 要删除的节点位于最后一个: 
				 * 顺序遍历得到该结点的前序节点，并完成删除操作 
				 */
				ListNode cur = head;
				while (cur.next != deleteNode) {
					cur = cur.next;
				}
				cur.next = null;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}















