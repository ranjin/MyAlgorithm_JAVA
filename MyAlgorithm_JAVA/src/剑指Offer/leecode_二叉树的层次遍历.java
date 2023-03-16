package 剑指Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 
 * 思路：
 * 从上到下遍历每一层，从左到右遍历每一个节点
 * 先加入根节点，然后根节点的左右子节点
 * 就是创建linkedList有点繁琐
 *
 */
public class leecode_二叉树的层次遍历 {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	LinkedList<List<Integer>> resultList = new LinkedList<List<Integer>>();
    	if (root == null) {
			return resultList;
		}
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	
    	LinkedList<Integer> itemList = new LinkedList<Integer>();
    	itemList.add(root.val);
    	LinkedList<TreeNode> temp;
    	while (!queue.isEmpty()) {
			LinkedList<Integer> itemList2 = new LinkedList<Integer>();
			temp = new LinkedList<TreeNode>();
			for (TreeNode node : queue) {
				if (node.left != null) {
					temp.add(node.left);
				}
				if (node.right != null) {
					temp.add(node.right);
				}
				itemList2.add(node.val);
			}
			queue = temp;
			resultList.add(itemList2);
		}
    	return resultList;
    }
}
