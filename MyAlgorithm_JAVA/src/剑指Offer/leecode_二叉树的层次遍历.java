package 剑指Offer;

import java.util.LinkedList;
import java.util.List;

public class leecode_二叉树的层次遍历 {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<List<Integer>> resultList = new LinkedList<List<Integer>>();
		if (root == null) {
			return resultList;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		LinkedList<TreeNode> tmp;
		
		//初始化resultList并加入根节点
		LinkedList<Integer> itemList = new LinkedList<Integer>();
		
		itemList.add(root.val);
		resultList.add(itemList);
		
		while (!queue.isEmpty()) {
			LinkedList<Integer> itemList2 = new LinkedList<Integer>();
			tmp = new LinkedList<TreeNode>();
			for (TreeNode treeNode : queue) {
				if (treeNode.left != null) {
					tmp.add(treeNode.left);
				}
				if (treeNode.right != null) {
					tmp.add(treeNode.right);
				}
				itemList2.add(treeNode.val);
			}
			queue = tmp;
			resultList.add(itemList2);
		}
		return resultList;
	}
}
