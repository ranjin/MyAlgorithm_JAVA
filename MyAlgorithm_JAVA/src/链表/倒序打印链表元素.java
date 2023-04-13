public class TreeNode {
    int val;
    TreeNode next;
}

public class Solution {
    public void traverse(TreeNode head) {
        if (head == null) {
            return;
        }
        
        // 前序位置
        traverse(head.next);

        // 后序位置
        println(head.val);
    }
}