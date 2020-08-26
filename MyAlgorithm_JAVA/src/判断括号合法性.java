import java.util.Stack;

public class 判断括号合法性 {

	/*
	 * {}[]()
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ssString = "{[()]}[]()";
		System.out.println(isValid(ssString));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{' || c == '[' || c == '(') {
				stack.push(c);
			}else if (!stack.empty() && leftOf(c) == stack.peek()) {
				stack.pop();
			}
		}
		return stack.isEmpty();
		
	}
	public static char leftOf(char s) {
		if (s == '}') {
			return '{';
		}else if (s == ']') {
			return '[';
		}else if (s == ')'){
			return '(';
		}
		return ' ';
	}
}
