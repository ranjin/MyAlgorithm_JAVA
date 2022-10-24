package 动态规划;

import java.util.Iterator;

/**
 * 给定一个无序的整数序列，求出它最长上升子序列的长度
 * 比如[10, 2, 2, 5, 1, 7, 101, 18]的最长上升子序列是[2, 5, 7, 10]、[2, 5, 7, 18]长度是4
 *
 * 假设数组nums = [10, 2, 2, 5, 1, 7, 101, 18]
 * 状态定义：
 * dp[i]是以nums[i]结尾的最长上升子序列的长度。
 * 
 * 初始值：
 * dp[0]：以nums[10]结尾的最长上升子序列的长度。所以dp[0] = 1
 */
public class 最长上升子序列 {

	static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int max = dp[0] = 1;
		for (int i = 0; i < dp.length; i++) {
			// 每个的初始值
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
		
	}
	
}
