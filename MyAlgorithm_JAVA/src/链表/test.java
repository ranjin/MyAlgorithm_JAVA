

/**
 * 1    ->      5       ->   10
 * 2    ->      3       ->    8
 */
public class test {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = list1, p2 = list2;
        while(p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {

            }

            // p指针不断前进
            p = p.next;
        }
        if (p1 == null) {
            p.next = p2;
        }
        if (p2 == null) {
            p.next = p1;
        }
        return dummy.next;


    }









    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode node = findNode(ListNode head,n + 1);
        // 删除链表倒数第n个节点，需要找到倒数第n+1个节点
        node.next = node.next.next;
        return head;
    }

    // 查找倒数第i个节点
    public ListNode findNode(ListNode head, int i) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++){
            p1 = p1.next;
        }

        ListNode p2 = head;

        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}