package 链表;

import java.util.PriorityQueue;

/**
 * 输入:lists = [[1、4、5],[1、3、4],[2、6]]
 * 输出：[1、1、2、3、4、4、5、6]
 * 链表: 
 * 1->4->5
 * 1->3->4
 * 2->6
 * 1->1->2->3->4->4->5->6 
 * 
 * 思路：
 * 将
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
		if (lists.length == 0) {
			return null;
		}
		// 虚拟头节点
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		
		// 优先级队列
		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
		
		// 将k个链表的头节点加入最小堆
		for (ListNode head : lists) {
			if (head != null) {
				pq.add(head);
			}
		}
		
		while (!pq.isEmpty()) {
			// 获取最小节点，接到结果链中
			ListNode node = pq.poll();
			p.next = node;
			if (node.next != null) {
				pq.add(node.next);
			}
			p = p.next;
		}
		return dummy.next;
	}
	
}
