package 查找和排序;

import java.util.Iterator;
import java.util.Stack;

public class SortTest {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
	}

    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<Character>();
    	char[] ss = s.toCharArray();
    	
    	for (char c : ss) {
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
			} else {
				if (!stack.isEmpty() && leftOfChar(c) == stack.peek()) {
					stack.pop();
				} else {
					return false;
				}
			}

		}
    	return stack.isEmpty();
    }
    
    public static char leftOfChar(char c) {
		if (c == '}') {
			return '{';
		} else if (c == ']') {
			return '[';
		}
		return '(';
	}
}
