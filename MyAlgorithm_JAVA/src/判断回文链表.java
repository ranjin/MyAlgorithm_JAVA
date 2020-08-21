
public class 判断回文链表 {

	public class ListNode{
		int val;
		ListNode next;
	}
	boolean isPalindrome(ListNode head){
		ListNode slow, fast;
		slow = fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		ListNode left = head;
		ListNode right = reverse(slow);
		
		//从两端开始
		while (right != null) {
			if (left.val != right.val) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		return true;
	}
	
	ListNode reverse(ListNode head) {
		ListNode pre = null, cur = head;
		while (cur != null) {
			ListNode t = cur.next;
			pre = cur;
			cur = t;
		}
		return pre;
	}
	public static void main(String[] args) {
		

	}

}
