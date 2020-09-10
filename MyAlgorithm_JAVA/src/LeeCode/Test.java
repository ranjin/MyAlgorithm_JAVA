package LeeCode;

import java.util.HashMap;

public class Test {
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	
	private HashMap<Integer, Integer> map;
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return buildMyTree(preorder, inorder, 0, n-1, 0, n-1);
	}
	
	public TreeNode buildMyTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
		//根据前序遍历获取到根节点
		int preorder_root = preorder_left;
		
		//在中序遍历中定位根节点 索引值
		int inorder_root = map.get(preorder[preorder_root]);
		
		TreeNode root = new TreeNode(preorder[preorder_root]);
		
		
		//左子树上节点数量
		int size_left_subtree = inorder_root - inorder_left; 
		
		
		root.left = buildMyTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_left + inorder_root-1);
		
		root.right = buildMyTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root+1, inorder_right);
		
		return root;
	}
}


















