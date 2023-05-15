package 反转链表系列;

public class test {

    public class ListNode {
        int val;
        ListNode next;
    }

    // 反转链表的一部分
    public ListNode reverseBetween(ListNode head, int left, int right) {

        return head;
    }

    // 反转链表前N个节点
    ListNode successor = null;
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}