package 链表;


/**
 * 输入：l1 = [1、2、4]，l2 = [1、3、4]
 * 输出：[1、1、2、3、4、4]
 */
public class 合并两个排序的链表 {

	public class ListNode{
		int val;
		ListNode next;
		ListNode(){};
		ListNode(int val){
			this.val = val;
		}
		ListNode(int val, ListNode next){
			this.val = val;
			this.next = next;
		}
	}
	/*
	 * 双指针解法
	 */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	if (list1 == null) {
			return list2;
		}
    	if (list2 == null) {
			return list1;
		}
    	// 虚拟头节点
    	ListNode dummy = new ListNode(-1);
    	ListNode p = dummy;
    	ListNode p1 = list1, p2 = list2;
    	while (p1 != null && p2 != null) {
        	if (p1.val < p2.val) {
    			p.next = p1;
    			p1 = p1.next;
    		} else {
    			p.next = p2;
    			p2 = p2.next;
    		}
        	// p指针不断前进
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
}
