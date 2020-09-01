package 剑指Offer;

public class 面试题41_和为S的两个数字 {

	public int[] twoSum(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[0];
		}
		int i = 0, j = nums.length - 1;
		while (i < j) {
			if (nums[i] + nums[j] == target) {
				return new int[] {nums[i], nums[j]};
			}else if (nums[i] + nums[j] > target) {
				j--;
			}else if (nums[i] + nums[j] < target) {
				i++;
			}
		}
		return new int[] {nums[i], nums[j]};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
