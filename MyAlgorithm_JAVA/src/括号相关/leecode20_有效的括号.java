package 括号相关;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 输入：s = "()"
 * 输出：true
 * 
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 输入：s = "(]"
 * 输出：false
 */
public class leecode20_有效的括号 {

    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
    	
//    	"( [ } } ] )"
    	char[] charArr = s.toCharArray();
    	if (charArr.length % 2 > 0) {
			return false;
		}
    	for (char c : charArr) {
			if (c == '(' || c == '{' || c == '[') {
				stack.add(c);
				continue;
			}
			
			if (c == ')' || c == '}' || c == ']') {
				char temp = ' ';
				if (c == ')') {
					temp = '(';
				} else if (c == '}') {
					temp = '{';
				} else if (c == ']') {
					temp = '[';
				}
				if (!stack.isEmpty()) {
					char inchar = stack.peek();
					if (temp == inchar) {
						stack.pop();
					} else {
						return false;
					}
				} else {
					return false;
				}
			}			
		}
    	
    	return stack.isEmpty();
    }
}
