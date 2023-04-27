/**
 * leecode2的进阶，此时会想到需要先反转链表
 * 
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 */

public class ListNode {
    int val;
    ListNode next;
}

class Solution {
    // 解法1: 采用反转链表的方式
    public ListNode addTwoNumbers_01(ListNode l1, ListNode l2) {
        ListNode list1 = reverse(l1);

        ListNode list2 = reverse(l2);

        // 虚拟头节点
        ListNode dummy = new ListNode(-1);

        // 新链表
        ListNode p = dummy;


        ListNode p1 = list1, p2 = list2;

        int carry = 0;
        // 3,4,2,7
        // 4,6,4
        while (p1 != null || p2 != null || carry > 0) {
            // 两条链表没走完，或者需要进位时
            // 加上上次的进位
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }

            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            ListNode node = new ListNode(val);
            p.next = node;
            p = p.next;
        }
        return reverse(dummy.next);
    }

    // 反转链表
    public ListNode reverse(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode pre = null, cur = head, nxt = head;
        while (cur != null) {
            nxt = cur.nxt;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    // 解法2: 利用栈：先进后出
    public ListNode addTwoNumbers_02(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        // 记录进位
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int val = carry;
            if (!stack1.isEmpty()) {
                val += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                val += stack2.pop();
            }

            // 计算进位
            carry = val / 10;
            val = val % 10;

            ListNode newNode = new ListNode(val);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        return dummy.next;
    }
}