package 回溯篇.形式1_元素无重不可复选;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 
 * 
 * 
 * 思路：
 * 前面的子集/组合问题使用start保证元素nums[start]之后只会出现nums[start + 1]的元素。
 * 但是排列问题也可以出现之前的。
 * 使用used数组标记已经在路径上的元素避免重复选择，然后收集所有叶子节点的值，即结果。
 */
public class leecode46_全排列 {
	
	List<List<Integer>> res = new LinkedList<>();
	// 记录回溯算法的递归路径
	LinkedList<Integer> track = new LinkedList<>();
	
	// track中的元素会被标记为true
	boolean[] used;
	
    public List<List<Integer>> permute(int[] nums) {
    	used = new boolean[nums.length];
    	backtrack(nums);
    	return res;
    }
    
    
    // 回溯算法核心函数
    public void backtrack(int[] nums) {
		// base case，到达叶子节点
    	if (track.size() == nums.length) {
    		// 收集叶子节点上的值
			res.add(new LinkedList<>(track));
			return;
		}
    	// 回溯算法标准框架
    	for (int i = 0; i < nums.length; i++) {
    		// 已经存在track中的元素，不能重复选择
    		if (used[i] == true) {
				continue;
			}
			// 做选择
    		used[i] = true;
    		track.addLast(nums[i]);
    		
    		// 进入下一层回溯树
    		backtrack(nums);
    		
    		// 取消选择
    		used[i] = false;
    		track.removeLast();
		}
	}
}
