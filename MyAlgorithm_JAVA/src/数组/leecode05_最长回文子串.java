package 数组;
/**
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 思路：
 * 回文串的长度可能是奇数，也可能是偶数。
 * 技巧：从中心向两端扩散
 */

public class leecode05_最长回文子串 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以s[i]为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以s[i]和s[i+1]为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    // 在s中寻找以s[l]和s[r]为中心的最长回文串
    // "abba" l = 1 r = 2  l = 0 r = 3
    public String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--;
            r++;
        }
        // 返回以s[l]和s[r]为中心的最长回文串 substring(begin, end)包含begin，不包括end, whil中已经--了
        return s.substring(l + 1, r);
    }
}