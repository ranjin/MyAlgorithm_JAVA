package 剑指Offer;

import 剑指Offer.二叉搜索树的最近公共祖先.TreeNode;

public class 二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if (root == null || p == root || q == root) {
    		return root;
		}
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	if (left == null) {
			return right;
		}
    	if (right == null) {
			return left;
		}
    	return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
