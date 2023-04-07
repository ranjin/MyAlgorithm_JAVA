package 形式3_元素无重可复选;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 
 * 思路：
 * 与不可复选时的框架内的条件相比，在于i的取值。
 */
public class leecode39_组合总和 {

	List<List<Integer>> res = new LinkedList<>();
	
	// 记录回溯的路径
	LinkedList<Integer> track = new LinkedList<>();
	
	// 记录track中的路径和
	int trackSum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	backtrack(candidates, 0, target);
    	return res;
    }
    
    public void backtrack(int[] nums, int start, int target) {
    	// base case，找到目标和，记录结果
		if (trackSum == target) {
			res.add(new LinkedList<>(track));
			return;
		}
		// base case,超出目标和，停止向下遍历
		if (trackSum > target) {
			return;
		}
		// 回溯算法框架
		for (int i = start; i < nums.length; i++) {
			// 做选择
			trackSum += nums[i];
			track.addLast(nums[i]);
			// 下一层回溯树
			backtrack(nums, i, target);
			// 取消选择
			trackSum -= nums[i];
			track.removeLast();
		}
	}
}
