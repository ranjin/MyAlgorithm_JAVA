package 查找和排序;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 */
public class LeeCode704_二分查找 {
	public int search(int[] nums, int target) {
		int left = 0; 
		int right = nums.length - 1;
		// 搜索区间为[left, right]
		while (left <= right) {
			// 获取mid用这种写法是为了防止(left + right) 溢出。容易超出int范围
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				// 搜索区间为[mid + 1, right]
				left = mid + 1;
			} else if (nums[mid] > target) {
				// 搜索区间为[left, mid - 1]
				right = mid - 1;
			}
		}
		return -1;
	}
}
