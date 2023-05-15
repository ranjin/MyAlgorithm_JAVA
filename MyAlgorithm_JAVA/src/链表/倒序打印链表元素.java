package 链表;
public class 倒序打印链表元素 {
	
	public class TreeNode {
	    int val;
	    TreeNode next;
	}
	
    public void traverse(TreeNode head) {
        if (head == null) {
            return;
        }
        
        // 前序位置
        traverse(head.next);

        // 后序位置
        System.out.print(head.val);
    }
}