
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}


/**
 * 用[遍历]的思维模式解决
 * 用一个traverse函数遍历每个节点，让每个节点的左右子节点颠倒过来。
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    // 二叉树遍历函数
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        // 遍历二叉树，交换每个节点的子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 遍历框架，去遍历左右子树的节点
        traverse(root.left);
        traverse(root.right);
    }

    // 递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 利用函数定义，先翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 然后交换左右子节点
        root.left = right;
        root.right = left;
        return root;
    }
}
