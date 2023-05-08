package 动态规划;

/**
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 * 请你返回让 s 成为回文串的 最少操作次数 。
 * 「回文串」是正读和反读都相同的字符串。
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 * 
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 
 * 
 * 整理思路：
 * 1. 先求出最长回文子序列的长度。
 * 2. 字符串的长度 - 1求出的长度，即为结果,即我们需要插入的字符。
 *
 */
public class leecode1312_让字符串成为回文串的最少插入次数 {
	// 最长回文子序列: 不等的时候插入字符使其相等
    public int minInsertions(String s) {
    	int n = s.length();
    	// dp初始化为0
    	int[][] dp = new int[n][n];
    	
    	for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
    	for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i - 1][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j]);
				}
			}
		}
    	return s.length() - dp[0][n - 1];	
    }
}
