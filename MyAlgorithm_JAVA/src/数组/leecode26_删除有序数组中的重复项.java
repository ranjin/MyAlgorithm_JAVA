package LC_初级算法;

/*
 给你一个有序数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。
 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 
 思路：双指针
 
 slow、fast指针，初始为0，1
 1. 如果元素相等，fast后移
 2. 如果元素相等，设置slow后面的元素为fast索引上的元素，slow++，fast++
 3. 直至fast 超过数组大小
 */

public class leecode_26_删除有序数组中的重复项 {
	public int removeDuplicates(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}
		int slow = 0;
		int fast = 0;

		while (fast < nums.length) {
			if (nums[slow] != nums[fast]) {
				slow++;
				// 维护nums[0...slow]无重复
				nums[slow] = nums[fast];
			}
			fast++;
		}
		return slow + 1;
	}
}