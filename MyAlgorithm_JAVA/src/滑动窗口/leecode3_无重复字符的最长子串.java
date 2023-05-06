package 滑动窗口;

import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcdacbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 */
public class leecode3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {    	
    	// 最终返回的是window的长度
    	HashMap<Character, Integer> window = new HashMap<>();

    	int left = 0, right = 0, res = 0;
    	
    	// 
    	while (right < s.length()) {
    		char c = s.charAt(right);
    		right++;
    		// 进行窗口内数据的一系列更新
    		window.put(c, window.getOrDefault(c, 0) + 1);
    		
    		// 判断左侧窗口是否要收缩
    		while (window.get(c) > 1) {
				char d = s.charAt(left);
				left++;
				// 进行窗口内数据的一系列更新
				window.put(d, window.get(d) - 1);
			}
    		// 更新答案
    		res = Math.max(res, right - left);
		}
    	return res;
    }
}
