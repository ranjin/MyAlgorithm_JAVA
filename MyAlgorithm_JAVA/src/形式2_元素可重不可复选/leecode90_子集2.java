package 形式2_元素可重不可复选;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 重点：需要剪枝: 先排序，让相同的元素靠在一起,如果发现nums[i] == nums[i = 1],则跳过
 */
public class leecode90_子集2 {

	List<List<Integer>> res = new LinkedList<>();
	
	// 路径
	LinkedList<Integer> track = new LinkedList<>();
	
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	
    	// 先排序，让相同的元素靠在一起
    	Arrays.sort(nums);
    	backtrack(nums, 0);
    	return res;
    }
    
    public void backtrack(int[] nums, int start) {
		
    	res.add(new LinkedList<>(track));
    	
    	// 回溯框架
    	for (int i = start; i < nums.length; i++) {
			// 剪枝逻辑，值相同的相邻树枝，只遍历第一条
    		if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
    		
    		// 做选择
    		track.addLast(nums[i]);
    		backtrack(nums, i + 1);
    		track.removeLast();
		}
	}
}
