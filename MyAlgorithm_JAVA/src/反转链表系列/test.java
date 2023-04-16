
public class Solution {
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
    // 反转链表区间：以head为头节点，区间[left, right]之间元素
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // base case: left为1， 反转链表的前right个元素
        if (left == 1) {
            ListNode newHead = reverseK(head, right);
            return newHead;
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // 反转链表的前N个元素
    public ListNode reverseK(ListNode head, int n) {
        // 后驱节点
        ListNode successor = null;
        // 与反转整个链表类似
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseK(head.next,  n -1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}