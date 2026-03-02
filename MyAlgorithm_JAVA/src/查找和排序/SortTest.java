package 查找和排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
}

public class SortTest {

	// 二叉树的层序遍历

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new LinkedList<>();

		if (root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<>();


		queue.offer(root);

		// 从上到下，每层从左到右
		while (!queue.isEmpty()) {
			
			List<Integer> tempList = new LinkedList<>();
			int sz = queue.size();

			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();

				tempList.add(node.val);

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}


			res.add(tempList);
		}
		return res;


	}

}