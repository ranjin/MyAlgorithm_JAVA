package 滑动窗口;

import java.awt.Window;

public class 滑动窗口框架 {

	// 大致逻辑 时间复杂度：O(N)
	public void logic_01() {
		int left = 0, right = 0;
		while (left < right && right < s.size()) {
			// 增大窗口
			window.add(s[right]);
			right++;
			while (Window needs shrink) {
				// 缩小窗口
				Window.remove(s[left]);
				left++;
			}
		}
	}
	
	/**
	 * 滑动窗口算法的思路：
	 * 1. 在S(source)中使用双指针技巧，初始化left = right = 0, 把索引左闭右开区间称为一个窗口
	 * 2. 先不断的增加right指针扩大窗口, 直到窗口中的字符串符合要求(包含T中的所有字符)
	 * 3. 停止增加right, 转而不断增加left指针缩小窗口。直到窗口中的字符串不再符合要求。
	 * 4. 同时，每次增加left，我们都要更新
	 * @param t
	 */

	/* 滑动窗口算法框架 */
	
	void slidingWindow(string s, String t) {
		unordered_map<char, int> need, window;
		for (char c : t) {
			need[c]++;
		}
		int left = 0, right = 0, valid = 0;
		while (right < s.size()) {
			// c是将移入窗口的字符
			char c = s[right];
			// 增大窗口
			right++;
			// 进行窗口内数据的一系列更新
			...
			
			// 判断左侧窗口是否需要收缩
			while (window needs shrink) {
				// d是将移出窗口的字符
				char d = s[left];
				// 缩小窗口
				left++;
				// 进行窗口内数据的一系列更新
				...
			}
		}
	}
}
