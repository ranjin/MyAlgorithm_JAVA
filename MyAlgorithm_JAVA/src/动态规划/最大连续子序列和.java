package 动态规划;

/**
 * 给定一个长度为n的整数序列，求它的最大连续子序列和
 * 比如 -2, 1, -3, 4, -1, 2, 1, -5, 4的最大连续子序列和是4 + (-1) + 2 + 1 = 6 
 * 状态定义：
 * 假设dp(i)是以nums[i]结尾的最大连续子序列和(nums是整个序列)
 * 
 * 
 * 初始值：
 * dp(0)的值是nums[0]
 * 状态转移方程：
 * if(dp(i - 1) <= 0) {
 * 	dp(i) = nums(i)
 * } else {
 * 	dp(i) = dp(i - 1) + nums(i)
 * }
 * 
 * dp(0): -2;
 * dp(1): 
 */
public class 最大连续子序列和 {

	public static void main(String[] args) {
		System.out.println(maxSubArray2(new int[] {-2, 1, -3, 4, -1, 2, 2, 1, -5, 5}));
	}
	
	
	public int maxSubArray3(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < dp.length; i++) {
			if (dp[i] < 0) {
				dp[i] = nums[i];
			} else {
				dp[i] = dp[i - 1] + nums[i];
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}
	
	// 优化空间复杂度从O(n)到O(1)
	static int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		// 初始值
		int dp = nums[0];
		int max = dp;
		// 状态转移方程
		for (int i = 1; i < nums.length; i++) {
			if (dp < 0) {
				dp = nums[i];
			} else {
				dp = dp + nums[i];
			}
			max = Math.max(dp, max);
		}
		return max;
	}
}
