package 形式1_元素无重不可复选;

import java.util.LinkedList;

public class 框架代码 {

	/**
	 * 组合/子集问题回溯算法框架
	 */
	LinkedList<Integer> track = new LinkedList<>();
	void backtrack(int[] nums, int start) {
		
		// 回溯框架
		for (int i = start; i < nums.length; i++) {
			// 做选择
			track.addLast(nums[i]);
			
			// 进入到下一层回溯树
			backtrack(nums, i + 1);
			
			// 撤销选择
			track.removeLast();
		}
	}
	
	/**
	 * 排列问题回溯算法框架
	 */
	LinkedList<Integer> track2 = new LinkedList<>();
	boolean[] used;
	void backtrack2(int[] nums) {
		used = new boolean[nums.length];
		// 回溯框架
		for (int i = 0; i < nums.length; i++) {
			
			if (used[i]) {
				continue;
			}
			// 做选择
			used[i] = true;
			track.addLast(nums[i]);
			
			// 进入到下一层回溯树
			backtrack(nums, i);
			
			// 撤销选择
			used[i] = false;
			track.removeLast();
		}
	}
}
