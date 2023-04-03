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
	 * 自顶向下: 容易超时，建议使用自底向上
	 * dp数组定义： dp(s1, i, s2, j)：计算s1[i..]和s2[j..]的最长公共子序列长度。
	 * base case：i == s1.length() || j == s2.length() return 0
	 */
    public int longestCommonSubsequence(String text1, String text2) {
    	return dp(text1, 0, text2, 0);
    }
    
    // 定义：计算s1[i...]和s2[j...]的最长公共子序列长度
    public int dp(String s1, int i, String s2, int j) {
		// base case
    	if (i == s1.length() || j == s2.length()) {
			return 0;
		}
    	if (s1.charAt(i) == s2.charAt(j)) {
    		// 如果s1[i] = s2[j],那么这个字符串一定在lcs中
    		// 加上s1[i + 1..] 和s2[j+1..]中的lcs长度，就是答案
    		return 1 + dp(s1, i + 1, s2, j + 1);
		} else {
			// 针对不等的情况，s1[i]和s2[j]至少有一个不在lcs中。
			/**
			 * 穷举三种情况：
			 * s1[i]不在lcs中
			 * s2[j]不在lcs中
			 * s1[i]和s2[j]都不在lcs中
			 */
			return Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
		}
	}
    
    // 备忘录，消除重叠子问题
	int[][] memo;
    public int longestCommonSubsequence2(String text1, String text2) {
    	int m = text1.length(), n = text2.length();
    	
    	// 备忘录值为-1代表未曾计算
    	memo = new int[m][n];
    	for (int[] row : memo) {
			Arrays.fill(row, -1);
		}
    	// 计算s1[0...]和s2[0..]的lcs长度
    	return dp2(text1, 0, text2, 0);
    }
    
    //
    public int dp2(String s1, int i, String s2, int j) {
		if (i == s1.length() || j == s2.length()) {
			return 0;
		}
		// 如果之前计算过，则直接返回备忘录中的答案
		if (memo[i][j] != -1) {
			return memo[i][j];
		}
    	if (s1.charAt(i) == s2.charAt(j)) {
    		// 如果s1[i] = s2[j],那么这个字符串一定在lcs中
    		// 加上s1[i + 1..] 和s2[j+1..]中的lcs长度，就是答案
    		return 1 + dp(s1, i + 1, s2, j + 1);
		} else {
			// 针对不等的情况，s1[i]和s2[j]至少有一个不在lcs中。
			/**
			 * 穷举三种情况：
			 * s1[i]不在lcs中
			 * s2[j]不在lcs中
			 * s1[i]和s2[j]都不在lcs中
			 */
			return Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
		}
	}
    /**
     * 自底向上
     * dp数组定义：dp[i][j] 表示s1的前i个元素与s2的前j个元素的lcs的长度
     * base case：dp[0, j] 和 dp[i, 0]的值为0，即s1前0个元素与...
     * 状态转移方程：
     * dp[i][j]的值为i的左边与j
	 * if(num1[i - 1] = num2[j - 1]) dp[i, j] = dp[i - 1][j - 1] + 1
	 * if(num1[i - 1] != num2[j - 1]) dp[i, j] = max { dp[i][j - 1] dp[i - 1][j]}
     */
    public int longestCommonSubsequence3(String text1, String text2) {
    	int m = text1.length(), n = text2.length();
    	int[][] dp3 = new int[m + 1][n + 1];
    	for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// 现在i和j都从1开始，所以要减1
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp3[i][j] = 1 + dp3[i - 1][j - 1];
				} else {
					dp3[i][j] = Math.max(dp3[i][j - 1], dp3[i - 1][j]);
				}
			}
		}
    	return dp3[m][n];
    }
}
