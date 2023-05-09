package 二叉树;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/
 * 还原二叉树的时候只需要遍历所有节点，通过函数参数传递每个节点的值。
 * find可以通过hashSet缓存所有节点的值。
 * 
 * hashSet：集合中不允许有重复的值
 * hashMap：map中的key值不允许重复
 *
 */
public class leecode1261_在受污染的二叉树中查找元素 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	HashSet<Integer> values = new HashSet<>();
	// 还原二叉树 根据父节点得出左右子节点的值
    public leecode1261_在受污染的二叉树中查找元素(TreeNode root) {
    	// 还原二叉树的值
    	traverse(root, 0);
    }
    
    // 二叉树遍历函数
    public void traverse(TreeNode root, int val) {
    	if (root == null) {
    		return;
    	}
    	// 前序位置
    	root.val = val;
    	values.add(val);
    	traverse(root.left, val * 2 + 1);
    	traverse(root.right, val * 2 + 2);
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }
}
