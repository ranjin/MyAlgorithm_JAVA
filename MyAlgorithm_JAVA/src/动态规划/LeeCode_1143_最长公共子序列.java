package 动态规划;

public class LeeCode_1143_最长公共子序列 {

	/**
	 * 定义状态
	 * dp[i][j]表示nums1前i个元素与nums2前j个元素的最长公共子序列的长度
	 * 
	 * 定义初始值：
	 * dp[i][0] 与 dp[0][j]的初始值为0
	 * 
	 * 状态转移方程：
	 * if(num1[i - 1] = num2[j - 1]) dp[i, j] = dp[i - 1][j - 1] + 1
	 * if(num1[i - 1] != num2[j - 1]) dp[i, j] = max { dp[i][j - 1] dp[i - 1][j]}
	 */
    public int longestCommonSubsequence(int[] nums1, int[] nums2) {
    	 if (nums1 == null || nums1.length == 0) {
			return 0;
    	 }
    	 if (nums2 == null || nums2.length == 0) {
			return 0;
    	 }
    	 int[][] dp = new int[nums1.length + 1][nums2.length + 1];
    	 for (int i = 1; i <= nums1.length; i++) {
			for (int j = 0; j <= nums2.length; j++) {
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
    	 }
    	 return dp[nums1.length][nums2.length];
    }
}
