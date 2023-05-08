package 单调队列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
	
	// 单调递增队列： 使用双向链表
	// 队头 --->  队尾  往队尾添加元素，保持单调递增
	public class monotonicQueue {
		
		LinkedList<Integer> maxq = new LinkedList<>();
		
		// 
		public void push(int n) {
			while (!maxq.isEmpty() && maxq.getLast() < n) {
				maxq.pollLast();
			}
			maxq.addLast(n);
		}
		
		
		public int max() {
			return maxq.getFirst();
		}
		
		// 出队：删除的队头元素
		public void pop(int n) {
			// 判断
			if (maxq.getFirst() == n) {
				maxq.pollFirst();
			}
		}
	}
    public int[] maxSlidingWindow(int[] nums, int k) {
    	monotonicQueue window = new monotonicQueue();
    	List<Integer> res = new ArrayList<>();
    	for (int i = 0; i < nums.length; i++) {
			if (i < k - 1) {
				window.push(nums[i]);
			} else {
				window.push(nums[i]);
				res.add(window.max());
				window.pop(nums[i + 1 - k]);
			}
		}
    	
    	int[] arr = new int[res.size()];
    	for (int i = 0; i < arr.length; i++) {
			arr[i] = res.get(i);
		}
    	return arr;
    }
}
