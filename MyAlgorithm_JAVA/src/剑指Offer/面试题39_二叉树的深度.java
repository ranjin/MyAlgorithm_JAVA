package 剑指Offer;

import java.util.LinkedList;
import java.util.List;

public class 面试题39_二叉树的深度 {
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	/*
	 * 后序遍历(DFS)
	 * 深度：从根节点到叶子节点最长路径的长度
	 * 树的深度就是其左、右子树深度的较大值加1.
	 */
    public int maxDepth(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
	
    /*
     * 层序遍历(BFS)
     * 使用队列来实现
     * 
     */
    public int maxDepth2(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	
    	//初始化队列与tmp临时队列，并放入root
    	List<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	List<TreeNode> tmp = new LinkedList<TreeNode>();
    	int res = 0;
    	while (!queue.isEmpty()) {
    		for (TreeNode node : queue) {
				if (node.left != null) {
					tmp.add(node.left);
				}
				if (node.right != null) {
					tmp.add(node.right);
				}
			}
    		queue = tmp;
    		res++;
		}
    	return res;
    }
}
