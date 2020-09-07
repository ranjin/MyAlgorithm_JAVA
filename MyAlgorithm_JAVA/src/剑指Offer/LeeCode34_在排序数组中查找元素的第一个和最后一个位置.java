package 剑指Offer;

import java.util.function.LongToDoubleFunction;

public class LeeCode34_在排序数组中查找元素的第一个和最后一个位置 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return lef
	}

    public int[] searchRange(int[] nums, int target) {
    	return new int[] {leftBounds(nums, target), rightBounds(nums, target)};
    	return leftBounds(nums, target) + leftBounds(nums, target)
    }
	/*
	 * 二分查找
	 */
	public static int leftBounds(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				right = mid - 1;
			}else if (nums[mid] > target) {
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
	
	public static int rightBounds(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				left = mid + 1;
			}else if (nums[mid] < target) {
				left = mid + 1;
			}else if (nums[mid] > target) {
				right = mid - 1;
			}
		}
		if (right < 0 || nums[right] != target) {
			return -1;
		}
		return right;
	}
}





