package 数组;

/*
 给你一个有序数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。
 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
      slow
                      fast 
 [0,	1,		0,	1,	1,	1,	2,	2,	3,	3,	4]
 思路：双指针
 
 slow、fast指针，初始为0
 1. 如果元素相等，fast++
 2. 如果元素不等，
 - slow++
 - nums[slow] = nums[fast]
 - fast++
 3. 直至fast 超过数组大小
 */

//     
//slow fast
// 0	1	1	2	2	3
public class leecode26_删除有序数组中的重复项 {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int slow = 0, fast = 1;
		while(fast < nums.length) {
			if (nums[slow] != nums[fast]) {
				slow++;
				nums[slow] = nums[fast];
			}
			fast++;
		}
		return slow + 1;
	}
}