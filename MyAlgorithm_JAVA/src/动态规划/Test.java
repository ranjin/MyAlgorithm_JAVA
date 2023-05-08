package 动态规划;

import java.util.Arrays;

public class Test {

	public int lengthOfLIS(int[] nums) {
		// dp定义：以dp[i]以nums[i]为结尾的LIS的长度
		
		/**
		 * index    0		1		2		3		4		5
		 * nums:	1	    4		3		4		2		3
		 * dp[i]:   1		2		2		3		2		
		 * 
		 * numd[5] 前面 nums[0]与nums[4]都小于5.那么 dp【5】= Math.max(dp[5], dp[1]或者dp[4] + 1)
		 */
//		nums[1] = 1, nums[2] = nums[1] < nums[2] ? nums[1] + 1 : 1;
		
		int n = nums.length;
		int[] dp = new int[n];
		
		// dp初始化,均为1
		Arrays.fill(dp, 1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				// 寻找nums[0, j - 1]之间比nums[i]小的元素
				if (nums[i] > nums[j]) {
					// 把nums[i]接在后面，即可形成长度为dp[j] + 1,且以nums[i]为结尾的递增子序列
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		// 明确dp数组的定义，需要遍历
		int res = 1;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
