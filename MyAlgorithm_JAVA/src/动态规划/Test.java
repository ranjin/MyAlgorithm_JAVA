package 动态规划;

import java.util.Stack;

public class Test {

	
    public boolean isValid(String s) {
    	
    	Stack<Character> stack = new Stack<Character>();
    	
    	char[] charArr = s.toCharArray();
    	
    	if (charArr.length % 2 > 0) {
			return false;
		}
    	
    	for (char c : charArr) {
			if (c == '(' || c == '{'  || c == '[') {
				stack.add(c);
				continue;
			}
			
			if (c == ')' || c == '}'  || c == ']') {
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
				}
			}

		}
    	return stack.isEmpty();
    }
}
