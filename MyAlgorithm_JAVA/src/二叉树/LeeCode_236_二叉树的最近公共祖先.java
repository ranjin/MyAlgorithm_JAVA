package 二叉树;

/**
 * 思路：如果一个节点能够在它的左右子树中分别找到p和q，则该节点为LCA节点
 * 去以root为根节点的二叉树中查找p和q的最近公共祖先
 */


public class LeeCode_236_二叉树的最近公共祖先 {
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	return find(root, p.val, q.val);
    }
    
    public TreeNode find(TreeNode root, int val1, int val2) {
		if (root == null) {
			return null;
		}
		// 前序位置
		if (root.val == val1 || root.val == val2) {
			// 如果遇到目标值，直接返回
			return root;
		}
		TreeNode left = find(root.left, val1, val2);
		TreeNode right = find(root.right, val1, val2);

		// 后续位置，已经指导左右子树是否存在目标值
		if (left != null && right != null) {
			// 当前节点是LCA节点
			return root;
		}
		return left != null ? left : right;
	}
}
