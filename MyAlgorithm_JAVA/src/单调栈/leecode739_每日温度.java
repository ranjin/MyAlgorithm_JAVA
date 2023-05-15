package 单调栈;

import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 
 * 输入: temperatures = [30,40,50,60]
 * [40, 50, 60, -1]
 * 输出: [1,1,1,0]
 *
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 */
public class leecode739_每日温度 {

	// 单调栈
    public int[] dailyTemperatures(int[] temperatures) {
    	int n = temperatures.length;
    	int[] res = new int[n];
    	
    	// 栈存放的元素索引, 而不是元素
    	Stack<Integer> s = new Stack<>();
    	for (int i = n - 1; i >= 0 ; i--) {
			while (!s.isEmpty() && temperatures[i] >= temperatures[s.peek()]) {
				s.pop();
			}
			
			res[i] = s.isEmpty() ? 0 : s.peek() - i;
			// 将索引入栈, 而不是元素
			s.push(i);
		}    	
    	return res;
    }
}
