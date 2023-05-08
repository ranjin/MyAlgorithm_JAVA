package 单调队列;

import java.util.ArrayList;
import java.util.List;

import 单调队列.总结.MonotonicQueue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 
 * 输入：nums = [1], k = 1
 * 输出：[1]
 */
public class leecode239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	List<Integer> res = new ArrayList<>();
    	MonotonicQueue window = new MonotonicQueue();
    	for (int i = 0; i < nums.length; i++) {
			if(i < k - 1) {
				// 先把窗口的k - 1个元素填满
				window.push(nums[i]);
			} else {
				// 窗口开始向前滑动
				// 移入新元素
				window.push(nums[i]);
				
				// 将当前窗口中的最大元素计入结果
				res.add(window.max());
				
				// 移出最后的元素
				window.pop(nums[i + 1 - k]);
			}
		}
    	// 将list类型转化成int[]数组作为返回值
    	int[] arr = new int[res.size()];
    	for (int i = 0; i < res.size(); i++) {
			arr[i] = res.get(i);
		}
    	return arr;
    }
}
