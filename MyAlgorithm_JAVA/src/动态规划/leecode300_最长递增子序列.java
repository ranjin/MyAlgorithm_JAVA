package 动态规划;

import java.util.Arrays;

//最长上升/递增子序列 Longest Increasing Subsequence: LIS
/**
 * 给定一个无序的整数序列，求出它最长上升子序列的长度
 * 比如[10, 2, 2, 5, 1, 7, 101, 18]的最长上升子序列是[2, 5, 7, 10]、[2, 5, 7, 18]长度是4
 *
 * 假设数组nums = [10, 2, 2, 5, 1, 7, 101, 18]
 * 
 * 状态定义：
 * dp[i]是以nums[i]结尾的最长递增子序列的长度。
 * 第二次遍历时，只需要找到每一个比nums[i]小的数，且长度需要+1即可
 * 
 * 初始值：base case
 * dp[0]：以nums[0]结尾的最长上升子序列的长度。所以dp[0] = 1
 * 
 * 状态转移方程：
 * 以nums[5]举例，dp[5]
 * if (nums[i] > nums[j]) {
 * 	dp[i] = Math.max(dp[i], dp[j] + 1);
 * }
 * 
 * 核心思路：
 * 索引：	0		1		2		3		4		5
 * nums:   1	   4	   3       4       2       3
 * dp:     1	   2       2       3       2       3
 * 
 */
public class leecode300_最长递增子序列 {
	public int lengthOfLIS(int[] nums) {
		// 一维dp数组定义
		int[] dp = new int[nums.length];

		// base case: dp数组全都初始化为1
		Arrays.fill(dp, 1);
		int max = dp[0] = 1;
		

		// 状态转移方程
		// 以nums[5]举例，其实就是找nums[5]前面比nums[5]小的数。
		// 而且是LIS
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
