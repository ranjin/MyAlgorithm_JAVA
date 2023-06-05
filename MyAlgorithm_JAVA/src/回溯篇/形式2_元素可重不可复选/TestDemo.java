package 回溯篇.形式2_元素可重不可复选;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * @author ranjin
 *
 */

public class TestDemo {

	List<List<Integer>> res = new LinkedList<>();
	
	LinkedList<Integer> track =  new LinkedList<>();
	
	boolean[] used;
	// 全排列
    public List<List<Integer>> permuteUnique(int[] nums) {
    	used = new boolean[nums.length];
    	// 先排序
    	Arrays.sort(nums);
    	backtrack(nums);
    	
    	return res;
    	
    	
    }
    
    public void backtrack(int[] nums) {
    	
    	if (track.size() == nums.length) {
			res.add(new LinkedList<>(track));
			return;
		}
    	
    	for (int i = 0; i < nums.length; i++) {
    		
    		// 剪枝
    		if (i > 0 && (nums[i] == nums[i - 1]) && !used[i - 1]) {
    			continue;
    		}
    		
    		if (used[i]) {
				continue;
			}
    		
        	// 做选择
        	track.add(nums[i]);
        	used[i] = true;
        	
        	backtrack(nums);
        	
        	track.removeLast();
        	used[i] = false;
		}
    	

    }
}
