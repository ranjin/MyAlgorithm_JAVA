package LeeCode;

public class LeeCode05_最长回文子串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
















