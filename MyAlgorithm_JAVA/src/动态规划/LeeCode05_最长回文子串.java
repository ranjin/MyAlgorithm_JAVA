package 动态规划;
/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 
 * 采取动态规划
 * 状态定义：定义dp[n][n]的二维数组，dp[i][j]表示s[i][j]是否为回文串，存储true、false
 * 初始状态：
 * 状态转移方程：
 * if (j - i + 1 < = 2) {
 * } else {
 * }
 * 如果s[i][j]的长度小于等于2，即j-i+1 <= 2  dp[i][j] == s[i] == s[j]
 * 如果s[i][j]的长度大于2，即j-i+1 > 2, 如果s[i+1][j-1]为回文串且s[i] == s[j],则为回文串
 * 
 * 	b	a	b	a	d
 */
public class LeeCode05_最长回文子串 {
    public String longestPalindrome(String s) {
    	if (s == null) {
			return null;
		}
    	if (s.length() < 2) {
			return s;
		}

    	char[] cs = s.toCharArray();
    	
    	boolean dp[][] = new boolean[cs.length][cs.length];
    	
    	int maxLen = 1;
    	int begin = 0;
    	
    	// i从下到上，j从左到右
    	for (int i = cs.length - 1; i >= 0; i--) {
			for (int j = i; j < cs.length; j++) {
				int len = j - i + 1;
				if (len <= 2) {
					dp[i][j] = cs[i] == cs[j];
				} else {
					dp[i][j] = dp[i+1][j-1] && (cs[i] == cs[j]);
				}
				if (maxLen < len && dp[i][j]) {
					maxLen = len;
					begin = i;
				}
			}
		}
    	return new String(cs, begin, maxLen);
	}
}
















