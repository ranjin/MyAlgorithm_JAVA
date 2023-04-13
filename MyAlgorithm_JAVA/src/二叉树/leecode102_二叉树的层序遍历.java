package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历 {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	/**
	 * Java中Queue队列的用法
	 * 插入元素：offer()或者add()
	 * 返回并且删除队首元素：remove()或者poll()
	 * 返回并且不删除队首元素：element()或者peek()
	 * 思路：
	 * 从上到下遍历二叉树的每一层，每一层从左到右遍历每一个val
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		// 创建队列,加入head元素
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		// 从上到下遍历二叉树的每一层
		while (!queue.isEmpty()) {
			int sz = queue.size();
			List<Integer> level = new ArrayList<>();
			// 从左到右遍历每一层的每个节点
			for (int i = 0; i < sz; i++) {
				TreeNode cur = queue.poll();
				level.add(cur.val);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			res.add(level);
		}
		return res;
	}
}
















