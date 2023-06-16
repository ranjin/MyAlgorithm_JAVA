package 链表;

/**
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * 
 * 思路：
 * 需要做的是删除链表中的节点
 * 指定cur指针指向头部head
 * 
 * 当cur.val == cur.next.val说明需要去重。
 * 如何去重 ? cur.next = cur.next.next
 * 
 */


public class leecode_83_删除排序链表中的重复元素 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
	}
    public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
    	ListNode cur = head;
    	while (cur != null && cur.next != null) {
    		if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
    	return head;
    }

	// 解法2: 快慢指针	
    //        slow
    // 		                 fast
    // 1	->	2	->	2	->	3	->	3	->	4
	public ListNode deleteDuplicates2(ListNode head) {
		
		
		if (head == null) {
            return head;
        }
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null) {
			if (slow.val != fast.val) {
				slow.next = fast;
				slow = slow.next;
			}
			fast = fast.next;
		}
		//断开与后面重复元素的连接
		slow.next = null;
		return head;
	}
}
