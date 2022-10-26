package 二叉树;

import 二叉树.LeeCode105_从前序与中序遍历序列构造二叉树.TreeNode;

/**
 * 去以root为根节点的二叉树中查找p和q的最近公共祖先
 */
public class LeeCode_236_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if (root == null || q == root || p == root) {
			return root;
		}
    	// 去以root.left为根节点的二叉树中查找p和q的最近公共祖先
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	
    	// 去以root.right为根节点的二叉树中查找p和q的最近公共祖先
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	
    	if (left != null && right != null) {
			return root;
		}
    	
    	return left != null ? left : right;

    }
}
