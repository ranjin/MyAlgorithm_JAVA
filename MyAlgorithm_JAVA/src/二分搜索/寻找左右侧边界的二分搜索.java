package 二分搜索;

/**
 * 有序数组：nums = [1, 2, 2, 2, 3] target = 2
 * 如果想得到target的左侧边界，即索引1，或者target的右侧边界，即索引3
 */
public class 寻找左右侧边界的二分搜索 {

	public int left_bound(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		// 搜索区间为[left, right]
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				// 收缩右侧边界
				right = mid - 1;
			} else if (nums[mid] < target) {
				// 搜索区间变为[mid + 1, right]
				left = mid + 1;
			} else if (nums[mid] > target) {
				// 搜索区间变为[left, mid - 1]
				right = mid - 1;
			}
		}
		// 判断target是否存在于nums中
		// 如果越界，target肯定不存在s，返回-1
		if (left < 0 || left >= nums.length) {
			return -1;
		}
		return nums[left] == target ? left : -1;
	}
	
	/**
	 * 寻找右侧边界的二分搜索
	 * 
	 */
	public int right_bound(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		// 搜索区间为[left, right]
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				// 收缩左侧边界
				left = mid + 1;
			} else if (nums[mid] < target) {
				// 搜索区间变为[mid + 1, right]
				left = mid + 1;
			} else if (nums[mid] > target) {
				// 搜索区间变为[left, mid - 1]
				right = mid - 1;
			}
		}
		// 判断target是否存在于nums中
		// 如果越界，target肯定不存在s，返回-1
		if (right < 0 || right >= nums.length) {
			return -1;
		}
		return nums[right] == target ? left : -1;
	}
}
