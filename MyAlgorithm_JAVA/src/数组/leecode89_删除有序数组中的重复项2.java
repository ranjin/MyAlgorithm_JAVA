package LC_初级算法;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
 * 使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 *
 */
public class LeeCode89_删除有序数组中的重复项2 {
    public int removeDuplicates(int[] nums) {
    	int n = nums.length;
    	if (n <= 2) {
			return n;
		}
    	int slow = 2, fast = 2;
    	while (fast < n) {
			// 如果大于1
			if (nums[slow - 2] != nums[fast]) {	// 表示有超过2个一样的元素了
				nums[slow] = nums[fast];
				slow++;
			}
			
			fast++;
		}
    	return slow;
    }
}
