package 动态规划;
/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，
 * 删除某些字符或者不删除任何字符形成的一个序列。
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 */
// i    i+1   j-1    j 
// c     b     b     d
public class leecode516_最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        
        // dp定义：dp[i][j]表示子串s[i...j]的最长回文子序列的长度。
        // base case: i == j时，dp[i][j]为1
        // 状态转移方程：
        // dp数组全部初始化为0
        int[][] dp = new int[n][n];

        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 反着遍历保证正确的状态转移：如果i > j，不存在什么子序列，dp[i][j]为0.
        // 反着遍历，可以保证前面的值都是已知的0.
        for (int i = n - 1; i >=0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                	// 不相等的情况，比较原来两边分别扩大的情况
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // 
        return dp[0][n - 1];
    }
}