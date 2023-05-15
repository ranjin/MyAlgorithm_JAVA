package 链表;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 */
public class leecode86_分隔链表 {

	public class ListNode {
		public ListNode(int val) {
			this.val = val;
		}
		int val;
		ListNode next;
	}
	/**
	 * 思路：遍历整个链表，每遍历到一个点，将next指针断开，重新链接，
	 * 创建两个虚拟头节点，分别链接 > x 与 <= x的节点
	 */
    public ListNode partition(ListNode head, int x) {

    	
    	// 虚拟头节点
    	
    	// < x: dummy1.next	p1
    	// > x: dummy2.next	p2
    	ListNode dummy1 = new ListNode(-1); // 存放 < x的节点链表
    	ListNode dummy2 = new ListNode(-1); // 存放 >= x的节点链表

    	ListNode p1 = dummy1;
    	ListNode p2 = dummy2;

    	ListNode p = head;

    	while (p != null) {
			if(p.val < x) {
				p1.next = p;
				p1 = p1.next;
			} else {
				p2.next = p;
				p2 = p2.next;
			}
    		
    		ListNode temp = p.next;
    		p.next = null;
    		p = temp;
		}

    	// 连接两个链表
    	p1.next = dummy2.next;
    	return dummy1.next;
    	
    }
}
