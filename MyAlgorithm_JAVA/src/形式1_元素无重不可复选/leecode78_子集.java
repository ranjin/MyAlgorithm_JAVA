package 形式1_元素无重不可复选;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组nums，数组中的元素互不相同。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 
 * 子集：如果集合A的任意一个元素都是集合B的元素，那么集合A称为集合B的子集。
 * 
 * 
 */
public class leecode78_子集 {
	/**
	 * 整理思路：
	 * 1. 使用start控制树枝的生长避免产生重复的子集；
	 * 2. 用track记录根节点到每个节点的路径的值；
	 * 3. 在前序位置把每个节点的路径值收集起来，完成回溯树的遍历。
	 */
	List<List<Integer>> res = new LinkedList<>();
	// 记录回溯算法的递归路径
	LinkedList<Integer> track = new LinkedList<>();
	
	// 主函数
    public List<List<Integer>> subsets(int[] nums) {
    	backtrack(nums, 0);
    	return res;
    }
    
    // 回溯算法核心函数，遍历子集问题的回溯树
    public void backtrack(int[] nums, int start) {
		// 前序位置，每个节点的值都是一个子集
    	res.add(new LinkedList<>(track));
    	
    	// 回溯算法标准框架
    	for (int i = start; i < nums.length; i++) {
			// 做选择
    		track.addLast(nums[i]);
    		
    		// 通过start参数控制树枝的遍历，避免产生重复的子集
    		backtrack(nums, i + 1);
    		
    		// 撤销选择
    		track.removeLast();
		}
	}
}




















