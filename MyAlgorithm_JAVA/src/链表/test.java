package 链表;



public class test {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}

	

	/**
	 * 删除排序链表中的重复元素
	 *    slow fast)
	 * 	   1 -> 2 -> 2 -> 3 -> 4
	 */
    public ListNode deleteDuplicates(ListNode head) {
    	
    	if (head == null || head.next == null) {
			return head;
		}
    	
    	ListNode slow = head;
    	ListNode fast = head.next;
    	
    	while (fast != null) {
    		if (slow == fast) {
				fast = fast.next;
			} else {
				slow = fast;
				fast = fast.next;
			}
		}
    	slow.next = null;
    	
    	return head;
    }
}