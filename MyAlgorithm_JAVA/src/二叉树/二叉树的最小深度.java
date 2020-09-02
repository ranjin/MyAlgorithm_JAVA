package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 剑指Offer.面试题39_二叉树的深度.TreeNode;
import 递归与回溯.test;

public class 二叉树的最小深度 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	//深度优先
    public int minDepth(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	if (root.left == null && root.right == null) {
			return 1;
		}
    	int min_depth = Integer.MAX_VALUE;
    	if (root.left != null) {
    		min_depth = Math.min(minDepth(root.left), min_depth);
		}
    	if (root.right != null) {
    		min_depth = Math.min(minDepth(root.right), min_depth);
		}
    	return min_depth; 
    }
    
    //广度优先
	public int minDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int height = 1;	//初始高度为1
		
		List<TreeNode> queue = new LinkedList<TreeNode>();
		List<TreeNode> tmp;
		queue.add(root);
		
		while (!queue.isEmpty()) {
			tmp = new LinkedList<TreeNode>();
			for (TreeNode treeNode : queue) {
				if (treeNode.left == null && treeNode.right == null) {
					return height;
				}
				if (treeNode.left != null) {
					tmp.add(treeNode.left);
				}
				if (treeNode.right != null) {
					tmp.add(treeNode.right);
				}
			}
			queue = tmp;
			height++;
		}
		return height;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
