package 二叉树;
/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */

/**
 * 采用递归的思路：
 * 尝试给出flatten函数的定义：
 * // 
 */
public class leecode114_二叉树展开为链表 {

	 public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	 }
    // 输入节点root，然后root为根的二叉树就会被拉平为一条链条
    // 对于一个节点x，可以执行以下流程：
    // 1. 先利用flatten(x.left)和flatten(x.right)将X的左右子树拉平。
    // 2. 将X的右子树接到左子树下方，然后将整个左子树作为右子树。
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // 利用定义，将左右子树拉平
        flatten(root.left);
        flatten(root.right);

        // 后序遍历位置
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 将左子树作为右子树
        root.left = null;
        root.right = left;

        // 将原来的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}