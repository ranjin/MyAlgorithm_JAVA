package 链表;

/**
 * 环型链表的起点
 * 假设相遇时slow走了k步，fast走了2k步。
 * 假设相遇点距离环起点为m，则当相遇时，将slow重新指向head，然后与fast一起同时向前。
 * 那么当再次相遇时即为起点的位置
 *
 */
public class LeeCode142_环形链表2 {

	public class ListNode {
		int val;
		ListNode next;
	}
	
	public ListNode detectCycle(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			// 说明有环
			if (fast == slow) {
				break;
			}
		}
		// 说明没有环
		if (fast == null || fast.next == null) {
			return null;
		}
				
		// slow重新指向head
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
