package 二叉树;

import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			// TODO Auto-generated constructor stub
			val = x;
		}
		
		/*
		 * 中：[9, 3, 15, 20, 7]
		 * 
		 * 后：[9, 15, 7, 20, 3]
		 * 根节点为3:
		 * 
		 * 
		 * 
		 * 
		 */
		private Map<Integer, Integer> indexMap;

	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	    	indexMap = new HashMap<Integer, Integer>();
	    	int n = inorder.length;
	    	for (int i = 0; i < n; i++) {
				indexMap.put(inorder[i], i);
			}
	    	return rebuildMyTree(inorder, postorder, 0, n-1, 0, n-1);
	    }
	    
	    public TreeNode rebuildMyTree(int[] inorder, int[] postorder, int inorder_left, 
	    		int inorder_right, int postorder_left, int postorder_right) {
			if (postorder_left > postorder_right) {
				return null;
			}
			
			//创建根节点
			TreeNode root = new TreeNode(postorder[postorder_right]);

			int postorder_root = postorder_right;
			
			int inorder_root = indexMap.get(postorder[postorder_root]);
			
			
			int size_left_subtree = inorder_root - inorder_left;
			
			root.left = rebuildMyTree(inorder, postorder, inorder_left+1,
					inorder_left + size_left_subtree, postorder_left, postorder_left+size_left_subtree);
			root.right = rebuildMyTree(inorder, postorder, inorder_root + 1, 
					inorder_right-1, postorder_left + size_left_subtree, postorder_right);
			return root;
		}
	}
}





