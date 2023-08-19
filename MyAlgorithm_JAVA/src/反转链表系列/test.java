package 反转链表系列;

import java.util.Iterator;

public class test {

    public class ListNode {
        int val;
        ListNode next;
    }

    /// k个一组反转链表
    /**
     * 先反转以head开头的k个元素
     * 然后以k + 1个元素作为head递归调用
     * 将结果连接起来
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
    	if (head == null || head.next == null) {
			return head;
		}
    	
    	// 区间[a, b)包含k个待反转元素
    	ListNode a, b;
    	a = b = head;
    	
    	for (int i = 0; i < k; i++) {
			if (b == null) {
				// 不足k个，不需要反转
				return head;
			}
			b = b.next;
		}
    	
    	ListNode newHead = reverseT(a, b);
    	
    	a.next = reverseKGroup1(newHead, k);
    	return newHead;
    }
    
    public static ListNode reverseT(ListNode a, ListNode b) {
		ListNode pre = null, cur = a, nxt = cur;
		
		
		while (cur != b) {
			nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
		}
		return pre;
	}
    


}