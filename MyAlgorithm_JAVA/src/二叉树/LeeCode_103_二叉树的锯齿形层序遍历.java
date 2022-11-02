package 二叉树;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 锯齿层次遍历
 * 根结点算从正向，然后下一层反向
 */
public class LeeCode_103_二叉树的锯齿形层序遍历 {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> res = new LinkedList<>();
    	if (root == null) {
			return res;
		}
    	// 开始不需要调换顺序
    	Boolean needReverse = false;
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	// 从上到下遍历每一层
    	while (!queue.isEmpty()) {
			int sz = queue.size();
			LinkedList<Integer> temp = new LinkedList<>();
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			if (needReverse) {
				Collections.reverse(temp);
			}
			needReverse = !needReverse;
			res.add(temp);	
		}
    	return res;
    }
}
