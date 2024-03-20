package 数组;

/*
 给你一个有序数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。
 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 [0,	1,		1,	 	2,		2,		3,		3,		4]
 slow
 fast
 技巧：
 双指针；
 双指针都赋值为0的位置。让慢指针slow走在后面。快指针fast走在前面。
 找到一个不重复的元素就赋值给slow，并让slow前进一步。
 这样就保证了nums[0...slow]都是无重复的元素，当fast指针遍历完整个数组。nums[0...slow]就是去重后的结果。
 */

public class leecode26_删除有序数组中的重复项 {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int slow = 0, fast = 0;
		while(fast < nums.length) {
			if (nums[fast] == nums[slow]) {
				fast++;
			} else {
				slow++;
				nums[slow] = nums[fast];
				fast++;
			}
		}
		return slow + 1;
	}
}