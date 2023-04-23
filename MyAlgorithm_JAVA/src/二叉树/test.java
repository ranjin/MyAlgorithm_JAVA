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
	// 从上到下遍历每一层节点
	// 从左到右遍历每一行的节点
	/**
	 *  			1
	 *  		2		3
	 *       4    5   6   7
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);

		// 从上到下遍历二叉树的每一层

		while(!queue.isEmpty()) {
			int sz = queue.size();
			List<Integer> level = new ArrayList<>();

			// 从左到右遍历每一层的节点
			for (int i = 0; i < sz; i++) {
				TreeNode cur = queue.poll();
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
				level.add(cur.val);
			}
			result.add(level);
		}
		return result;
	}
}
