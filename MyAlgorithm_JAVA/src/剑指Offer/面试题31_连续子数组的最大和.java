package 剑指Offer;

public class 面试题31_连续子数组的最大和 {

	/*
	 * 动态规划的思想
	 * 函数f(i)表示以第i个数字结尾的子数组的最大和。
	 * f(i) = {
	 * 			pData[i] i = 0或者f(i-1) <= 0
	 * 			f(i-1) + pData[i] i != 0并且f(i-1) > 0'
	 * 		  }
	 * 
	 */
	public int maxSubArray(int[] nums) {
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i] += Math.max(nums[i-1], 0);
			res = Math.max(res, nums[i]);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
