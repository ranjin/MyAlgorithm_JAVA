package 回溯篇.形式1_元素无重不可复选;
import java.util.LinkedList;
import java.util.List;

public class 测试代码 {

	// 结果集
	List<List<Integer>> res = new LinkedList<>();
	
	// 路径
	LinkedList<Integer> track = new LinkedList<>();
	
    public List<List<Integer>> subsets(int[] nums) {
    	backtrack(nums, 0);
    	return res;
    }
    
    
    public void backtrack(int[] nums, int start) {
    	
    	// 前序位置
    	res.add(new LinkedList<>(track));
    	
    	for (int i = start; i < nums.length; i++) {
			
        	// 做选择
    		track.add(nums[i]);
    		
    		backtrack(nums, i + 1);
    		
    		track.removeLast();
		}
    }
}
