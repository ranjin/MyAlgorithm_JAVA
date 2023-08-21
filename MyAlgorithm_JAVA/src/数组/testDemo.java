package 数组;

public class testDemo {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
	}

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	ListNode p1 = headA;
    	ListNode p2 = headB;
    	
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
    
    /// 反转节点a与b之间的元素
    public static ListNode reverseN(ListNode a, ListNode b) {
		ListNode pre = null, cur = a, nxt = cur;
		
		while (cur != b) {
			nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
		}
		return pre;
	}
}
