package 剑指Offer;

import java.util.Stack;

public class 面试题22_栈的压入与弹出序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * pushed序列：1 -> 2 -> 3 -> 4 -> 5
	 * 
	 * popped序列：4 -> 5 -> 3 -> 2 -> 1
	 * 
	 * 如果popped序列中的元素等于
	 */
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		for (Integer num : pushed) {
			stack.push(num);
			while (!stack.empty() && stack.peek() == popped[i]) {
				stack.pop();
				i++;
			}
		}
		return stack.empty();
	}

}
















