/**
 * 思路：参考二叉树的层次遍历
 */
public class Solution {
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
	public List<Integer> largestValues(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int sz = queue.size();
			List<Integer> levelVal = new ArrayList<>();
			int max = Math.MIN_VALUE;
			for (int i = 0; i < sz; i++) {
				TreeNode cur = queue.poll();
				max = Math.max(cur.val, max);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			res.add(max);
		}
		return res;
    }
}
