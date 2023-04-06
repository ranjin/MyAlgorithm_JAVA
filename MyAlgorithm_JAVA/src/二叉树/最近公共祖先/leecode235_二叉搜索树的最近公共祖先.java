/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 思路：
 * 二叉搜索树的性质：left.val < root.val < right.val
 * 假设val1 < val2
 * 如果val1 < root.val < val2,那么该节点就是LCA
 * 如果root.val1比val1还小，那么需要去值更大的右子树中寻找LCA
 * 如果root.val1比val2还大，那么需要去值更小的左子树中寻找LCA
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return find(root, val1, val2);
    }

    public TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return root;
        }
        if (root.val < val1) {
            // 去右子树中找
            return find(root.right, val, val2);
        }
        if (root.val > val2) {
            // 去左子树中找
            return find(root.left, val, val2);
        }
        return root;
    }
}