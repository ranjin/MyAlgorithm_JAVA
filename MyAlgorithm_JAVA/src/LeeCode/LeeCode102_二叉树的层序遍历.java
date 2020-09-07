package LeeCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeeCode102_二叉树的层序遍历 {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if (root == null) {
			return res;
		}
    	Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
    	
    	queue.add(root);
    	
    	while (!queue.isEmpty()) {
    		List<Integer> tmp = new ArrayList<Integer>();
    		for (int i = 0; i < queue.size(); i++) {
				TreeNode node = queue.poll();
				tmp.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			res.add(tmp);
		}
    	return res;
    }
}
















