package 前缀和数组;

import java.util.HashMap;

/**
 * 数组中和为k的连续子数组的个数
 * 输入: nums = [1、1、1]， k = 2
 * 输出: 2
 * 
 * 输入: nums = [1、2、3]， k = 3
 * 输出: 2
 * 
 * 前缀和数组: [1、1、3、6]
 * 
 * 解法步骤：
 * 1. 构造前缀和数组
 * 2. 穷举所有子数组
 * 3. 那么nums[j..i-1]的元素和即为：preSum[i - 1 + 1] - presum[j]
 */

public class LeeCode_560_和为K的子数组 {

	int subarraySum(int[] nums, int k) {
		int n = nums.length;
		int res = 0;
		int[] preNums = new int[nums.length + 1];
		
		preNums[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			preNums[i] = preNums[i - 1] + nums[i];
		}
		
		// 两次循环
		for (int i = 0; i < preNums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (preNums[i] - preNums[j] == k) {
					res++;
				}
			}
		}
		return res;
	}
	// 普通解法，两次遍历，时间复杂度O(n^2)
	int subarraySum(int[] nums, int k) {
		int n = nums.length;
		int[] preSum = new int[n+1];
		preSum[0] = 0;
		for (int i = 0; i < n; i++) {
			preSum[i+1] = preSum[i] + nums[i];
		}
		int res = 0;
		// 穷举所有子数组
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				// 子数组nums[j,,i-1]的元素和
				if (preSum[i] - preSum[j] == k) {
					// 也可以写成preSum[j] = preSum[i] - k
					res++;
				}
				
			}			
		}
		return res;
	}
	
	// 优化解法，时间复杂度(O(n))
	/**
	 * 上面的第二层循环记录的是有几个j能够获得preSum[i]和preSum[j]的差为k。每找到这样一个j，就把结果+1
	 */
	int subarraySum2(int[] nums, int k) {
		int n = nums.length;
		// HashMap: 前缀和 -> 该前缀和出现的次数
		HashMap<Integer, Integer> preSum = new HashMap<>();
		
		// base case
		preSum.put(0, 1);
		int res = 0, sum0_i = 0;
		for (int i = 0; i < n; i++) {
			sum0_i += nums[i];
			// 这是我们想找的前缀和num[0..j]
			int sum0_j = sum0_i - k;
			// 如果前面有这个前缀和，则直接更新答案
			if (preSum.containsKey(sum0_j)) {
				res += preSum.get(sum0_j);
			}
			// 把前缀和nums[0..i]加入并记录出现次数
			preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
		}
		return res;
	}
	
	
}
