package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		// 从上到下遍历每一层
		// 从左到右遍历每一层的元素
		
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		
		if (root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.offer(root);;
		
		while (!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			
			for (int i = 0; i < queue.size(); i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				temp.add(node.val);
			}
			result.add(temp);
		}
		return result;
	}
}











