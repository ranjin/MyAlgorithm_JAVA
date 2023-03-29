package 动态规划;

public class LeeCode_1143_最长公共子序列 {

	/**
	 * 输入：text1 = "abcde", text2 = "ace" 
	 * 输出：3  
	 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
	 * 
	 * 输入：text1 = "abc", text2 = "abc"
	 * 输出：3
	 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
	 * 
	 * 思路：
	 * 对于
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
	
	/**
	 * 思路：
	 * 对于两个字符串求子序列问题，都是用两个指针i和j分别在两个字符串上移动。大概率是动态规划思路。
	 * 定义dp函数：计算s1[i..]和s2[j..]的最长公共子序列长度
	 * dp(s1, i, s2, j)：计算s1[i..]和s2[j..]的最长公共子序列长度。
	 * 那么我们想要的答案是dp[s1, 0, s2, 0]，
	 * base case: i == len(s1) 或 j == []
	 * 
	 */
    public int longestCommonSubsequence2(String text1, String text2) {

    }
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
