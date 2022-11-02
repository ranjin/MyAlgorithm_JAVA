package 链表;

import 链表.面试题16_反转链表.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 
 * 输出：[5,4,3,2,1]
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
		 * 普通思路
		 * 反转以a为头节点的
		 */
		public ListNode reverseList_normal(ListNode head) {
			
			
			ListNode pre = head;
			ListNode cur = new ListNode(0);
			while (pre != null) {
				ListNode t = pre.next;
				pre.next = cur;
				cur = pre;
				pre = t;
			}
			return cur;
		}
		
		/**
		 * 递归思路
		 * 函数含义：输入一个节点head，将以head为头节点的链表反转。并返回反转之后的头节点
		 * 
		 */
		public ListNode reverseList(ListNode head) {
			if (head.next == null) {
				return head;
			}
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
