/**
 * 填充每个节点的右侧指针。
 * 思路：当作三叉树来看
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
}


public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    // 三叉树遍历框架。
    // 遍历的思想，是否能用一个traverse函数来完成
    public TreeNode traverse(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        // 前序位置，将传入的两个节点串起来
        node1.next = node2;

        // 连接相同父节点的两个子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);

        // 连接跨越父节点的两个子节点
        traverse(node1.right, node2.left);
    }
}