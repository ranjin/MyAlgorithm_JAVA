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

    	// 初始化window和need两个哈希表，记录窗口中的字符和需要凑齐的字符
    	HashMap<Character, Integer> need = new HashMap<>();
    	HashMap<Character, Integer> window = new HashMap<>();

    	for (char c: t.toCharArray()) {
    		need.put(c, need.getOrDefault(c, 0) + 1);
    	}
    	
    	int left = 0, right = 0;
    	int valid = 0;
    	// 记录最小覆盖子串的起始索引及长度
    	int start = 0, len = Integer.MAX_VALUE;
    	
    	while (right < s.length()) {
			// c是将移入窗口的字符
    		char c = s.charAt(right);
    		// 右移窗口
    		right++;
    		
    		// 进行窗口内数据的一系列更新
    		if (need.containsKey(c)) {
    			window.put(c, window.getOrDefault(c, 0) + 1);
    			if (window.get(c).equals(need.get(c))) {
    				valid++;
    			} 
    		}
    		
    		// 判断左侧窗口是否要收缩
    		while (valid == need.size()) {
				// 在这里更新最小覆盖子串
//    			if ()
			}
		}
    	System.out.println(need);
    	return "";
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ssString = minWindow("ADOBECODEBANC", "ABC");
	}

}
