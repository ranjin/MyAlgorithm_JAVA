package 滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 */
public class leecode438_找所有字母异位词 {

	// 滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
    	
    	// 记录结果
    	List<Integer> res = new ArrayList<>();
    	HashMap<Character, Integer> needs = new HashMap<>();
    	HashMap<Character, Integer> window = new HashMap<>();

    	// need中添加
    	for (char c : p.toCharArray()) {
    		needs.put(c, needs.getOrDefault(c, 0) + 1);
    	}
    	
    	int left = 0, right = 0, valid = 0;
    	
    	while (right < s.length()) {
			char c = s.charAt(right);
			right++;
			// 进行窗口内数据的一系列更新
			if (needs.containsKey(c)) {
				window.put(c, window.getOrDefault(c, 0) + 1);
				if (needs.get(c).equals(window.get(c))) {
					valid++;
				}
			}
			// 判断左侧窗口是否需要收缩
			while (right - left >= p.length()) {
				if (valid == needs.size()) {
					res.add(left);
				}
				char d = s.charAt(left);
				left++;
				// 进行窗口内数据的一系列更新
				if (needs.containsKey(d)) {
					if (needs.get(d).equals(window.get(d))) {
						valid--;
					}
					window.put(d, window.getOrDefault(d, 0) - 1);
				}
			}
		}
    	return res;
    }
}
