package 剑指Offer;

import 剑指Offer.LeeCode_合并两个排序的链表.ListNode;

public class 合并两个排序的链表 {

	public class ListNode{
		int val;
		ListNode next;
	}
	
	/*
	 * 递归解法
	 */
	public ListNode Merge(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null) {
			return pHead2;
		}else if (pHead2 == null) {
			return pHead1;
		}
		ListNode mergedHead = null;
		if (pHead1.val < pHead2.val) {
			mergedHead = pHead1;
			mergedHead.next = Merge(pHead1.next, pHead2);
		}else {
			mergedHead = pHead2;
			mergedHead.next = Merge(pHead1, pHead2.next);
		}
		return mergedHead;
	}
	
	/*
	 * 双指针解法
	 */
//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		if (l1 == null) {
//			return l2;
//		}
//		if (l2 == null) {
//			return l1;
//		}
//		
//		//初始化一个伪头节点 dum，节点cur指向dum
//		ListNode dum = new ListNode(0);
//		ListNode cur = dum;
//
//		while (l1 != null && l2 != null) {
//			if (l1.val < l2.val) {
//				cur.next = l1;
//				l1 = l1.next;
//			}else {
//				cur.next = l2;
//				l2 = l2.next;
//			}
//			cur = cur.next;
//		}
//		cur.next = l1 != null ? l1 : l2;
//		return dum.next;
//	}
	
	
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null) {
			return l2;
		}
    	if (l2 == null) {
			return l1;
		}
    	ListNode dum = new ListNode();
    	ListNode cur = dum;
    	while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			}else {
				cur.next = l2;
				l2 = l2.next;
			}
			
			cur = cur.next;
		}
    	cur.next = l1 != null ? l1 : l2;
    	return dum.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
