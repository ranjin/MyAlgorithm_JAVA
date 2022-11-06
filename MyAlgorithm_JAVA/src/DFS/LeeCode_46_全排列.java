package DFS;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 */
public class LeeCode_46_全排列 {
	// 全排列数组
	List<List<Integer>> res = new LinkedList<>();
	// 主函数，输入一组不重复的数字，返回它们的全排列
    public List<List<Integer>> permute(int[] nums) {
    	if (nums == null) {
			return null;
		}
    	// 记录路径
    	LinkedList<Integer> track = new LinkedList<>();
  
    	backtrack(nums, track);
    	return res;
    }
    
    // 回溯: 结束条件 + 做选择 + 撤销选择
    public void backtrack(int[] nums, LinkedList<Integer> track) {
    	
    	if (nums.length == 0 || nums == null) {
			return;
		}
    	// 触发结束条件
    	if (track.size() == nums.length) {
			res.add(new LinkedList<Integer>(track));
			return;
		}
    	for (int i = 0; i < nums.length; i++) {
    		if (track.contains(nums[i])) {
				continue;
			}
    		// 做选择
    		track.add(nums[i]);
    		
    		// 进入下一层决策树
    		backtrack(nums, track);
    		
    		// 撤销选择
    		track.removeLast();
		}
	}
}









