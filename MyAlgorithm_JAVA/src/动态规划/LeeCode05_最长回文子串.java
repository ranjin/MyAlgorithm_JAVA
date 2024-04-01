package 动态规划;

/**
 * 不使用动态规划
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class LeeCode05_最长回文子串 {	
    public String longestPalindrome(String s) {
		String result = "";
		if (s.length() == 0) {
			return result;
		}

		for (int i = 0; i < s.length(); i++) {
			String s1 = palindrome(s, i, i);
			String s2 = palindrome(s, i, i + 1);
			result = result.length() > s1.length() ? result : s1;
			result = result.length() > s2.length() ? result : s2;
		}
		return result;
	}

	// 寻找以s[l]与s[r]为中点的最长回文子串
	public String palindrome(String s, int l, int r) {
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			// 双指针，向两边展开
			l--;
			r++;
		}
		return s.substring(l+1, r);
	}
}
