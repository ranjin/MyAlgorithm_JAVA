package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {

	private List<Integer> list;
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	public List<Integer> inorderTraversal(TreeNode root){
		list = new ArrayList<Integer>();
		inorder(root);
		return list;
	}
	
	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}
}
