package 动态规划;

public class Test {

	// 比如说输入 nums = [-3,1,3,-1,2,-4,2]，算法返回 5，
	// 因为最大子数组 [1,3,-1,2] 的和为 5。
    public int maxSubArray(int[] nums) {
    	// 采用滑动窗口, 窗口内和大于0扩大窗口，小于0时缩小窗口
    	int left = 0, right = 0;
    	int n = nums.length;
    	int windowSum = 0;
    	int maxSum = Integer.MIN_VALUE;
    	while (right < n) {
			windowSum += nums[right];
			right++;
			maxSum = Math.max(maxSum, windowSum);
			while (windowSum < 0) {
				windowSum -= nums[left];
				left++;
			}
		}
    	return maxSum;
    }
}
