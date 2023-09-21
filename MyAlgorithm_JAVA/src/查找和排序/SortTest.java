package 查找和排序;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 链表.LeeCode_19_删除链表的倒数第K个节点.ListNode;

public class SortTest {

	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	// 删除链表的倒数第N个元素
	public ListNode removeNthFromEnd(ListNode head, int n) {
	
		// 虚拟头节点
		ListNode dummy = new ListNode(-1);
		
		dummy.next = head;
	}
	public static void main(String[] args) {
    	int[] nums = new int[] {5, 12, 3, 4, 19, 1, 28, 24};
//    	quickSort(nums, 0, nums.length);
    	for (int i : nums) {
            System.out.println(i);
		}
	}
}
