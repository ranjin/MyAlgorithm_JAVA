package 链表;

public class Test_01 {
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	
	/**
	 * l1
	 * 1	-> 		3	-> 4
	 * 
	 * l2
	 * 2	->		3	-> 6
	 */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	// 虚拟头节点
    	ListNode l = new ListNode(-1);
    	ListNode result = l;
    	ListNode l1 = list1;
    	ListNode l2 = list2;
    	
    	while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				l.next = l2;
				l2 = l2.next;
			} else {
				l.next = l1;
				l1 = l1.next;
			}
		}
    	if (l1 == null) {
			l.next = l2;
		}
    	
    	if (l2 == null) {
			l.next = l1;
		}
    	return result.next;
    }
	
	public static void main(String[] args) {
	}

}
