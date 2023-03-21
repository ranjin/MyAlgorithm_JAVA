package 形式2_元素可重不可复选;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class leecode40_组合总和2 {
	
	List<List<Integer>> res = new LinkedList<>();
	
	// 路径
	LinkedList<Integer> track = new LinkedList<>();
	
	// 记录路径和
	int trackSum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    	// 先排序
    	Arrays.sort(candidates);
    	backtrack(candidates, 0, target);
    	return res;
    }
    
    // 回溯算法框架
    public void backtrack(int[] nums, int start, int target) {
    	// base case，达到目标和，找到符合条件的组合
		if (trackSum == target) {
			res.add(new LinkedList<>(track));
			return;
		}
		// base case，超出目标和，直接结束
		if (trackSum > target) {
			return;
		}
		
		// 回溯算法框架
		for (int i = start; i < nums.length; i++) {
			// 剪枝逻辑，值相同的树枝，只遍历第一条
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			// 做选择
			track.addLast(nums[i]);
			trackSum += nums[i];
			
			// 进入下一层回溯树
			backtrack(nums, i + 1, target);
			
			// 撤销选择
			track.removeLast();
			trackSum -= nums[i];
		}
	}
}
