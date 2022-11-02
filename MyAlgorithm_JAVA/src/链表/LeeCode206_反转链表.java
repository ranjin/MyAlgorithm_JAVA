package 链表;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @author ranjin
 *
 */
public class LeeCode206_反转链表 {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
		
		/**
		 * 递归思路
		 * 
		 */
		public ListNode reverseList(ListNode head) {
			ListNode newHead = reverseList(head.next);
			// 重点： 以【5、4、3、2、1】举例，那么就是4的next要指向5。而4是5的next。即：
			head.next.next = head;
			head.next = null;
			return newHead;
		}
		
		/**
		 * 迭代思路
		 */
		public ListNode reverseList2(ListNode head) {
			// 临时node，以防最开始的next指针断掉
			ListNode newHead = null;
			while(head != null) {
				ListNode tmp = head.next;
				head.next = newHead;	// head的next指向newHead
				newHead = head;	// newHead指向head
				head = tmp;
			}
			return newHead;

		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
