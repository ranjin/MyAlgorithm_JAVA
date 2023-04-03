package 动态规划;

/**
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 *
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * 
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 */
public class leecode583_两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {

    	int m = word1.length(), n = word2.length();
    	
    	
    	int lcs = getLCS(word1, word2);
    	return (m - lcs) + (n - lcs);
    }
    
    
    // 最长公共子序列 自底向上
    // base case, dp数组
    public int getLCS(String s1, String s2) {
    	int m = s1.length(), n = s2.length();
    	if (m == 0 || n == 0) {
			return 0;
		}
    	// dp[i][j]为s1的前i个元素与s2的前j个元素LCS的最大长度
    	int[][] dp = new int[m + 1][n + 1];
    	for (int i = 1; i <= m + 1; i++) {
			for (int j = 1; j <= n + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
    	return dp[m][n];
	}
}
