package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 
 * 思路：
 * 从上到下遍历每一层，从左到右遍历每一个节点
 * 先加入根节点，然后根节点的左右子节点
 * 就是创建linkedList有点繁琐
 *
 */
public class leecode_二叉树的层次遍历 {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int sz = queue.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < sz; i++) {
				TreeNode cur = queue.poll();
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
				temp.add(cur.val);
			}
			res.add(temp);
		}
		return res;
	}
}
