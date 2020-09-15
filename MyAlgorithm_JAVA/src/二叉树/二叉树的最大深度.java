package 二叉树;

public class 二叉树的最大深度 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}
}
