package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeeCode95_二叉树的中序遍历 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			this.val = x;
		}
	}
	
//	public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> resultList = new LinkedList<Integer>();
//		if (root == null) {
//			return resultList;
//		}
//		helper(root, resultList);
//		return resultList;
//	}
//	
//	//使用辅助函数实现递归
//	public void helper(TreeNode root, List<Integer> res) {
//		if (root != null) {
//			if (root.left != null) {
//				helper(root.left, res);
//			}
//			res.add(root.val);
//			if (root.right != null) {
//				helper(root.right, res);
//			}
//		}
//	}
	
	/*
	 * 使用栈
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		
		if (root == null) {
			return list;
		}
		
		//栈的遍历
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while (!stack.isEmpty() || root != null) {
			//一直访问左节点
			if (root != null) {
				stack.push(root.left);
				root = root.left;
			}else {
				//如果为空 弹出栈 存放结果
				root = stack.pop();
				list.add(root.val);
				root = root.right;
			}
		}
		return list;
	}

	
	
}








