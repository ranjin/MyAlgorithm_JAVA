package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class 面试题23_从上往下打印二叉树 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	/*
	 * 思路：如果该节点有子节点，则把该节点的子节点放到一个队列的末尾，
	 */
	public int[] levelOrder(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		//首先添加根节点
		queue.add(root);
		while (!queue.isEmpty()) {
			//poll函数：从队列里面弹出元素
			TreeNode node = queue.poll();
			ans.add(node.val);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		int[] res = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			res[i] = ans.get(i);
		}
		return res;
	}
}













