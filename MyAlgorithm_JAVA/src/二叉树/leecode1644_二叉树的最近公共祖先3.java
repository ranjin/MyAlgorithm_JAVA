package 二叉树;

/**
 * 给你输入一棵不含重复值的二叉树的，以及两个节点p和q，
 * 如果p或q不存在于树中，则返回空指针，否则的话返回p和q的最近公共祖先节点。
 *
 * 思路：相比与p或q一定存在与树中，这里需要对二叉树进行完全搜索。如果p或q不存在树中，不存在LCA
 * 
 */
public class leecode1644_二叉树的最近公共祖先3 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	boolean foundP = false, foundQ = false;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode res = find(root, p.val, q.val);
		if (!foundP || !foundQ) {
			return null;
		}
		return res;
	}
	
	public TreeNode find(TreeNode root, int val1, int val2) {
		if (root == null) {
			return null;
		}
		TreeNode left = find(root.left, val1, val2);
		TreeNode right = find(root.right, val1, val2);

		// 后序位置，判断当前节点是不是LCA节点
		if (left != null && right != null) {
			return root;
		}
		
		if (root.val == val1 || root.val == val2) {
			// 找到了，记录一下
			if (root.val == val1) {
				foundP = true;
			}
			if (root.val == val2) {
				foundQ = true;
			}
			return root;
		}
		return left != null ? left : right;
	}

}
