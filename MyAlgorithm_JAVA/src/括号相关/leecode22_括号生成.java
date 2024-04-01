package 括号相关;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数n，返回所有有效的括号组合
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 输入：n = 1
 * 输出：["()"]
 */
public class leecode22_括号生成 {

	/**
	 * 对于括号合法性的判断，主要是借助栈这种数据结构。
	 * 而对于括号的生成，一般都要利用回溯递归的思想
	 * 
	 * 这题可以换成：现在有2n个位置，每个位置可以放置字符'('或者')', 组成的所有括号组合中。有多少个是合法的?
	 
	 */
	public List<String> generateParenthesis(int n) {
		if (n == 0) {
			return new ArrayList<String>();
		}
		// 记录所有合法的括号组合
		List<String> res = new ArrayList<String>();
		// 回溯过程中的路径
		StringBuilder track = new StringBuilder();
		// 可用的做括号和右括号数量初始化为n
		backtrack(n, n, track, res);
		return res;
	}
	
	// 可用的左括号数量为left个，可用的右括号数量为right个
	public void backtrack(int left, int right, StringBuilder track, List<String> res) {
		// 若左括号剩下的多，说明不合法
		if (right < left) {
			return;
		}
		// 数量小于0肯定是不合法的
		if (left < 0 || right < 0) {
			return;
		}
		// 当所有括号都恰好用完时，得到一个合法的括号组合
		
		if (left == 0 && right == 0) {
			res.add(track.toString());
			return;
		}
		// 尝试放一个左括号
		track.append('('); // 做选择
		backtrack(left - 1, right, track, res);
		track.deleteCharAt(track.length() - 1); // 撤销选择
		
		// 尝试放一个右括号
		track.append(')'); // 做选择
		backtrack(left - 1, right, track, res);
		track.deleteCharAt(track.length() - 1); // 撤销选择
	}
}












