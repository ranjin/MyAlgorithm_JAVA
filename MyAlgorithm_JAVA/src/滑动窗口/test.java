package 滑动窗口;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class test {

    public int[] maxSlidingWindow(int[] nums, int k) {
    	List<Integer> res = new ArrayList<>();
    	
    	monctonicQueue queue = new monctonicQueue();
    	
    	// 前k - 1个元素入队列
    	int n = nums.length;
    	for (int i = 0; i < n; i++) {
			if (i < k - 1) {
				queue.push(nums[i]);
			} else {
				queue.push(nums[i]);
				res.add(queue.max());
				queue.pop(nums[i + 1 - k]);
			}
		}
    	
    	int[] result = new int[res.size()];
    	for (int i = 0; i < res.size(); i++) {
    		result[i] = res.get(i);
		}
    	return result;
    }
    
    // 单调队列 在表尾添加元素
    public class monctonicQueue{
    	LinkedList<Integer> list = new LinkedList<>();
    	public int max() {
    		return list.getFirst();
    	}
    	
    	// push的时候，
    	public void push(int n) {
    		while (!list.isEmpty() && list.getLast() < n) {
				list.pollLast();
			}
    		list.addLast(n);
    	}
    	
    	// 删除表头元素
    	public void pop(int n) {
    		if (n == list.getFirst()) {
    			list.pollFirst();
    		}
    	}
    }
}
