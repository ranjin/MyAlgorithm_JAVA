package 二叉树;

import 二叉树.二叉树的最大深度.TreeNode;

public class test {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	

	int maxDepth = 0;
	
	int levelDepth = 0;
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return maxDepth;
		}
		traverse(root);		
		return maxDepth;
	}
	
	public void traverse(TreeNode rooNode) {
		
		if (rooNode == null) {
			// 到达叶子节点,更新
			maxDepth = Math.max(maxDepth, levelDepth);
			return;
		}
		// 前序遍历
		levelDepth++;
		traverse(rooNode.left);
		traverse(rooNode.right);
		levelDepth--;
		
	}
}
