package 剑指Offer;

import java.util.Stack;

public class 包含min函数的栈 {

	//声明主stack和辅助stack
	static Stack<Integer> mainStack;
	static Stack<Integer> assistStack;
	static int minValue;
	public static void main(String[] args) {
		mainStack = new Stack<Integer>();
		assistStack = new Stack<Integer>();
		minValue = -1;
		MinStack();
	}
	
	public static void MinStack() {
		push(-2);
//		System.out.println(mainStack);
//		System.out.println(assistStack);
//		System.out.println(minValue);
//		
		push(0);
//		System.out.println(mainStack);
//		System.out.println(assistStack);
//		System.out.println(minValue);
		
		push(-3);
//		System.out.println(mainStack);
//		System.out.println(assistStack);
//		System.out.println(minValue);
		
		System.out.println(min());
		pop();
		System.out.println(top());
		
		System.out.println(min());

	}
	
	public static void push(int value) {
		if (mainStack.empty()) {
			minValue = value;
		}
		mainStack.push(value);
		//设置最小值
		if (value < minValue) {
			minValue = value;
		}
		assistStack.push(minValue);
	}
	
	public static void pop() {
		mainStack.pop();
		assistStack.pop();
		if (!assistStack.empty()) {
			minValue = assistStack.peek();
		}
	}
	
	public static int top() {
		return mainStack.peek();
	}
	
	public static int min() {
		int item = assistStack.peek();
		return item;
	}

}
