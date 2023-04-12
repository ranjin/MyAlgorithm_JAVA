
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

    // 迭代
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        // pre  cur  nxt 
        //  pre cur    nxt
        //      1  ->   2    ->   3    ->  4     ->   5
        ListNode pre = null, cur = head, nxt = head;

        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


}