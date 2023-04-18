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
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		// 虚拟头节点
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		
		// 创建最小堆优先级队列, 最小堆
		// 将k个链表的头节点加入最小堆
		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
		
		// 将k个链表的头节点加入到最小堆
		for(ListNode head: lists) {
			if (head != null) {
				pq.add(head);
			}
		}

		while(!pq.isEmpty()) {
			// 获取最小元素, 接入到p.next
			ListNode node = pq.poll(); // 获取并删除队首元素
			p.next = node;
			if (node.next != null) {
				pq.add(node.next);
			}
			// p指针不断往前进
			p = p.next;
		}
		return dummy.next;
	}
}
