package 数组;

import java.util.HashMap;

public class testDemo {


    public int[] twoSum(int[] nums, int target) {

    	
    	if (nums.length <= 0) {
			return new int[0];
		}
    	    	
    	for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
    	return new int[] {};
    	
    	
    }
    
    public int[] twoSum2(int[] nums, int target) {
    	/// 哈希表：值到索引的映射(val, index)
    	HashMap<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
			int need  = target - nums[i];
			if (valueToIndex.containsKey(need)) {
				return new int[] {valueToIndex.get(need), i};
			}
			valueToIndex.put(nums[i], i);
		}
    	return null;
    }
}
