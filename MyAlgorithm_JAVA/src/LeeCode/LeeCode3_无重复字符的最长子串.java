package LeeCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串s,请你找出其中不含有重复字符的最长子串的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 思路：滑动窗口
 */
public class LeeCode3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
    	int n = s.length();
    	int ans = 0;	// 最长字串长度
    	
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	
    	for (int end = 0, start = 0; end < n; end++) {
    		char alpha = s.charAt(end);	// 右边的字符串
    		
    		if (map.containsKey(alpha)) {
				start = Math.max(map.get(alpha), start);
			}
    		ans = Math.max(ans, end - start + 1);
    		map.put(s.charAt(end), end+1);
    	}
    	return ans;
    }
}
