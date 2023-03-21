package 形式2_元素可重不可复选;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * 
 * 思路：对比简单的全排列,多了1:排序，2:剪枝
 */
public class leecode47_全排列2 {
	
	List<List<Integer>> res = new LinkedList<>();
	
	// 路径
	LinkedList<Integer> track = new LinkedList<>();
	
	// 
	
	boolean[] used;
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	used = new boolean[nums.length];
    	Arrays.sort(nums);
    	backtrack(nums);
    	return res;
    }
    
    public void backtrack(int[] nums) {
		
    	if (track.size() == nums.length) {
			res.add(new LinkedList<>(track));
			return;
		}
    	
    	// 回溯框架
    	for (int i = 0; i < nums.length; i++) {
    		// 
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			
			if (used[i]) {
				continue;
			}
			// 做选择
			used[i] = true;
			track.addLast(nums[i]);
			// 进入下一层回溯树
			backtrack(nums);
			used[i] = false;
			track.removeLast();
			// 取消选
		}
	}
}
