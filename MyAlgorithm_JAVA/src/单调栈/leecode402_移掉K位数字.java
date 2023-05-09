package 单调栈;

import java.util.Stack;

/**
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 */
public class leecode402_移掉K位数字 {


	/**
	 * 思路：
	 * 1. 通过单调栈技巧可以得到一个单调递增的字符栈.比如1432219最终能得到 129.
	 * 2. 如果此时k > 0, 删除末尾元素,即继续出栈
	 */
    public String removeKdigits(String num, int k) {
    	// 先获取到单调递增栈
    	Stack<Character> s = new Stack<>();
    	
    	for (Character c : num.toCharArray()) {
			
    		while (!s.isEmpty() && c < s.peek() && k > 0) {
				s.pop();
				k--;
			}
    		// 防止0作为数字的开头
    		if (s.isEmpty() && c == '0') {
    			continue;
    		}
    		s.push(c);
		}
    	
    	while (k > 0 && !s.isEmpty()) {
			s.pop();
			k--;
		}
    	// 若最后没剩下数字，就是0
    	if (s.isEmpty()) {
    		return  "0";
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	while (!s.isEmpty()) {
			sb.append(s.pop());
		}
    	return sb.reverse().toString();
    }
}
