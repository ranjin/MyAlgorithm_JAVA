package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的前序遍历 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	private List<Integer> list;
	//前序遍历 根左右
	public List<Integer> preorderTraversal(TreeNode root) {
		
		list = new ArrayList<Integer>();
		preOrder(root);
		return list;
	}
	
	public void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
}








