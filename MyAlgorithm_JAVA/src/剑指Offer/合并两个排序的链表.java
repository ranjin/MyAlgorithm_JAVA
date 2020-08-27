package 剑指Offer;

public class 合并两个排序的链表 {

	public class ListNode{
		int val;
		ListNode next;
	}
	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
