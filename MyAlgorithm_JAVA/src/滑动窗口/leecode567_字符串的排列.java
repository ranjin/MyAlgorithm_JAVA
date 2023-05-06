package 滑动窗口;

import java.util.HashMap;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 * 如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class leecode567_字符串的排列 {

	public boolean checkInclusion(String t, String s) {
		// 滑动窗口
		// 两个哈希表初始化
		HashMap<Character, Integer> need = new HashMap<>();
		HashMap<Character, Integer> window = new HashMap<>();

		for (char c : t.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}
		
		// 指针初始化
		int left = 0, right = 0, valid = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			right++;
			if (need.containsKey(c)) {
				window.put(c, window.getOrDefault(c, 0) + 1);
				if(need.get(c).equals(window.get(c))) {
					valid++;
				}
			}
			
			// 判断左侧窗口是否需要收缩
			while (right - left >= t.length()) {
				// 在这里判断是否找到了合适的子串
				if (valid == need.size()) {
					return true;
				}
				char d = s.charAt(left);
				left++;
				if (need.containsKey(d)) {
					if (need.get(d).equals(window.get(d))) {
						valid--;
					}
					window.put(d, window.getOrDefault(d, 0) - 1);
				}
			}
		}
		// 未找到符合条件的子串
		return false;
	}
}
