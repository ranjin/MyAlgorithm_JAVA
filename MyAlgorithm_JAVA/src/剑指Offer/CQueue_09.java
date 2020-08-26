package 剑指Offer;

import java.util.Stack;

/*
 * 剑指Offer09:	用两个栈实现队列
 */
public class CQueue_09 {

	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public CQueue_09(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	
	//添加元素
	public void appendTail(int value) {
		//直接放入stack2中
		stack1.push(value);
	}
	
	//删除元素 在stack2有元素的时候可以直接pop操作 实现队列的先进先出
	public int deleteHead() {
		int deleteItem;
		if (stack2.empty()) {
			while (!stack2.empty()) {
				int item = stack2.peek();
				stack1.push(item);
				stack2.pop();
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
