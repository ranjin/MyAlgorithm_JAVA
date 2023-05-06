package 链表;

import java.util.Stack;

public class test {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
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