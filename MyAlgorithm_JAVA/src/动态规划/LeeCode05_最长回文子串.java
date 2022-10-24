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
 */
public class LeeCode05_最长回文子串 {
    public String longestPalindrome2(String s) {
    	if (s == null) {
			return null;
		}
    	char[] cs = s.toCharArray();
    	if (cs.length == 0) {
			return s;
		}
    	// 最长回文子串的长度(最少是1)
    	int maxLen = 1;
    	// 最长回文子串的开始索引
    	int begin = 0;
    	boolean[][] dp = new boolean[cs.length][cs.length];
    	//i为列，j为行，i从大到小，那么j >= i
    	// 从下到上(i由大到小)
    	for (int i = cs.length - 1; i >= 0; i--) {
    		// j从左到右(j从小到大)
			for (int j = i; j < cs.length; j++) {
				int len = j - i + 1;
				if (len <= 2) {
					dp[i][j] = (cs[i] == cs[j]);
				} else {
					dp[i][j] = (dp[i+1][j-1] && (cs[i] == cs[j]));
				}
				// 记录最长回文子串的
				if (dp[i][j] && len > maxLen) {
					maxLen = len;
					begin = i;
				}
			}
		}
    	// java提供的API
    	return new String(cs, begin, maxLen);
	}

	/*
	 * babad -> bab 或者aba
	 * 
	 *  cbbd -> bb
	 *  寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串
	 */
	public String longestPalindrome(String s) {
		String res = null;
		int len = s.length();
		if (len < 2) {
			return s;
		}
		for (int i = 0; i < len; i++) {
			//以s[i]为中心的最长回文子串
			String s1 = palindrome(s, i, i);
			
			//以s[i]和s[i+1]为中心的最长回文子串
			String s2 = palindrome(s, i, i+1);
			
			res = res.length() > s1.length() ? res : s1;
			res = res.length() > s2.length() ? res : s2;
		}
		return res;
	}
	
	public void name() {
		
	}
	
	//寻找最长回文串
	public String palindrome(String s, int left, int right) {
		int len = s.length();
		int i = left;
		int j = right;
		while (i >= 0 && j < len) {
			if (s.charAt(i) == s.charAt(j)) {
				i--;
				j++;
			}else {
				break;
			}
		}
		/*
		 * 当s.charAt(i) != s.charAt(j)时跳出while循环。
		 * 因此不能取i，不能取j
		 */
		return s.substring(i+1, j);
	}
}
















