package 二分搜索;

/**
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 */
public class leecode34_排序数组中查找元素的第一个和最后一个位置 {

	int[] result = new int[2];
	
    public int[] searchRange(int[] nums, int target) {
    	int left = left_bound(nums, target);
    	result[0] = left;
    	
    	int right= right_bound(nums, target);
    	result[1] = right;
    	return result;
    }
	
    
    public static int left_bound(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if (nums[mid] == target) {
				right = mid - 1;
			} else if (nums[mid] < target){
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			}
		}
		if (left < 0 || left > nums.length) {
			return -1;
		}
		return nums[left] == target ? left : -1;
	}
    
    public static int right_bound(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if (nums[mid] == target) {
				left = mid + 1;
			} else if (nums[mid] < target){
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			}
		}
		if (right < 0 || right > nums.length) {
			return -1;
		}
		return nums[right] == target ? right : -1;
	}
}
