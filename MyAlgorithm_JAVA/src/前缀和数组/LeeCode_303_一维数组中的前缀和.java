package 前缀和数组;

public class LeeCode_303_一维数组中的前缀和 {

	/**
	 * 普通解法
	 * 时间复杂度：O(N),会频繁调用sumRange方法
	 */
	class NumArray {
		private int[] nums;
	    public NumArray(int[] nums) {
	    	this.nums = nums;
	    }
	    
	    // 查询闭区间[left, right]的累加和
	    public int sumRange(int left, int right) {
	    	int res = 0;
	    	for (int i = left; i <= right; i++) {
				res += nums[i];
			}
	    	return res;
	    }
	}
	
	/**
	 * 前缀和
	 * index: 		0		1		2		3		4		5		
	 * 
	 * nums:  				3		5		2		-2		4		1
	 * preSum:		0		3		8		10		8		12		13
	 */
	class NumArray2 {
		private int[] preSum;
		// 输入一个数组，构造前缀和
	    public NumArray2(int[] nums) {
	    	// preSum[0] = 0, 便于计算累加和
	    	preSum = new int[nums.length + 1];
	    	for (int i = 1; i < preSum.length; i++) {
	    		// 计算nums的累加和
				preSum[i] = preSum[i - 1] + nums[i - 1];
			}
	    }
	    
	    // 查询闭区间[left, right]的累加和
	    public int sumRange(int left, int right) {
	    	return preSum[right+1] - preSum[left];
	    }
	}
}
