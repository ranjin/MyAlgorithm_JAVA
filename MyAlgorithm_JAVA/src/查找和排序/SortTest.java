package 查找和排序;

import 反转链表系列.LeeCode206_反转链表.ListNode;

public class SortTest {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
	}
	//		 pre  cur   nxt
	//             1 -	 2 -  3 -	4 - 5
    //
	public ListNode reverseList_normal(ListNode head) {
		
		ListNode pre = null, cur = head, nxt = head;
		
		while (cur != null) {
			nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
			
		}
		return pre;
	}
	public static void main(String[] args) {
    	int[] nums = new int[] {5, 12, 3, 4, 19, 1, 28, 24};
//    	quickSort(nums, 0, nums.length);
    	for (int i : nums) {
            System.out.println(i);
		}
	}
}
