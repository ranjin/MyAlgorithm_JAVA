package 动态规划;
import java.util.Arrays;
/**
 * 最长公共子序列：LCS
 * 输入：text1 = "abcde", text2 = "ace" 
 * 输出：3  
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 */
public class LeeCode_1143_最长公共子序列 {
    /**
     * dp数组定义：dp[i][j] 表示s1的前i个元素与s2的前j个元素的lcs的长度
     * base case：dp[0, j] 和 dp[i, 0]的值为0，即s1前0个元素与...
     * 状态转移方程：
     * dp[i][j]的值为i的左边与j
	 * if(num1[i - 1] = num2[j - 1]) dp[i, j] = dp[i - 1][j - 1] + 1
	 * if(num1[i - 1] != num2[j - 1]) dp[i, j] = max { dp[i][j - 1] dp[i - 1][j]}
     */

	/**
	 * dp定义：
	 * dp[i][j]指nums1的前i个元素与nums2的前j个元素的LCS的长度
	 * 
	 * base case:
	 * dp[0][j] = dp[i][0] = 0;
	 * 
	 * 状态转移方程：
	 * if (nums[i-1] == nums2[j - 1]) dp[i]
	 */
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length(), n = text2.length();

		if (m == 0 || n == 0) {
			return 0;
		}

		int dp[][] = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		// 函数定义
		return dp[m][n];
	}
    public int longestCommonSubsequence(String text1, String text2) {
    	int m = text1.length(), n = text2.length();
		if (m == 0 || n == 0) {
			return 0;
		}
    	int[][] dp = new int[m + 1][n + 1];
    	for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// 现在i和j都从1开始，所以要减1
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
    	return dp[m][n];
    }
}
