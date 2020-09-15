package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LeeCode.LeeCode146_LRU缓存机制.Node;

public class 二叉树的层序遍历 {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	private List<List<Integer>> list;
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		list = new ArrayList<List<Integer>>();
		if (root == null) {
			return list;
		}
		
		List<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		List<TreeNode> tmp;
		
		while (!queue.isEmpty()) {
			tmp = new LinkedList<TreeNode>();
			List<Integer> rowValue = new LinkedList<Integer>();

			//每一层的所有的node
			for (TreeNode node : queue) {
				if (node.left != null) {
					tmp.add(node.left);
				}
				if (node.right != null) {
					tmp.add(node.right);
				}
				//这里添加每个node的值
				rowValue.add(node.val);
			}
			//到下一层
			queue = tmp;
			list.add(rowValue);
		}
		return list;
	}
}
















