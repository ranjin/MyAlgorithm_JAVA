/**
 * 移除数组nums中值为val的元素，返回移除后数组的新长度
 * 
 * 
 * slow
 *        fast     
 * [3,      2,      2,      3] val = 3  输出[2,  2]
 * 思路：
 * 当fast遇到值为val的元素，则直接跳过，否则赋值给slow指针，并让slow前进一步
 */

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
