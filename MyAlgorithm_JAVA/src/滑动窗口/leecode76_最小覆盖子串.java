package 滑动窗口;

import java.util.HashMap;

/**
 * 给你一个字符串 s 、一个字符串 t 。
 * 返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 *
 */
public class leecode76_最小覆盖子串 {

    public static String minWindow(String s, String t) {
    	// 哈希表初始化
    	HashMap<Character, Integer> need = new HashMap<>();
    	
    	HashMap<Character, Integer> window = new HashMap<>();

    	// 统计t中字符出现次数
    	for (char c: t.toCharArray()) {
    		need.put(c, need.getOrDefault(c, 0) + 1);
    	}
    	
    	int left = 0, right = 0;
    	int valid = 0;	// 表示窗口中满足need条件的字符个数
    	
    	// 记录最小覆盖子串的起始索引及长度
    	int start = 0, len = Integer.MAX_VALUE;
    	
    	while (right < s.length()) {
			// c是将移入窗口的字符
    		char c = s.charAt(right);
    		
    		//扩大窗口
    		right++;
    		
    		// 进行窗口内数据的一系列更新 如果遇到了重复字符，valid不需要加1.
    		if (need.containsKey(c)) {
    			window.put(c, window.getOrDefault(c, 0) + 1);
    			// 两者的出现次数一致时，才能满足条件，valid才能+1
    			if (window.get(c).equals(need.get(c))) {
    				valid++;
    			}
    		}
    		// 如果valid的长度到达预期，收缩窗口
    		while (valid == need.size()) {
				// 更新最小覆盖子串
    			if (right - left < len) {
					start = left;
					len = right - left;
				}
    			// d是将移出窗口的字符
    			char d = s.charAt(left);
    			left++;
    			
    			// 进行窗口内数据的一系列更新
    			if (need.containsKey(d)) {
    				if (window.get(d).equals(need.get(d))) {
    					valid--;
    					window.put(d, window.get(d) - 1);
    				}
    			}
			}
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ssString = minWindow("ADOBECODEBANC", "ABC");
	}

}
