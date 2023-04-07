package 形式1_元素无重不可复选;

import java.util.LinkedList;

/**
 * 
 	result = []
	void backtrack(路径, 选择列表){
		if (满足结束条件) {
			result.add(路径)
			return
		}

		// 核心是for循环里面的递归，在递归之前做选择，递归之后撤销选择
		for (选择 in 选择列表) {
			做选择
			backtrack(路径, 选择列表)
			撤销选择
		}
	}
 */
public class 框架代码 {

	/**
	 * 组合/子集问题回溯算法框架
	 * 
	 * 子集：
 	 * 按照顺序来，比如[1, 3]与[3, 1]就相当于重复了

	 * 把根节点作为第0层，将每个节点与根节点之间树枝上的元素作为该节点的值，
	 * 那么第n层的所有节点就是大小为n的所有子集。
	 * 那么树上每一层的节点相加，就是所有的子集。
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
