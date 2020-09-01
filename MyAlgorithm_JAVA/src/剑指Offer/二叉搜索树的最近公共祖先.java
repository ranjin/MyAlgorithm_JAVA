package 剑指Offer;

public class 二叉搜索树的最近公共祖先 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
			if (p.val > root.val && q.val > root.val) {
				//p,q都在root的右子树上
				//遍历至右子节点
				root = root.right;
			}else if (p.val < root.val && q.val < root.val) {
				root = root.left;
			}else {
				break;
			}
		}
        return root;
    }
}
