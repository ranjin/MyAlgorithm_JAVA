package 链表;

/**
 * 
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 */

/**
 * 总结：
 * 采用虚拟头结点：降低代码复杂性，避免处理空指针的情况。
 * 虚拟头结点 + 两个链表的两个指针。拉锯式处理。临界条件为都不为空的时候。
 * 最后判断某一个不为空，则直接添加到链表最后面。
 *
 */

public class LeeCode21_合并两个有序的链表 {
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
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		ListNode p1 = list1;
		ListNode p2 = list2;
		while (p1 != null && p2 != null) {
			if (p1.val > p2.val) {
				p.next = p2;
				p2 = p2.next;
			} else {
				p.next = p1;
				p1 = p1.next;
			}
			p = p.next;
		}
		if (p1 != null) {
			p.next = p1;
		}
		if (p2 != null) {
			p.next = p2;
		}
		return dummy.next;
	}
}
