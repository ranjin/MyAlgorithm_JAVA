package 二叉树;

import java.util.LinkedList;
import java.util.List;

public class leecode_153_二叉树中和为目标值的路径 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	/**
	 * 思路：
	 * 遍历一颗二叉树，把所有符合条件的路径找出来。
	 * 注意需要回溯：⚠️
	 * 为了维护经过路径，在进入递归的时候要在path列表添加节点，结束递归的时候删除节点:
	 */
	List<List<Integer>> res = new LinkedList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	if (root == null) {
			return res;
		}
    	// 遍历二叉树
    	traverse(root, sum, new LinkedList<>());
    	return res;
    }
    
    // 遍历二叉树
    public void traverse(TreeNode root, int sum, LinkedList<Integer> path) {
		if (root == null) {
			return;
		}
		int remain = sum - root.val;
		if (root.left == null && root.right == null) {
			if (remain == 0) {
				// 找到一条路径
				path.addLast(root.val);
				res.add(new LinkedList<Integer>(path));
				path.removeLast();
			}
			return;
		}
		// 维护路径列表
		path.addLast(root.val);
		traverse(root.left, sum, path);
		path.removeLast();
		
		path.addLast(root.val);
		traverse(root.right, sum, path);
		path.removeLast();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
