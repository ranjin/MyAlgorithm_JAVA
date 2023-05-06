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
	 * 4. 同时，每次增加left，我们都要更新一轮结果。
	 * 5. 重复步骤2与步骤3。直到right到达字符串S的尽头。
	 * 6. 步骤2相当于在寻找一个[可行解]，步骤3在优化可行解，最终找到最优解
	 * need和window相当于计数器。分别记录T中字符出现次数和窗口中的相应字符的出现次数。
	 */

	/* 滑动窗口算法框架 
	 * 两个哈希表记录：
	 * need: target中的字符及其出现次数
	 * window: 实时窗口中的字符
	 * left和right变量初始化窗口的两端，[left, right)左闭右开区间，所以初始情况下窗口不包含任何元素。
	 * valid变量表示窗口中满足need条件的字符个数。如果valid和need.size的大小相同。则说明窗口已满足条件。
	 * 已经完全覆盖了子串T。
	 * 
	 * 核心思路：
	 * 如果一个字符进入窗口，应该增加window计数器；
	 * 如果一个字符将移出窗口，应该减少window计数器；
	 * 当valid满足need时应该收缩窗口；
	 * 在收缩窗口的时候更新最终结果；
	 * 
	 * 比较难理解的点：
	 * valid主要是与need中字符长度比较，所以前提条件必须是次数一致
	 * 
	 * 需要思考：
	 * 1、什么时候应该扩大窗口？
	 * 2、什么时候应该缩小窗口？
	 * 3、什么时候应该更新答案？
	 * 
	*/
	
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
