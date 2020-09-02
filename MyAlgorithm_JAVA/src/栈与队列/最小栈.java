package 栈与队列;

import java.util.Stack;

/*
 * 输入：
	["MinStack","push","push","push","getMin","pop","top","getMin"]
	[[],[-2],[0],[-3],[],[],[],[]]
	
	输出：
	[null,null,null,null,-3,null,0,-2]
	
	解释：
	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	minStack.getMin();   --> 返回 -3.
	minStack.pop();
	minStack.top();      --> 返回 0.
	minStack.getMin();   --> 返回 -2.
	
	考虑借助与辅助栈存放最小元素
 */
public class 最小栈 {

	//主栈
	Stack<Integer> mainStack = new Stack<Integer>();
	
	//辅助栈
	Stack<Integer> helpStack = new Stack<Integer>();
	
	//元素入栈
	public void push(int x) {
		//主栈存放元素
		mainStack.push(x);
		
		//辅助栈存放元素
		if (helpStack.isEmpty() || x <= helpStack.peek()) {
			helpStack.add(x);
		}
	}
	
	//删除栈顶元素
	public void pop() {
		if (mainStack.isEmpty()) {
			return;
		}
		int mainItem = mainStack.peek();
		if (!helpStack.isEmpty()) {
			int item = helpStack.peek();
			if (item == mainItem) {
				helpStack.pop();
			}
		}
		mainStack.pop();
	}
	
	//获取栈顶元素
	public int top() {
		if (mainStack.isEmpty()) {
			return -1;
		}
		return mainStack.peek();
	}
	
	//检索栈中的最小元素
	public int getMin() {
		if (helpStack.isEmpty()) {
			return -1;
		}
		return helpStack.peek();
	}
}






















