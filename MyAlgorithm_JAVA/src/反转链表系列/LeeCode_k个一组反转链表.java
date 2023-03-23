package 反转链表系列;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * 
 * 思路：
 * 采用递归的思想
 * 1. 先反转以head开头的k个元素
 * 2. 将K+1个元素作为head递归调用reverseKGroup函数
 * 3. 将上述两个过程的结果连接起来
 * base case：
 * 如果最后的元素不足k个，就保持不变
 *
 */
public class LeeCode_k个一组反转链表 {
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
		
	    public ListNode reverseKGroup(ListNode head, int k) {
	    	if (head == null) {
				return null;
			}
	    	ListNode a, b;
	    	a = b = head;
	    	// 区间[a, b)包含k个待反转元素
	    	for (int i = 0; i < k; i++) {
				if (b == null) {
					return head;
				}
				b = b.next;
			}
	    	// 反转前k个元素
	    	ListNode newHead = reverse(a, b);
	    	a.next = reverseKGroup(b, k);
	    	return newHead;
	    }
	}
	
//	// 反转以a为头节点的链表,即反转以a为头节点，以null为尾节点的
//	public ListNode reverse(ListNode a) {
//		if (a == null) {
//			return a;
//		}
//		ListNode pre = null, cur = a, nxt = a;
//		while (cur != null) {
//			nxt = cur.next;
//			cur.next = pre;
//			pre = cur;
//			cur = nxt;
//		}
//		return pre;
//	}
	// 反转a到b之间的节点
	public ListNode reverse(ListNode a, ListNode b) {
		if (a == null) {
			return a;
		}
		ListNode pre = null, cur = a, nxt = a;
		while (cur != b) {
			nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
		}
		return pre;
	}
	
//	// 递归思路
//	public ListNode reverse(ListNode a) {
//		// base case: 链表只有一个节点的时候
//		if (a.next == null) {
//			return a;
//		}
//		ListNode newHead = reverse(a.next);
//		a.next.next = a;
//		a.next = null;
//		
//		return newHead;
//	}
	
}
