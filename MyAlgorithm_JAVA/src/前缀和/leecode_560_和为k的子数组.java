package 前缀和;

import java.util.Iterator;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class leecode_560_和为k的子数组 {

    public int subarraySum(int[] nums, int k) {

    	if (nums == null || nums.length == 0) {
			return 0;
		}
    	int preSum[] = new int[nums.length + 1];
    	preSum[0] = 0;
    	for (int i = 1; i < preSum.length; i++) {
			preSum[i] = preSum[i - 1] + nums[i - 1];
		}
    	
    	int res = 0;
    	// nums[j, i - 1]的元素和  
    	for (int i = 1; i <= nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (preSum[i] - preSum[j] == k) {
					res++;
				}
			}
		}
    	return res;
    }
}
