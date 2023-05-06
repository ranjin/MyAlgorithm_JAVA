package 二叉树.构造篇;

/**
 * 给定一个不重复的整数数组 nums ，构建最大二叉树：
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 *
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 */
public class leecode654_最大二叉树{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
    }
    
    TreeNode constructMaximumBinaryTree(int[] nums) {
    	return constructTree(nums, 0, nums.length - 1);
    	// 找到数组最值 [3,2,1,6,0,5],然后递归调用构造左右子树 伪代码如图所示：
//    	TreeNode root = new TreeNode(6);
//    	root.left = constructMaximumBinaryTree([3,2,1]);
//    	root.right = constructMaximumBinaryTree([0,6]);
//    	return root;

    }
    
    // 辅助函数，定义：将nums[lo...hi]构造成符合条件的树，返回根节点
    public TreeNode constructTree(int[] nums, int lo, int hi) {
    	if (lo > hi) {
    		return null;
    	}
    	// 找到数组中的最大值跟对应的索引
    	int index = -1, maxVal = Integer.MIN_VALUE;
    	for (int i = lo; i <= hi; i++) {
    		if (maxVal < nums[i]) {
    			index = i;	// 索引值
    			maxVal = nums[i];
    		}
    	}
    	
    	// 先构造出根节点
    	TreeNode root = new TreeNode(maxVal);

    	// 递归调用构造左右子树
    	root.left = constructTree(nums, lo, index - 1);
    	root.right = constructTree(nums, index + 1, hi);
    	return root;
    }
}