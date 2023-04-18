/**
 * 将数组中的所有零移动到数组末尾
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 思路：
 * 先删除数组中为0的元素，然后追加到数组末端
 */
public class Solution {
    public void moveZeroes(int[] nums) {

        if (nums.length == 0) {
            return;
        }

        int itemIndex = removeElement(nums, 0);

        for(int i = itemIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}