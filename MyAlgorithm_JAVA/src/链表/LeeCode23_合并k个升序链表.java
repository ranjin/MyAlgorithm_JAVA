package 链表;

/**
 * 输入:lists = [[1、4、5],[1、3、4],[2、6]]
 * 输出：[1、1、2、3、4、4、5、6]
 * 链表: 
 * 1->4->5
 * 1->3->4
 * 2->6
 * 1->1->2->3->4->4->5->6 
 * 
 */
public class LeeCode23_合并k个升序链表 {
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
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		
		return null;
	}
	
}
