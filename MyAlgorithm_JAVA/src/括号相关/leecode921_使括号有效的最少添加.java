package 括号相关;

import java.util.Stack;

/**
 * 如何做到插入次数最少，让字符串变成有效
 * 输入：s = "())"
 * 输出：1
 * 
 * 输入：s = "((("
 * 输出：3
 */
public class leecode921_使括号有效的最少添加 {

    public int minAddToMakeValid(String s) {

    	Stack<Character> stack = new Stack<Character>();
    	for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				char temp = '(';
				if (stack.isEmpty()) {
					stack.push(c);
				} else {
					if (stack.peek() == temp) {
						stack.pop();
					} else {
						stack.push(c);
					}	
				}
			}
		}
    	return stack.size();
    }
}
