package 滑动窗口;

public class 滑动窗口框架 {

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
