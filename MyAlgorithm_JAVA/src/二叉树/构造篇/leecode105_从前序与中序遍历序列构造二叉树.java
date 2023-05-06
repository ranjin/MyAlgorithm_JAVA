package 二叉树.构造篇;

import java.util.HashMap;
import java.util.Map;

public class leecode105_从前序与中序遍历序列构造二叉树 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	private Map<Integer, Integer> indexMap;
	/*
	 * 前序遍历: [3, 9, 20, 15, 7]	根左右
	 * 中序遍历: [9, 3, 15, 20, 7]	左根右
	 * 
	 * 根节点：3 
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		/*
		 * 
		 */
		int n = preorder.length;
		
		//将中序遍历中的元素put哈希表中
		indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			indexMap.put(inorder[i], i);
		}
		return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);
	}
	
	public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
		if (preorder_left > preorder_right) {
			return null;
		}
		/*
		 * 1. 根据哈希表定位到根节点 创建根节点
		 * 2. 递归获取node的左右节点
		 * 3. 返回根节点
		 */
		//前序遍历的第一个节点就是根节点
		int preorder_root = preorder_left;
		
		//在中序遍历中定位根节点的位置 map[node, index]
		int inorder_root = indexMap.get(preorder[preorder_root]);
		
		//先把根节点建立起来
		TreeNode root = new TreeNode(preorder[preorder_root]);

		//得到左子树中的节点数目
		int size_left_subtree = inorder_root - inorder_left;
		
		/*
		 * 递归的构造左子树，并连接到根节点
		 * 前序遍历中：左边界 + 1 开始往后size_left_subtree个元素就对应了中序遍历中： 从左边界开始到根节点-1的元素
		 */
		root.left = myBuildTree(preorder, inorder, preorder_left+1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
		
		/*
		 * 递归的构造右子树，并连接到根节点
		 * 
		 */
		root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
		return root;
	}
}























