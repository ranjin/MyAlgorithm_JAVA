package 链表;

import java.util.Iterator;

/**
 * 给定链表的头结点head，每k个节点一组进行反转，返回修改后的链表
 * 如果节点总数不是K的整数倍，将最后剩余的节点保持原有顺序
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 */
public class k个一组反转链表 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * 解题思路：
	 * 1. 先反转以head开头的k个元素
	 * 2. 将第 k+1 个元素作为head递归调用reverseKGroup(head, k)函数
	 * 3. 将上述两个过程的结果连接起来
	 * 4. base case：剩余元素不满足k个，保持不变
	 */
	
	// 反转以a为头结点的链表
	ListNode reverse(ListNode a) {
		ListNode pre = null;
		ListNode cur = a;
		ListNode next = a;
		while (cur != null) {
			next = cur.next;
			
			// 逐个反转节点
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	// 上述：反转以a为头结点的链表，即反转从a到null之间的节点[a, null)
	// 那么如果是需要反转从a到b之间的节点，则如下所示：反转[a, b)之间的节点
	ListNode reverse(ListNode a, ListNode b) {
		ListNode pre = null;
		ListNode cur = a;
		ListNode next = a;
		while (cur != b) {
			next = cur.next;
			
			// 逐个反转节点
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	// 轮到之后一步
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (head == null) {
			return head;
		}
    	// 区间[a, b)包含k个待反转元素
    	ListNode a = head;
    	ListNode b = head;
    	for (int i = 0; i < k; i++) {
    		// 不足k个，不需要反转：base case
			if (b == null) {
				return head;
			}
			b = b.next;
		}
    	
    	// 上面for循环之后，b为后面需要开始反转的第一个元素，即新的head。
    	// 反转前K个元素 newHead应该是b左边的。
    	ListNode newHead = reverse(a, b);
    	
    	//递归反转后续链表并连接起来
    	a.next = reverseKGroup(b, k);
    	return newHead;
    }
}




















