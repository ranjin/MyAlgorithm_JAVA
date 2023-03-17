package 二叉树;

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
	
	// 广度优先
	
    public int minDepth(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> tmpList;
    	queue.add(root);
    	int height = 1;	// 初始高度
    	
    	while (!queue.isEmpty()) {
    		tmpList = new LinkedList<TreeNode>();
			for (TreeNode treeNode : queue) {
				if (treeNode.left == null && treeNode.right == null) {
					return height;
				}
				if (treeNode.left != null) {
					tmpList.add(treeNode.left);
				}
				if (treeNode.right != null) {
					tmpList.add(treeNode.right);
				}
			}
			queue = tmpList;
			height++;
		}
    	return height;
    }
}
