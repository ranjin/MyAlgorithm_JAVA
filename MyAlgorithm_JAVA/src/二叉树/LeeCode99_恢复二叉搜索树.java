package 二叉树;

/*
 * 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 */
public class LeeCode99_恢复二叉搜索树 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	TreeNode firstNode = null;
	TreeNode secondNode = null;

	TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
	
	/*
	 * 二叉搜索树的中序遍历是有序数组
	 */
    public void recoverTree(TreeNode root) {
    	if (root == null) {
			return;
		}
    	recoverTree(root.left);
    	if (root.val ) {
			
		}
    }
    
    public void in_order(TreeNode root) {
		if (root == null) {
			return;
		}
		in_order(root.left);
	}
}





















