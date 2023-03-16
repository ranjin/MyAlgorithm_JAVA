package 剑指Offer;

import java.util.Stack;

/*
 * 剑指Offer09:	用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成:
 * 在队列尾部插入整数
 * 在队列头部删除整数
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 * 
 * 思考：
 * Stack1为队尾，Stack2为队头
 * 容量为5.
 * 
 * 删除时：
 * 如果Stack2为空，则将Stack1逐个添加到Stack2中，Stack出栈
 * 如果Stack2不为空，直接Stack2出栈
 */

public class 用两个栈实现队列 {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public 用两个栈实现队列(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	/**
	 * 队列：先进先出
	 * @param value
	 */
	
	//添加元素
	public void appendTail(int value) {
		//直接放入stack1中
		stack1.push(value);
	}
	
	//删除元素 在stack2有元素的时候可以直接pop操作 实现队列的先进先出
	public int deleteHead() {
		int deleteItem;
		if (stack2.empty()) {
			while (!stack1.empty()) {
				int item = stack1.peek();	//peek获取栈顶元素
				stack2.push(item);
				stack1.pop();	// stack1需要出栈
			}
		}
		if (stack2.empty()) {
			return -1;
		}
		deleteItem = stack2.peek();
		stack2.pop();
		return deleteItem;
	}
	
	public static void main(String[] args) {
		
	}

}
