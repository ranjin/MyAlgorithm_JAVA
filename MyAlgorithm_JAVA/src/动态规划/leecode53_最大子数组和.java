package 动态规划;

/**
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 */
public class leecode53_最大子数组和 {
	/**
	 * 方法1：滑动窗口技巧
	 * 在窗口内元素大于0时扩大窗口，在窗口内元素之和小于0时缩小窗口，在每次移动窗口时更新答案
	 */
    public int maxSubArray(int[] nums) {
    	int left = 0, right = 0;
    	int windowSum = 0, maxSum = Integer.MIN_VALUE;
    	
    	while (right < nums.length) {
			// 扩大窗口并更新窗口内的元素和
    		windowSum += nums[right];
    		right++;
    		
    		// 更新答案
    		maxSum = maxSum > windowSum ? maxSum : windowSum;
    		
    		// 判断窗口是否需要收缩
    		while (windowSum < 0) {
                // 缩小窗口并更新窗口内的元素和
				windowSum -= nums[left];
				left++;
			}
		}
    	return maxSum;
    }
    
    /**
     * 方法2: 动态规划
     * dp定义：以nums[i]为结尾的最大子数组和为dp[i]
     * base case: dp[0] = nums[0]
     * 状态转移方程： dp[i] = Math.max(dp[i], dp[i - 1] + nums[i])
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
    	int n = nums.length;
    	if (n == 0) {
			return 0;
		}
    	int[] dp = new int[n];
    	dp[0] = nums[0];
    	for (int i = 1; i < n; i++) {
    		if (dp[i - 1] > 0) {
    			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
    		} else {
    			dp[i] = nums[i];
    		}
		}
    	
    	int res = Integer.MIN_VALUE;
    	for (int i = 0; i < n; i++) {
			res = Math.max(res, dp[i]);
		}
    	return res;
    }
}
