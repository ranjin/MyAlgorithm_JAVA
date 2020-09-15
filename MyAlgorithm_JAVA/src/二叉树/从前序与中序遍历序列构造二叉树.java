package 二叉树;

import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树 {

	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			// TODO Auto-generated constructor stub
			val = x;
		}
		
		private Map<Integer, Integer> indexMap;
		/*
		 * 前序遍历 preorder = [3,9,20,15,7]
		 * 
		 * 中序遍历 inorder = [9,3,15,20,7]
		 */
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	    	indexMap = new HashMap<Integer, Integer>();
	    	int n = inorder.length;
	    	for (int i = 0; i < n; i++) {
	    		//借助于hashMap key为节点值，value为其索引
				indexMap.put(inorder[i], i);
			}
	    	return rebuildMyTree(preorder, inorder, 0, n-1, 0, n-1);
	    }
	    
	    //递归方法
	    public TreeNode rebuildMyTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, 
	    		 int inorder_left, int inorder_right) {
	    	if (preorder_left > preorder_right) {
				return null;
			}
			//创建根节点，通过哈希表定位到根节点在序列中的位置
	    	int preorder_root = preorder_left;
	    	TreeNode root = new TreeNode(preorder[preorder_root]);
	    	
	    	int inorder_root = indexMap.get(preorder[preorder_root]);
	    	
	    	//获取递归的左右节点
	    	int size_left_subtree = inorder_root - inorder_left;
	    	
	    	root.left = rebuildMyTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree,
	    			inorder_left, inorder_root-1);
	    	
	    	root.right = rebuildMyTree(preorder, inorder, size_left_subtree + preorder_left + 1
	    			, preorder_right-1, inorder_root+1, inorder_right);
	    	return root;
		}
	}
}











