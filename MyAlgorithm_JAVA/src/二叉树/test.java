package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test {

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
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		if (root == null) {
			return res;
		}
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int sz = queue.size();
			List<Integer> tmpList = new ArrayList<>();
			for (int i = 0; i < sz; i++) {
				TreeNode cur = queue.poll();
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
				tmpList.add(cur.val);
			}
			res.add(tmpList);
		}
		return res;
	}
}
