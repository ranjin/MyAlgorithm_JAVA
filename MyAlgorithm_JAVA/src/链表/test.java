package 链表;

import java.util.PriorityQueue;
import java.util.Stack;

public class test {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode dummy1 = new ListNode(-1);
		ListNode p1 = dummy1;
		ListNode dummy2 = new ListNode(-1);
		ListNode p2 = dummy2;

		ListNode w1 = headA, w2 = headB;
		while (w1 != null || w2 != null) {
			if (w1.next != null) {
				p1.next = w1;
				w1 = w1.next;
			} else {
				p1.next = w2;
				w2 = w2.next;
			}
			p1 = p1.next;
		}
		
		while (w1 != null || w2 != null) {
			if (w2.next != null) {
				p2.next = w2;
				w2 = w2.next;
			} else {
				p1.next = w2;
				w2 = w2.next;
			}
			p1 = p1.next;
		}
		ListNode p1 = headA, p2 = headB;
		while (p1 != null) {
			p1 = p1.next;
		}
		p1.next = headB;
		
//		while (p1 != null) {
//			p1 = p1.next;
//		}
//		p1.next = headB;
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(-1);
    	ListNode p = dummy;
    	int no = 0;	// 记录进位
    	ListNode p1 = l1;
    	ListNode p2 = l2;
    	while (p1 != null || p2 != null || no > 0) {
    		int val = 0;
			if (p1 != null) {
				val += p1.val;
				p1 = p1.next;
			}
			if (p2 != null) {
				val += p2.val;
				p2 = p2.next;
			}
			val = val % 10;
			no += (val / 10);
			ListNode node = new ListNode(val);
			p.next = node;
		}
    	return dummy.next;
    }
    public ListNode detectCycle(ListNode head) {
     
    	ListNode slow = head, fast = head;
    	
    	while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
    	// 重新回到起点
    	slow = head;
    	while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
    	return slow;
    }
	//              p2        p1
	// head -> 1 -> 2 -> 3 -> 4 -> 5
	// n = 2
	// 删除倒数第n个节点，需要知道倒数第n+1个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	
    	ListNode dummy = new ListNode(-1);
    	ListNode p = dummy.next;
    	
    	ListNode node = findKthNode(p, n + 1);
    	node.next = node.next.next;
    	return dummy.next;
    }
    
    // 查找链表的倒数第k个节点
    public ListNode findKthNode(ListNode head, int k) {
    	if (head == null) {
    		return head;
    	}
    	ListNode p1 = head;
    	for (int i = 0; i < k; i++) {
			p1 = p1.next;
		}
    	
    	ListNode p2 = head;
    	while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
    	return p2;
    }
	ListNode mergeKLists(ListNode[] lists) {
		// 小顶堆
		PriorityQueue<ListNode> queue = new PriorityQueue<>();
		
		for (ListNode head : lists) {
			queue.offer(head);
		}
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			p.next = node;
			
			queue.offer(node.next);
		}
		return dummy.next;
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	// 创建新链表：虚拟头节点技巧
    	ListNode dummy = new ListNode(-1);
    	// 使用栈: 新进后出
    	Stack<Integer> stk1 = new Stack<>();
    	Stack<Integer> stk2 = new Stack<>();
    	
    	while (l1 != null) {
			stk1.push(l1.val);
			l1 = l1.next;
		}
    	
    	while (l2 != null) {
			stk2.push(l2.val);
			l2 = l2.next;
		}
    	// 记录进位
    	int carry = 0;
    	
    	while (!stk1.isEmpty() || !stk2.isEmpty() || carry > 0) {
			int val = carry;
			
			if (!stk1.isEmpty()) {
				val += stk1.pop();
			}
			
			if (!stk2.isEmpty()) {
				val += stk2.pop();
			}
			
			// 计算进位
			carry = val / 10;
			val = val % 10;
			ListNode newNode = new ListNode(val);
			
			// Node - newNode - dummy
			newNode.next = dummy.next;
			dummy.next = newNode;
			
		}
    	return dummy.next;
    }

}