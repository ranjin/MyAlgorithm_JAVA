package 反转链表系列;

/**
 * 总结：
 * 反转链表base case为head=null，反转链表的前N个节点：base case为n == 1，需要一个后驱节点。
 * 反转链表的一部分：base case为m == 1时，反转前n个节点
 *
 */
public class LeeCode_92_反转链表的一部分 {

	/**
	 * 给一个索引区间[m, n](索引从1开始)，仅仅反转区间中的链表元素
	 * 
	 */
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
		
    public ListNode reverseBetween(ListNode head, int left, int right) {
    	// base case
    	if (left == 1) {
			// 反转链表前N个元素
    		ListNode newHead = reverseN(head, right);
    		return newHead;
		}
    	head.next = reverseBetween(head.next, left - 1, right - 1);
    	return head;
    }
    
    // 反转链表前N个元素
    ListNode successor = null;	// 后驱节点
    public ListNode reverseN(ListNode head, int n) {
    	// base case: 只有一个元素
    	if (n == 1) {
			successor = head.next;
			return head;
		}
    	ListNode last = reverseN(head.next, n - 1);
    	head.next.next = head;
    	head.next = successor;
    	return last;
    }
}
