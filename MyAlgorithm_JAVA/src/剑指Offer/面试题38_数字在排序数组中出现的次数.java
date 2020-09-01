package 剑指Offer;

public class 面试题38_数字在排序数组中出现的次数 {

	/*
	 * 遍历解法：时间复杂度O(N)
	 */
//    public int search(int[] nums, int target) {
//    	if (nums.length == 0) {
//			return 0;
//		}
//    	int index = 0;
//    	for (int i = 0; i < nums.length; i++) {
//			if (nums[i] == target) {
//				//计数索引i
//				index = i;
//				break;
//			}
//		}
//    	
//    	int count = 0;
//    	for (int j = index; j < nums.length; j++) {
//			if (nums[j] == target) {
//				count++;
//			}
//		}
//    	return count;
//    }
	
	/*
	 * 采用二分查找法：
	 * 
	 */
    public int search(int[] nums, int target) {
    	int left = left_bound(nums, target);
    	int right = right_bound(nums, target);
    	if (left == -1 && right == -1) {
			return 0;
		}
    	return right - left;
    }
    
	//寻找左侧边界的二分搜索 比如:[1、2、2、2、3]
	int left_bound(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) { 
			int mid = left + (right - left) / 2;
			if (nums[mid] >= target) {
				right = mid - 1;
			}else if (nums[mid] < target) {
				left = mid + 1;
			}
		}
		if (left >= nums.length || nums[left] != target) {
			return -1;
		}
		return left;
	}
	
	//寻找右侧边界的二分搜索 比如:[1、2、2、2、3]
	int right_bound(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] <= target) {
				left = mid + 1;
			}else if (nums[mid] > target) {
				//别返回，锁定右侧边界
				right = mid - 1;
			}
		}
		//检查right越界的情况
		if (right < 0 || nums[right] != target) {
			return -1;
		}
		return right;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
