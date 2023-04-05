package 前缀和;

import java.util.Iterator;

/**
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * 
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 */
public class leecode_303_区域和检索_数组不变 {
	
	/**
	 * 普通解法：
	 */
	private int[] nums;
	public void NumArray(int[] nums) {
		this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
    	int res = 0;
    	for (int i = left; i < right; i++) {
			res += nums[i];
		}
    	return res;
    }
    
    /**
     * 前缀和技巧：
     * 构造一个preSum数组，preSum[i]表示nums[0, i - 1]的元素之和
     * 
     * 那么区间[1, 4]内的元素之和 = nums[0, 4] - nums[0, 1],即preSum[5] - preSum[1]
     * 
     * 那么区间[2, 3]内的元素之和 = nums[0, 3] - nums[0, 2],即preSum[4] - preSum[3]

     */
    
	// 前缀和数组
    private int[] preSum;
    
	public leecode_303_区域和检索_数组不变(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		preSum = new int[nums.length];
		// 计算nums的累加和
		preSum[0] = 0;	// preSum[0] = 0,便于计算累加和
		for (int i = 1; i < preSum.length; i++) {
			preSum[i] = preSum[i - 1] + nums[i - 1];
		}
    }
    
    public int sumRange2(int left, int right) {
    	return preSum[right + 1] - preSum[left];
    }
}

















