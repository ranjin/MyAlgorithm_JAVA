package 链表;
public class LeeCode206_反转链表 {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	/**
	 * 递归实现反转整个链表
	 */
    public ListNode reverseList(ListNode head) {
    	ListNode pre = null;
    	ListNode cur = head;
    	ListNode next = head;
    	while (cur != null) {
			next = cur.next;
			
			// 逐个反转结点
			cur.next = pre;
			pre = cur;
			cur = next;
		}
    	return pre;
    }

    
    /**
     * 迭代实现反转整个链表
     */
	public ListNode reverse(ListNode head) {
		// base case, 如果链表只有一个节点的时候，反转也是它自己，直接返回即可。
		if (head.next == null) {
			return head;
		}
		// 当链表递归反转之后，新的头节点是last，而之前的head变成了最后一个节点，别忘了链表的末尾要指向null
		ListNode last = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}
}
