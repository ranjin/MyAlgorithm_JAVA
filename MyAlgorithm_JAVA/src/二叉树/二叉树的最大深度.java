package 二叉树;

public class 二叉树的最大深度 {
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	

	/**
	 * 思路1:
	 * 遍历一棵二叉树，用一个外部变量记录每个节点所在的深度，
	 * 取最大值就可以得到最大深度
	 */

	// 记录最大深度
	int res = 0;
	// 记录遍历到的节点的最大深度
	int depth = 0;
	
	public int maxDepth_1(TreeNode root) {
		traverse(root);
		return res;
	}

	// 可以通过遍历一棵二叉树得到，所以用一个traverse函数+外界变量
	public void traverse(TreeNode root) {
		if (root == null) {
			// 到达叶子节点，更新最大深度
			res = Math.max(res, depth);
			return;
		}
		// 前序位置，进入一个节点
		depth++;
		traverse(root.left);
		traverse(root.right);

		// 后序位置，离开一个节点
		depth--;
	}


	/**
	 * 借助于二叉树的最大高度(二叉树的最大深度 + 1)
	 */
	public int maxDepth_2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth_2(root.left);
		int right = maxDepth_2(root.right);
		return Math.max(left, right) + 1;
	}
}
