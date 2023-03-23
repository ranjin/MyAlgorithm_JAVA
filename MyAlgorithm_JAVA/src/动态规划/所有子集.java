package 动态规划;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数数组 nums ，数组中的元素 互不相同，
 * 返回该数组所有可能的子集（幂集）。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]	
 */
public class 所有子集 {
	LinkedList<List<Integer>> res = new LinkedList<>();
	// 回溯
	LinkedList<Integer> track = new LinkedList<>();
	
    public List<List<Integer>> subsets(int[] nums) {
    	backtrack(nums, 0);
    	return res;
    }
    
    public void backtrack(int[] nums, int start) {
    	// 前序位置，每个节点的值都是一个子集
    	res.addLast(new LinkedList<>(track));

    	// 回溯框架
    	for (int i = start; i < nums.length; i++) {
    		
    		track.add(nums[i]);
        	// 做选择
        	
        	// 进入到下一层回溯树
        	backtrack(nums, i + 1);
        	
        	// 撤销选择
        	track.removeLast();
    	}
    }
}
