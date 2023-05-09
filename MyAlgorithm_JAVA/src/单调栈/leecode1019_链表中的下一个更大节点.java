package 单调栈;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入：head = [2,1,5]
 * 输出：[5,5,0]
 * 
 * 单调栈技巧
 * 先将单链表转成数组
 *
 */
public class leecode1019_链表中的下一个更大节点 {

	public class ListNode {
		int val;
		ListNode next;
	}
	
    public int[] nextLargerNodes(ListNode head) {
    	Stack<Integer> s = new Stack<>();
    	ArrayList<Integer> nums = new ArrayList<>();
    	for (ListNode p = head; p != null; p = p.next) {
			nums.add(p.val);
		}
    	int n = nums.size();
    	// 结果集
    	int[] res = new int[n];
    	
    	for (int i = n - 1; i >= 0; i--) {
			while (!s.isEmpty() && nums.get(i) >= s.peek()) {
				s.pop();
			}
			res[i] = s.isEmpty() ? 0 : s.peek();
			s.push(nums.get(i));
		}
    	return res;
    }
}
