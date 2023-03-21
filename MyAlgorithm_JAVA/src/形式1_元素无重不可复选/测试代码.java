package 形式1_元素无重不可复选;
import java.util.LinkedList;
import java.util.List;

public class 测试代码 {
	List<List<Integer>> res = new LinkedList<>();
	
	// 路径
	LinkedList<Integer> track = new LinkedList<>();
	
	// 
	boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
    	used = new boolean[nums.length];
    	backtrack(nums);
    	return res;
    }
    
    public void backtrack(int[] nums) {
    	
		if (track.size() == nums.length) {
			res.add(new LinkedList<>(track));
		}
		
		// 回溯算法框架
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			
			used[i] = true;
			// 做选择
			track.addLast(nums[i]);
			
			// 进入下一层递归树
			backtrack(nums);
			
			used[i] = false;
			// 取消选择
			track.removeLast();
		}
		
	}
// 组合	
//	List<List<Integer>> res = new LinkedList<>();
//	LinkedList<Integer> track = new LinkedList<>();
//    public List<List<Integer>> combine(int n, int k) {
//    	backtrack(1, n, k);
//    	return res;
//    }
//	
//	public void backtrack(int start, int n, int k) {
//		if (k == track.size()) {
//			res.add(new LinkedList<>(track));
//			return;
//		}
//		
//		// 回溯算法框架
//		for (int i = start; i <= n; i++) {
//			// 做选择
//			track.add(i);
//			// 
//			backtrack(i + 1, n, k);
//			// 撤销选择
//			track.removeLast();
//		}
//	}
	
	
	
//	/**
//	 * 子集
//	 * 输入：nums = [1,2,3]
//	 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//	 */
//	LinkedList<List<Integer>> res = new LinkedList<>();
//	
//	// track: 路径
//	LinkedList<Integer> track = new LinkedList<>();
//    public List<List<Integer>> subsets(int[] nums) {
//    	backtrack(nums, 0);
//    	return res;
//    }
//    
//    // 回溯
//    public void backtrack(int[] nums, int start) {
//		
//    	res.add(new LinkedList<>(track));
//    	
//    	for (int i = start; i < nums.length; i++) {
//			track.addLast(nums[i]);
//			backtrack(nums, i + 1);
//			track.removeLast();
//		}
//	}
}
