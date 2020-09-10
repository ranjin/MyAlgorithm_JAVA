package 二叉树;

public class LeeCode124_二叉树中的最大路径和 {

	/*
	 * 给定一个非空二叉树，返回其最大路径和。
	 * 从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
	 */
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	int max = Integer.MIN_VALUE;
	/*
	 * 就是一个后序遍历: 根 - 左 - 右
	 * 时间复杂度：O(N)  空间复杂度O(N)
	 */
	public int maxPathSum(TreeNode root) {
		maxGain(root);
		return max;
	}
	
	public int maxGain(TreeNode node) {
		if (node == null) {
			return 0;
		}
		//左边叶子节点的最大贡献值
		int left = Math.max(maxGain(node.left), 0);
		
		//右边叶子节点的最大贡献值
		int right = Math.max(maxGain(node.right), 0);

		/*
		 * 对于二叉树中的一个节点，该节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值。
		 * 如果子节点的最大贡献值为正，则计入该节点的最大路径和，否则不计入。
		 * 维护一个全局变量ans存储最大路径和，在递归过程中更新maxSum的值，最后得到的maxSum的值即为二叉树中的最大路径和。
		 */
		max = Math.max(max, left + right + node.val);
		return node.val + Math.max(left, right);
	}
}





















