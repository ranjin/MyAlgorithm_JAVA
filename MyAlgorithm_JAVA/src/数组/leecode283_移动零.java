package 数组;
/**
 * 将数组中的所有零移动到数组末尾
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 思路：
 * 先根据移动元素题目一样。先删除数组中为0的元素，然后将剩余的元素赋值为0.
 */
public class leecode283_移动零 {
    public void moveZeroes(int[] nums) {
    	
    	int n = nums.length;
    	if (n == 0) {
			return;
		}
    	
    	/// 删除数组中为0的元素，然后赋值剩余为0的
    	int legalCount = removeElement(nums, 0);
    	
    	for (int i = legalCount; i < nums.length; i++) {
			nums[i] = 0;
		}
    }
    
    /// 类似删除数组中的指定值的元素
    public int removeElement(int[] nums, int val) {
    	int fast = 0, slow = 0;
    	while (fast < nums.length) {
			if (nums[fast] == val) {
				fast++;
			} else {
				nums[slow] = nums[fast];
				slow++;
				fast++;
			}
		}
    	return slow;
	}
}