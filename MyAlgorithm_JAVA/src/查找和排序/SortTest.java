package 查找和排序;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 链表.LeeCode21_合并两个有序的链表.ListNode;


public class SortTest {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * 合并两个有序链表
	 * 1 -> 2 -> 3
	 * 2 -> 3 -> 4
	 */
	
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	if (list1 == null) {
			return list2;
		}
    	
    	if (list2 == null) {
			return list1;
		}
    	
    	ListNode dummy = new ListNode(-1);
    	
    	ListNode p = dummy;
    	ListNode p1 = list1, p2 = list2;
    	
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
    	if (p1 == null) {
			p.next = p2;
		} 
    	
    	if (p2 == null) {
			p.next = p1;
		}
    	
    	
    	return dummy.next;
    	
    }


}