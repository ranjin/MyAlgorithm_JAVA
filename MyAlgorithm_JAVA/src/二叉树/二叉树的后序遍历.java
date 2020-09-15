package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的后序遍历 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	private List<Integer> list;
	
	public List<Integer> postorderTraversal(TreeNode root){
		list = new ArrayList<Integer>();
		postorder(root);
		return list;
	}
	
	public void postorder(TreeNode root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		list.add(root.val);
	}
}














