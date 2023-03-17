package 二叉树;

public class 二叉树的路径总和 {

	/*
	 * 给定一个二叉树和一个目标和，
	 * 判断该树中是否存在根节点到叶子节点的路径:
	 * 使得这条路径上所有节点值相加等于目标和。
	 */
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	/*
	 * 递归思想：
	 * 假设从根节点到当前节点的值之和为val：
	 * 那么是否存在从当前节点到根节点的路径和为：sum - val
	 */
    public boolean hasPathSum(TreeNode root, int targetSum) {
    	if (root == null) {
			return false;
		}
    	
    	if (root.left == null && root.right == null) {
			return targetSum == root.val;
		}
    	
    	return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    	
	}
}











