
/**
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
class Solution {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 在两条链表上的指针
        ListNode p1 = l1, p2 = l2;

        // 虚拟头节点技巧创建空链表
        ListNode dummy = new ListNode(-1);

        // 指针p负责构建新链表
        ListNode p = dummy;

        // 记录进位
        int carry = 0;

        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (p1 != null || p2 != null || carry > 0) {
            // 先加上上次的进位
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
            val = val % 10; // 取余
            
            // 构建新节点
            p.next = new ListNode(val);
            p = p.next;
        }
        // 返回结果链表的头节点
        return dummy.next;
    }
}