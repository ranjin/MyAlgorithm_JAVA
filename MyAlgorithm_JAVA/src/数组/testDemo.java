package 数组;

public class testDemo {
	
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}

	// 删除链表重复元素
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}

    	ListNode slow = head, fast = head;
    	while (fast != null) {
			if (slow.val != fast.val) {
				 slow.next = fast;
				 slow = slow.next;
			}
			fast = fast.next;
		}
    	// 断开连接
    	slow.next = null;
    	return head;
    }
}
