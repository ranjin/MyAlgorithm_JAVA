package 二叉树;

public class 对称二叉树 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	public boolean isSymmetric(TreeNode root) {
		return check(root.left, root.right);
	}
	
	public boolean check(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		
		if (p == null || q == null) {
			return false;
		}
		return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
	}
}












