package 剑指Offer;

public class 二叉树的镜像 {

	/*
	 * 求一棵树的镜像的过程：先前序遍历这棵树的每个节点
	 * 如果遍历到的节点有子节点，就交换它的两个子节点，
	 * 当交换完所有非叶子节点的左右节点之后，就得到了树的镜像。
	 */
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	public void MirrorRecursiveLy(TreeNode node) {
		if (node == null || (node.left == null && node.right == null)) {
			return;
		}
		
		//非叶子节点的左右节点互换
		TreeNode tempNode = node.left;
		node.left = node.right;
		node.right = tempNode;
		if (node.left != null) {
			MirrorRecursiveLy(node.left);
		}
		if (node.right != null) {
			MirrorRecursiveLy(node.right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}












