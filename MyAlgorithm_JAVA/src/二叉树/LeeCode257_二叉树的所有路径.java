package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class LeeCode257_二叉树的所有路径 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	/*
	 * DFS深度优先遍历
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<String>();
		searchPath(root, "", paths);
		return paths;
	}
	
	public void searchPath(TreeNode root, String path, List<String> paths) {
		if (root != null) {
			StringBuilder sPath = new StringBuilder(path);
			sPath.append(root.val);
			if (root.left == null && root.right == null) {
				//如果是叶子节点
				paths.add(sPath.toString());
			}else {
				//如果是非叶子节点
				sPath.append("->");
				//向左寻找叶子节点
				searchPath(root.left, sPath.toString(), paths);
				
				//向右寻找叶子节点
				searchPath(root.right, sPath.toString(), paths);
			}
		}
	}
}
