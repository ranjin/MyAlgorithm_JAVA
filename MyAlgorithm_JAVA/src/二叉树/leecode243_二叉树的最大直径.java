/**
 *     1
      / \
     2   3
    / \     
   4   5    

   返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

/**
 * 思路：
 * 需要遍历二叉树。使用后序遍历
 * 最大直径，即节点的左右子树的最大路径深度之和 + 1
 */
public class Solution{
    // 记录最大直径的长度
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // 后序位置, 顺便计算最大直径
        int mydiameter = left + right;
        maxDiameter = Math.max(maxDiameter, mydiameter);
        return 1 + Math.max(left, right);
    }
}