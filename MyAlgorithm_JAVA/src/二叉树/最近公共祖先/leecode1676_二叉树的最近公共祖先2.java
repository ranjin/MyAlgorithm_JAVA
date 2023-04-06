package 二叉树;

import java.util.HashSet;

/*
 * 依然给你输入一棵不含重复值的二叉树，
 * 但这次不是给你输入p和q两个节点了，
 * 而是给你输入一个包含若干节点的列表nodes（这些节点都存在于二叉树中），
 * 让你算这些节点的最近公共祖先。
 */
public class leecode1676_二叉树的最近公共祖先2 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
		// 将列表转化为哈希集合，便于判断元素是否存在
		HashSet<Integer> values = new HashSet<>();
		for (TreeNode node : nodes) {
			values.add(node.val);
		}
		return find(root, values);
	}
	
	public TreeNode find(TreeNode root, HashSet<Integer> values) {
		if (root == null) {
			return null;
		}
		// 前序位置
		if (values.contains(root.val)) {
			return root;
		}
		
		TreeNode left = find(root.left, values);
		TreeNode right = find(root.right, values);

		// 后序位置，已经知道左右紫薯是否存在目标值
		if (left != null && right != null) {
			// 当前节点是LCA节点
			return root;
		}
		return left != null ? left : right;
	}
}
