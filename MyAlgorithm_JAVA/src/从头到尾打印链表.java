import java.util.ArrayList;
import java.util.Stack;

public class 从头到尾打印链表 {

	public class ListNode{
		int val;
		ListNode next = null;
		ListNode(int val){
			this.val = val;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 考虑用栈这种数据结构: 先进后出
	 */
    public int[] reversePrint(ListNode head) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<ListNode> nodes = new Stack<ListNode>();
		ListNode pHead = head;
		while (pHead != null) {
			nodes.push(pHead);
			pHead = pHead.next;
		}
		int size = nodes.size();
		int[] arr = new int[size];
		while (!nodes.empty()) {
			for (int i = 0; i < size; i++) {
				arr[i] = nodes.pop().val;
			}
		}
		return arr;
	}
}












