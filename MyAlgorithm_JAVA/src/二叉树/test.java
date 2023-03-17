package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class test {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	List<Integer> resultList = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return resultList;
        }
        
        posterOrder(root);
        return resultList;
    }
    public void posterOrder(TreeNode root) {
		posterOrder(root.left);
		posterOrder(root.right);
		resultList.add(root.val);
	}
}
