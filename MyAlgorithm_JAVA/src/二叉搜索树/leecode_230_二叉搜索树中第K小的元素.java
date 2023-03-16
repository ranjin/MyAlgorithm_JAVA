package 二叉搜索树;

import javax.swing.plaf.basic.BasicTreeUI.TreeTraverseAction;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 
 * 思路：
 * 将二叉搜索树按照中序遍历，得到一个升序序列，然后取第K个元素
 */
public class leecode_230_二叉搜索树中第K小的元素 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	// 记录结果
	int res = 0;
	
	// 记录当前元素的排名
	int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
    	if (root == null) {
			return -1;
		}
    	traverse(root, k);
    	return res;

    }
	void traverse(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		traverse(root.left, k);
		/* 中序遍历代码位置*/
		rank++;
		if (k == rank) {
			res = root.val;
			return;
		}
		traverse(root.right, k);
	}
}




























